package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


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
	
	public void recursosPorTipo(String tipo) {
		//System.out.println("   Recursos del tipo " + tipo + "   ");
		//for (Recurso r : recursos) {
			//if (r.getTipo().equalsIgnoreCase(tipo)) {
				//System.out.println(r);
			//}
		//}
	}
	
	public void addUsuario(Usuarios u) {
		usuarios.add(u);
	}
	
	public void addRecurso(Recurso r) {
		recursos.add(r);
	}

	public void prestar(String idUsuario, String idRecurso) {
		//Usuarios u = buscarUsuario(idUsuario);
		//Recurso r = buscarRecurso(idRecurso);
		//if (u == null || r == null) {
			//System.out.println("Usuario o recurso inexistente");
			//return;
		//}
		//if (!r.isDisponible()) {
			//System.out.println("El recurso ya está prestado");
			//return;
		//}
		
		//r.setDisponible(false);
		//Prestamo p = new Prestamo(u, r, new Date());
		//prestamos.add(p);

		//System.out.println("Préstamo realizado: " + p);
		//}
	}
	
	public void devolver(String idRecurso) {
		//Recurso r = buscarRecurso(idRecurso);
		//if (r == null) {
			//System.out.println("Recurso inexistente");
			//return;
		//}
		//if (r.isDisponible()) {
			//System.out.println("El recurso no está prestado");
			//return;
		//}
		
		//for (Prestamo p : prestamos) {
			//if (p.getRecurso().getId().equals(idRecurso) && p.estaActivo()) {
				//p.setFechaDevolucion(new Date());
				//r.setDisponible(true);
				//System.out.println("Devolución registrada: " + p);
				//return;
			//}
		//}
		//System.out.println("No se encontró préstamo activo para ese recurso.");
	}
	
	private Usuarios buscarUsuario(String id) {
		//for (Usuarios u : usuarios) {
			//if (u.getId().equals(id)) return u;
		//}
		return null;
	}
	
	private Recurso buscarRecurso(String id) {
		//for (Recurso r : recursos) {
			//if (r.getId().equals(id)) return r;
		//}
		return null;
	}	
}
