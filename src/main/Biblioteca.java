package main;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Usuarios> usuarios;
	private List<Recurso> recursos;
	private List<Prestamo> prestamos;
	
	public Biblioteca() {
		usuarios = new ArrayList<Usuarios>();
		recursos = new ArrayList<Recurso>();
		prestamos = new ArrayList<Prestamo>();
	}

}
