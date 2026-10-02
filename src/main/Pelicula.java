package main;

public class Pelicula extends Recurso {
	private String director;
	private int duracion;

	public Pelicula(int id, String titulo, int anio, boolean disponible, String director, int duracion) {
		super(id, titulo, anio, disponible);
		this.director = director;
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String getTipo() {
		return "PELICULA";
	}

	@Override
	public String toCSV() {
		return "PELICULA;" + id + ";" + titulo + ";" + anio + ";" + disponible + ";" + director + ";" + duracion;
	}

	@Override
	public String toString() {
		return super.toString() + " | Director: " + director + " | Duración: " + duracion + " min";
	}
}