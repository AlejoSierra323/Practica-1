package main;

public abstract class Recurso {

	protected int id;
	protected String titulo;
	protected int año;
	protected boolean disponible;

	public Recurso(int id, String titulo, int año, boolean disponible) {
		this.id = id;
		this.titulo = titulo;
		this.año = año;
		this.disponible = disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String nombre) {
		this.titulo = nombre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
	}

