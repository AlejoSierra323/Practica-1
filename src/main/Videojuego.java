package main;

public class Videojuego extends Recurso{
	
	private String plataforma;
	private int pegi;
	
	 public Videojuego(int id, String titulo, int anio, boolean disponible, String plataforma, int pegi) {
	        super(id, titulo, anio, disponible);
	        this.plataforma = plataforma;
	        this.pegi = pegi;
	 }

}
