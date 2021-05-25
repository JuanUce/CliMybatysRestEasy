package com.programacion.servicio;

import java.util.List;


import com.programacion.db.Autor;

public interface AutorServicio {

	public List<Autor> listAutores()throws Exception ;
	
	public Autor buscarBAutores(Long id)throws Exception;
	
	public void insertar(Autor aut)throws Exception;
	
	public void deleteAut(Long id)throws Exception;
	
	public void actualActor(Autor aut)throws Exception;
	
	
	
}
