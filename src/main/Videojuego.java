package main;

public class Videojuego extends Recurso {

	private String plataforma;
	private int pegi;

	public Videojuego(int id, String titulo, int anio, boolean disponible, String plataforma, int pegi) {
		super(id, titulo, anio, disponible);
		this.plataforma = plataforma;
		this.pegi = pegi;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	@Override
	public String getTipo() {
		return "VIDEOJUEGO";
	}

	@Override
	public String toCSV() {
		return "VIDEOJUEGO;" + id + ";" + titulo + ";" + anio + ";" + disponible + ";" + plataforma + ";" + pegi;
	}

	@Override
	public String toString() {
		return super.toString() + " | Plataforma: " + plataforma + " | PEGI: +" + pegi;
	}
}