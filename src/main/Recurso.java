package main;

public abstract class Recurso {
	
	protected int id;
	protected String nombre;
	protected int año;
	protected boolean disponible;
	
	public Recurso(int id, String nombre, int año, boolean disponible) {
		this.id = id;
		this.nombre = nombre;
		this.año = año;
        this.disponible = disponible;	
    }
	
	
	
	
	
}
