package main;

public abstract class Recurso {

	protected int id;
	protected String titulo;
	protected int anio;
	protected boolean disponible;

	public Recurso(int id, String titulo, int anio, boolean disponible) {
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public abstract String getTipo();

	public abstract String toCSV();

	@Override
	public String toString() {
		return "[" + getTipo() + "] ID: " + id + " | Título: '" + titulo + "' | Año: " + anio + " | Estado: "
				+ (disponible ? "Disponible" : "Prestado");
	}
}
