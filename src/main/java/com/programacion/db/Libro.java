package com.programacion.db;

public class Libro {

	private Long id;
	private String isbn;
	private String title;
	private Long autor_id;

	
	
	public Libro() {
    }
	public Libro(Long id, Long autor_id, String isbn, String title) {
        this.id = id;
        this.autor_id=autor_id;
        this.isbn=isbn;
        this.title=title;
    }
	
	public Libro( Long autor_id, String isbn, String title) {
        this.autor_id=autor_id;
        this.isbn=isbn;
        this.title=title;
    }
  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAutor_id() {
		return autor_id;
	}
	public void setAutor_id(Long autor_id) {
		this.autor_id = autor_id;
	}
	
	
	
}
