package main;

import java.time.LocalDate;
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
		System.out.println("   Recursos Disponibles   ");
		for (Recurso rec : recursos) {
			if (rec.isDisponible()) {
				System.out.println(rec);
			}
		}
	}
	
	public void listarRecursosPrestados() {
		System.out.println("   Recursos prestados   ");
		for (Recurso re : recursos) {
			if (!re.isDisponible()) {
				System.out.println(re);
			}
		}
	}
	
	public void buscarPorTitulo(String titulo) {
		System.out.println("   Busqueda por titulo " + titulo + "   ");
		for (Recurso recurso : recursos) {
			if(recurso.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				System.out.println(recursos);
			}
		}
	}
	
	public void prestamosDeUsuario(int idUsuario) {
		System.out.println("   Préstamos del usuario " + idUsuario + "   ");
		for (Prestamo p : prestamos) {
			if (p.getUsuarios().getId() == (idUsuario)) {
				System.out.println(p);
			}
		}

	}
	
	public void prestamosActivos() {
		System.out.println("   Prestamos activos   ");
		for (Prestamo pre : prestamos) {
			if(pre.getEstado().equals("ACTIVO")) {
				System.out.println(pre);
			}	
		}
	}
	
	public void recursosPorTipo(String tipo) {
		System.out.println("   Recursos del tipo " + tipo + "   ");
		for (Recurso r : recursos) {
			if (r.getTipo().equalsIgnoreCase(tipo)) {
				System.out.println(r);
			}
		}
	}
	
	public void addUsuario(Usuarios u) {
		usuarios.add(u);
	}
	
	public void addRecurso(Recurso r) {
		recursos.add(r);
	}

	public void prestar(int idUsuario, int idRecurso) {
		Usuarios u = buscarUsuario(idUsuario);
		Recurso r = buscarRecurso(idRecurso);
		if (u == null || r == null) {
			System.out.println("Usuario o recurso inexistente");
			return;
		}
		if (!r.isDisponible()) {
			System.out.println("El recurso ya está prestado");
			return;
		}
		
		r.setDisponible(false);
		Prestamo p = new Prestamo(u, r);
		prestamos.add(p);

		System.out.println("Préstamo realizado: " + p);
	}

	
	public void devolver(int idRecurso) {
		Recurso r = buscarRecurso(idRecurso);
		if (r == null) {
			System.out.println("Recurso inexistente");
			return;
		}
		if (r.isDisponible()) {
			System.out.println("El recurso no está prestado");
			return;
		}
		
		for (Prestamo p : prestamos) {
			if (p.getRecurso().getId() == (idRecurso) && p.getEstado().equals("ACTIVO")) {
				p.setFechaDevolucion(LocalDate.now());
				r.setDisponible(true);
				System.out.println("Devolución registrada: " + p);
				return;
			}
		}
		System.out.println("No se encontró préstamo activo para ese recurso.");
	}
	
	private Usuarios buscarUsuario(int id) {
		for (Usuarios u : usuarios) {
			if (u.getId() == (id)) return u;
		}
		return null;
	}
	
	private Recurso buscarRecurso(int id) {
		for (Recurso r : recursos) {
			if (r.getId() == (id)) return r;
		}
		return null;
	}
	public boolean agregarUsuario(Usuarios usuario) {
		if (buscarUsuario(usuario.getId()) != null) {
			System.out.println("Error. Ya existe un usuario con ese ID.");
			return false;
	}
		usuarios.add(usuario);
		return true;
	}
	public boolean agregarRecurso(Recurso recurso) {
		if (buscarRecurso(recurso.getId()) != null) {
			System.out.println("Error. Ya existe un recurso con este ID.");
	        return false;
	    }
		recursos.add(recurso);
		return true;
	}
	
	public boolean eliminarUsuario(int id) {
		Usuarios usuario = buscarUsuario(id);
		if (usuario == null) {
			System.out.println("Error. Usuario inexistente.");
			return false;
	    }
		usuarios.remove(usuario);
	    return true;
	}
	

}
