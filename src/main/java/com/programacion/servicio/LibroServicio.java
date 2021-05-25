package com.programacion.servicio;

import java.util.ArrayList;
import java.util.List;

import com.programacion.db.Libro;



public interface LibroServicio {
	
	public List<Libro> todoslibros()throws Exception;
	
	public ArrayList<Libro> listarLibrosAutor(int id)throws Exception;

	public Libro buscaLibro(int id)throws Exception;

	public void CreateLibro(Libro aut)throws Exception;

	public void deleteLibro(int id)throws Exception;

	public void actualizarBook(Libro autor)throws Exception;
}
