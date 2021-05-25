package com.distribuida.servlet;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.programacion.db.Autor;
import com.programacion.servicio.AutorServicio;




@WebServlet(urlPatterns = "/")
public class AutorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AutorServicio servicio; 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("/servlet autor");
	//	ArrayList<Autor> autor;
		//try {
			//autor = servicio.listAutores();
			//req.setAttribute("autores", autor);
		//	req.getRequestDispatcher("/Autor.jsp").forward(req, resp);
		//} catch (Exception e) {
			
			//e.getMessage();
	//	}
		String action = req.getServletPath();
System.out.println("Devuelve"+action);
		switch (action) {
		case "/new":
			showNewForm(req, resp);
			break;

		case "/insert":
			try {
				insertAutor(req, resp);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "/delete":
			try {
				deleteAutor(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/edit":
			try {
				ByAutor(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/update":
			try {
				updateAutor(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/list":

			try {
				listAutor(req, resp);
				//showNewForm(req, resp);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
    
		
		
	}


	public void listAutor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 List<Autor> autor = servicio.listAutores();
	        request.setAttribute("autor", autor);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("AutorList.jsp");
	        dispatcher.forward(request, response);
		

	}
	
	
	public void deleteAutor(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		Long id = Long.parseLong(request.getParameter("id"));	 
		servicio.deleteAut(id);
		 System.out.println("Pasa eliminar");
        response.sendRedirect("list");

	}
	
	public void updateAutor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id=Long.parseLong(request.getParameter("id"));
		Long edad = Long.parseLong(request.getParameter("edad"));
        String genero = request.getParameter("genero");
        String nombre = request.getParameter("nombre");
 
        Autor aut = new Autor(id,edad, genero, nombre);  
        servicio.actualActor(aut);
        System.out.println("Pasa actualizar");
        response.sendRedirect("list");

	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAutor.jsp");
        dispatcher.forward(request, response);

	}
	
	public void insertAutor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long edad = Long.parseLong(request.getParameter("edad"));
		String genero = request.getParameter("genero");
		String nombre = request.getParameter("nombre");

		Autor aut = new Autor(edad,genero, nombre);
		
		servicio.insertar(aut);
		response.sendRedirect("list");
	}
	
	public void ByAutor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long id = Long.parseLong(request.getParameter("id"));
		Autor autor=servicio.buscarBAutores(id);
		RequestDispatcher ds = request.getRequestDispatcher("FormAutor.jsp");
		request.setAttribute("autor", autor);
		ds.forward(request, response);
	}
	
	
	

}
