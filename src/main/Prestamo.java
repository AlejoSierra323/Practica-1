package main;

import java.time.LocalDate;

public class Prestamo {

	private Usuarios usuarios;
	private Recurso recurso;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private String estado;

	public Prestamo(Usuarios usuarios, Recurso recurso) {
		this.usuarios = usuarios;
		this.recurso = recurso;
		this.fechaPrestamo = LocalDate.now();
		this.estado = "ACTIVO";
		this.fechaDevolucion = null;
	}

	public Prestamo(Usuarios usuarios, Recurso recurso, LocalDate fechaPrestamo, LocalDate fechaDevolucion,
			String estado) {
		this.usuarios = usuarios;
		this.recurso = recurso;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.estado = estado;
	}

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

	public String toCSV() {
		String fDev = (fechaDevolucion != null) ? fechaDevolucion.toString() : "null";
		return usuarios.getId() + ";" + recurso.getId() + ";" + fechaPrestamo + ";" + fDev + ";" + estado;
	}

	@Override
	public String toString() {
		return "Préstamo [Usuario: " + usuarios.getNombre() + " (ID " + usuarios.getId() + ") | Recurso: '"
				+ recurso.getTitulo() + "' (ID " + recurso.getId() + ") | Fecha Préstamo: " + fechaPrestamo
				+ " | Estado: " + estado + " | Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "Pendiente")
				+ "]";
	}
}