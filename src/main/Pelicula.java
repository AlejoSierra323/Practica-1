package main;

public class Pelicula extends Recurso {
	private String director;
	private int duracion;
	
	 public Pelicula(int id, String titulo, int anio, boolean disponible, String director, int duracion) {
	        super(id, titulo, anio, disponible);
	        this.director = director;
	        this.duracion = duracion;
	 }
}
