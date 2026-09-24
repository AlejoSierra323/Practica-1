package main;

public class Libro extends Recurso {
	private String autor;
	private int paginas;
	
	public Libro (int id, String nombre, int año, boolean disponible, String autor, int paginas) {
		 super(id, nombre, año, disponible);
		 this.autor = autor;
		 this.paginas = paginas;
	 }

}
