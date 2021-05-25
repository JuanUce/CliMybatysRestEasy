package com.distribuida.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.programacion.db.Autor;
import com.programacion.db.Libro;
import com.programacion.servicio.LibroServicio;


@WebServlet(urlPatterns = "/")
public class LibroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private LibroServicio servicio;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	PrintWriter pw = resp.getWriter();
	//	pw.println("libro");
		//int codigo = Integer.parseInt(req.getParameter("id"));
		
	//	ArrayList<Libro> lib;
	//	try {
		//	lib = servicio.listarLibrosAutor(codigo);
	//		req.setAttribute("libros", lib);
			//req.getRequestDispatcher("/Libro.jsp").forward(req, resp);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.getMessage();
	//	}
		
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

		switch (action) {
		case "/new":
			showNewForm(req, resp);
			break;

		case "/insert":
			try {
				insertLibro(req, resp);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "/delete":
			try {
				deleteLibro(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/edit":
			try {
				ByLibro(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/update":
			try {
				updateLibro(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:

			try {
				listLibro(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
    
		
		
	}
	

	public void listLibro(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 List<Libro> libro = servicio.todoslibros();
	        request.setAttribute("libro", libro);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LibroList.jsp");
	        dispatcher.forward(request, response);
		

	}
	
	
	public void deleteLibro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));	 
		servicio.deleteLibro(id);
        response.sendRedirect("list");

	}
	
	public void updateLibro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = Long.parseLong(request.getParameter("id"));
		Long autor_id = Long.parseLong(request.getParameter("autor_id"));
		String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        
 
        Libro lib = new Libro(id, autor_id,isbn,title);

        servicio.actualizarBook(lib);
        response.sendRedirect("list");

	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormLibro.jsp");
        dispatcher.forward(request, response);

	}
	
	public void insertLibro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long autor_id = Long.parseLong(request.getParameter("autor_id"));
		String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
   
 
        Libro lib = new Libro( autor_id,isbn,title);
        servicio.CreateLibro(lib);
        response.sendRedirect("list");
	}
	
	public void ByLibro(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro=servicio.buscaLibro(id);
		RequestDispatcher ds = request.getRequestDispatcher("FormLibro.jsp");
		request.setAttribute("libro", libro);
		ds.forward(request, response);
	}
	
	
	
	
	

}
