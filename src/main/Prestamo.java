
package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {

	private Usuarios usuarios;
	private Recurso recurso;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private String estado;

	// Constructor básico
	public Prestamo(Usuarios usuarios, Recurso recurso) {
		super();
		this.usuarios = usuarios;
		this.recurso = recurso;
		this.fechaPrestamo = LocalDate.now();
		this.estado = "ACTIVO";
		this.fechaDevolucion = null;
	}


	
	public static Prestamo registrarNuevoPrestamo(String idUsuario, String idRecurso, ArrayList<Usuarios> listaUsuarios,
			ArrayList<Recurso> listaRecurso) {

		// Buscar usuario
		Usuarios usuarioEncontrado = null;
		for (Usuarios user : listaUsuarios) {
			if (user.getIdentificador().equals(idUsuario)) {
				usuarioEncontrado = user;
				break;
			}
		}

		if (usuarioEncontrado == null) {
			System.out.println("ERROR : El usuario con ID " + idUsuario + " no ha sido encontrado");
			return null;
		}

		// Buscar recurso
		Recurso recursoEncontrado = null;
		for (Recurso recur : listaRecurso) {
			if (recur.getIdentificador().equals(idRecurso)) {
				recursoEncontrado = recur;
				break;
			}
		}

		if (recursoEncontrado == null) {
			System.out.println("ERROR El recurso con ID: " + idRecurso + " no ha sido encontrado");
			return null;
		}

		// Comprobar si ya está prestado
		if (!recursoEncontrado.isDisponible()) {
			System.out.println("ERROR: El recurso " + recursoEncontrado.getTitulo() + " ya ha sido prestado");
			return null;
		}

		// CAMBIOS AQUÍ: Marcamos como NO disponible y creamos el objeto préstamo
		recursoEncontrado.setDisponible(false);
		Prestamo nuevoPrestamo = new Prestamo(usuarioEncontrado, recursoEncontrado);

		System.out.println("ÉXITO: Recurso prestado correctamente.");
		return nuevoPrestamo; // Devolvemos el préstamo creado
	}

	// 2. REGISTRAR DEVOLUCIÓN (FÁCIL)
	
	public static boolean devolverRecurso(String idRecurso, ArrayList<Prestamo> listaPrestamos) {

		// Buscamos el préstamo que esté ACTIVO para ese recurso
		for (Prestamo p : listaPrestamos) {
			if (p.getRecurso().getIdentificador().equals(idRecurso) && p.getEstado().equals("ACTIVO")) {

				// Al devolverlo, vuelve a estar disponible
				p.getRecurso().setDisponible(true);

				// Actualizamos los datos del préstamo
				p.setEstado("DEVUELTO");
				p.setFechaDevolucion(LocalDate.now());

				System.out.println("ÉXITO: El recurso '" + p.getRecurso().getTitulo() + "' ha sido devuelto.");
				return true;
			}
		}

		System.out.println("ERROR: No se encontró ningún préstamo ACTIVO para el recurso con ID: " + idRecurso);
		return false;
	}

	// Getters y Setters
	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
