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
	
	public void listarRecursosDisponibles() {
		//System.out.println("   Recursos Disponibles   ");
		//for (Recurso rec : recursos) {
			//if (rec.isDisponible()) {
				//System.out.println(rec);
			//}
		//}
	}
	
	public void listarRecursosPrestados() {
		//System.out.println("   Recursos prestados   ");
		//for (Recurso re : recursos) {
			//if (!re.isDisponible()) {
				//System.out.println(re);
			//}
		//}
	}
	
	public void buscarPorTitulo(String titulo) {
		//System.out.println("   Busqueda por titulo " + titulo + "   ");
		//for (Recurso recurso : recursos) {
			//if(recurso.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				System.out.println(recursos);
			//}
		//}
	}
	
	public void prestamosDeUsuario(String idUsuario) {
		//System.out.println("   Préstamos del usuario " + idUsuario + "   ");
		//for (Prestamo p : prestamos) {
			//if (p.getUsuario().getId().equals(idUsuario)) {
				//System.out.println(p);
			//}
		//}

	}
	
	public void prestamosActivos() {
		//System.out.println("   Prestamos activos   ");
		//for (Prestamo pre : prestamos) {
			//if(pre.estaActivo()) {
				//System.out.println(pre);
			//}	
		//}
	}
}
