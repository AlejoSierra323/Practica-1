package main;

public class Libro extends Recurso {
	private String autor;
	private int paginas;

	public Libro(int id, String titulo, int anio, boolean disponible, String autor, int paginas) {
		super(id, titulo, anio, disponible);
		this.autor = autor;
		this.paginas = paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String getTipo() {
		return "LIBRO";
	}

	@Override
	public String toCSV() {
		return "LIBRO;" + id + ";" + titulo + ";" + anio + ";" + disponible + ";" + autor + ";" + paginas;
	}

	@Override
	public String toString() {
		return super.toString() + " | Autor: " + autor + " | Páginas: " + paginas;
	}
}