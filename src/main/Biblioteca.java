package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

	private List<Usuarios> usuarios;
	private List<Recurso> recursos;
	private List<Prestamo> prestamos;
	private Scanner sc;

	public Biblioteca() {
		usuarios = new ArrayList<>();
		recursos = new ArrayList<>();
		prestamos = new ArrayList<>();
		sc = new Scanner(System.in);
		cargarDatos();
	}

	private void cargarDatos() {
		GestorArchivos.cargarUsuarios(usuarios);
		GestorArchivos.cargarRecursos(recursos);
		GestorArchivos.cargarPrestamos(prestamos, usuarios, recursos);
	}

	private void guardarDatos() {
		GestorArchivos.guardarDatos(usuarios, recursos, prestamos);
	}

	public static void main(String[] args) {
		Biblioteca app = new Biblioteca();
		app.iniciarMenu();
	}

	public void iniciarMenu() {
		int opcion = -1;
		do {
			System.out.println("\n BIBLIOTECA MULTIMEDIA");
			System.out.println("1. Gestión de Usuarios (CRUD)");
			System.out.println("2. Gestión de Recursos (CRUD)");
			System.out.println("3. Préstamos y Devoluciones");
			System.out.println("4. Consultas y Búsquedas");
			System.out.println("0. Guardar y Salir");
			System.out.print("Seleccione una opción: ");

			opcion = leerEntero();

			switch (opcion) {
			case 1:
				menuUsuarios();
				break;
			case 2:
				menuRecursos();
				break;
			case 3:
				menuPrestamos();
				break;
			case 4:
				menuConsultas();
				break;
			case 0:
				guardarDatos();
				System.out.println("Datos guardados correctamente.");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 0);
	}

	private void menuUsuarios() {
		System.out.println("\n GESTIÓN DE USUARIOS ");
		System.out.println("1. Crear usuario");
		System.out.println("2. Listar usuarios");
		System.out.println("3. Buscar usuario por ID");
		System.out.println("4. Modificar usuario");
		System.out.println("5. Eliminar usuario");
		System.out.print("Opción: ");
		int op = leerEntero();

		switch (op) {
		case 1:
			System.out.print("ID: ");
			int id = leerEntero();
			if (buscarUsuario(id) != null) {
				System.out.println("Error. Ya existe un usuario con ID " + id);
				return;
			}
			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Correo: ");
			String correo = sc.nextLine();
			agregarUsuario(new Usuarios(id, nombre, correo));
			System.out.println("Usuario creado.");
			break;
		case 2:
			listarUsuarios();
			break;
		case 3:
			System.out.print("ID a buscar: ");
			Usuarios u = buscarUsuario(leerEntero());
			System.out.println(u != null ? u : "Usuario no encontrado.");
			break;
		case 4:
			System.out.print("ID a modificar: ");
			int idMod = leerEntero();
			Usuarios uMod = buscarUsuario(idMod);
			if (uMod != null) {
				System.out.print("Nuevo Nombre: ");
				uMod.setNombre(sc.nextLine());
				System.out.print("Nuevo Correo: ");
				uMod.setCorreoElectronico(sc.nextLine());
				System.out.println("Usuario actualizado.");
			} else {
				System.out.println("Usuario no encontrado.");
			}
			break;
		case 5:
			System.out.print("ID a eliminar: ");
			eliminarUsuario(leerEntero());
			break;
		}
	}

	private void menuRecursos() {
		System.out.println("\n GESTIÓN DE RECURSOS ");
		System.out.println("1. Crear recurso");
		System.out.println("2. Listar todos los recursos");
		System.out.println("3. Buscar recurso por ID");
		System.out.println("4. Modificar recurso");
		System.out.println("5. Eliminar recurso");
		System.out.print("Opción: ");
		int op = leerEntero();

		switch (op) {
		case 1:
			crearRecurso();
			break;
		case 2:
			for (Recurso r : recursos)
				System.out.println(r);
			break;
		case 3:
			System.out.print("ID a buscar: ");
			Recurso r = buscarRecurso(leerEntero());
			System.out.println(r != null ? r : "Recurso no encontrado.");
			break;
		case 4:
			modificarRecurso();
			break;
		case 5:
			System.out.print("ID a eliminar: ");
			eliminarRecurso(leerEntero());
			break;
		}
	}

	private void menuPrestamos() {
		System.out.println("\n PRÉSTAMOS Y DEVOLUCIONES ");
		System.out.println("1. Realizar préstamo");
		System.out.println("2. Devolver recurso");
		System.out.print("Opción: ");
		int op = leerEntero();

		if (op == 1) {
			System.out.print("ID Usuario: ");
			int idU = leerEntero();
			System.out.print("ID Recurso: ");
			int idR = leerEntero();
			prestar(idU, idR);
		} else if (op == 2) {
			System.out.print("ID Recurso a devolver: ");
			int idR = leerEntero();
			devolver(idR);
		}
	}

	private void menuConsultas() {
		System.out.println("\nCONSULTAS");
		System.out.println("1. Recursos disponibles");
		System.out.println("2. Recursos prestados");
		System.out.println("3. Búsqueda por título");
		System.out.println("4. Préstamos de un usuario");
		System.out.println("5. Préstamos activos");
		System.out.println("6. Recursos por tipo (LIBRO, PELICULA, VIDEOJUEGO)");
		System.out.println("7. Consulta adicional: Recursos por año de publicación");
		System.out.println("8. Consulta adicional: Historial completo de devoluciones");
		System.out.print("Opción: ");
		int op = leerEntero();

		switch (op) {
		case 1:
			listarRecursosDisponibles();
			break;
		case 2:
			listarRecursosPrestados();
			break;
		case 3:
			System.out.print("Título a buscar: ");
			buscarPorTitulo(sc.nextLine());
			break;
		case 4:
			System.out.print("ID de usuario: ");
			prestamosDeUsuario(leerEntero());
			break;
		case 5:
			prestamosActivos();
			break;
		case 6:
			System.out.print("Tipo: ");
			recursosPorTipo(sc.nextLine());
			break;
		case 7:
			System.out.print("Introduce el año: ");
			recursosPorAnio(leerEntero());
			break;
		case 8:
			historialDevoluciones();
			break;
		}
	}

	private void crearRecurso() {
		System.out.print("ID: ");
		int id = leerEntero();
		if (buscarRecurso(id) != null) {
			System.out.println("Error. ID de recurso en uso.");
			return;
		}
		System.out.print("Título: ");
		String titulo = sc.nextLine();
		System.out.print("Año: ");
		int anio = leerEntero();

		System.out.println("Tipo: 1. Libro | 2. Película | 3. Videojuego");
		int t = leerEntero();
		if (t == 1) {
			System.out.print("Autor: ");
			String autor = sc.nextLine();
			System.out.print("Páginas: ");
			int pag = leerEntero();
			agregarRecurso(new Libro(id, titulo, anio, true, autor, pag));
		} else if (t == 2) {
			System.out.print("Director: ");
			String director = sc.nextLine();
			System.out.print("Duración (min): ");
			int dur = leerEntero();
			agregarRecurso(new Pelicula(id, titulo, anio, true, director, dur));
		} else if (t == 3) {
			System.out.print("Plataforma: ");
			String plat = sc.nextLine();
			System.out.print("PEGI: ");
			int pegi = leerEntero();
			agregarRecurso(new Videojuego(id, titulo, anio, true, plat, pegi));
		}
		System.out.println("Recurso añadido correctamente.");
	}

	private void modificarRecurso() {
		System.out.print("ID a modificar: ");
		Recurso r = buscarRecurso(leerEntero());
		if (r == null) {
			System.out.println("Recurso no encontrado.");
			return;
		}
		System.out.print("Nuevo Título: ");
		r.setTitulo(sc.nextLine());
		System.out.print("Nuevo Año: ");
		r.setAnio(leerEntero());
		System.out.println("Recurso actualizado.");
	}

	public boolean eliminarRecurso(int id) {
		Recurso r = buscarRecurso(id);
		if (r == null) {
			System.out.println("Error. Recurso inexistente.");
			return false;
		}
		if (!r.isDisponible()) {
			System.out.println("No se puede eliminar un recurso prestado.");
			return false;
		}
		recursos.remove(r);
		System.out.println("Recurso eliminado.");
		return true;
	}

	public void listarUsuarios() {
		for (Usuarios u : usuarios)
			System.out.println(u);
	}

	public void listarRecursosDisponibles() {
		System.out.println("Recursos Disponibles ");
		for (Recurso rec : recursos) {
			if (rec.isDisponible()) {
				System.out.println(rec);
			}
		}
	}

	public void listarRecursosPrestados() {
		System.out.println("Recursos prestados ");
		for (Recurso re : recursos) {
			if (!re.isDisponible()) {
				System.out.println(re);
			}
		}
	}

	public void buscarPorTitulo(String titulo) {
		System.out.println("Busqueda por titulo " + titulo);
		for (Recurso recurso : recursos) {
			if (recurso.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				System.out.println(recursos);
			}
		}
	}

	public void prestamosDeUsuario(int idUsuario) {
		System.out.println("Préstamos del usuario " + idUsuario);
		for (Prestamo p : prestamos) {
			if (p.getUsuarios().getId() == (idUsuario)) {
				System.out.println(p);
			}
		}

	}

	public void prestamosActivos() {
		System.out.println("Prestamos activos ");
		for (Prestamo pre : prestamos) {
			if (pre.getEstado().equals("ACTIVO")) {
				System.out.println(pre);
			}
		}
	}

	public void recursosPorTipo(String tipo) {
		System.out.println("Recursos del tipo " + tipo);
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
			System.out.println("Usuario o recurso inexistente ");
			return;
		}
		if (!r.isDisponible()) {
			System.out.println("El recurso ya está prestado ");
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
			System.out.println("Recurso inexistente ");
			return;
		}
		if (r.isDisponible()) {
			System.out.println("El recurso no está prestado ");
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
			if (u.getId() == (id))
				return u;
		}
		return null;
	}

	private Recurso buscarRecurso(int id) {
		for (Recurso r : recursos) {
			if (r.getId() == (id))
				return r;
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

	private int leerEntero() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.print("Entrada no válida. Por favor, introduce un número entero: ");
			}
		}
	}

	public void recursosPorAnio(int anio) {
		System.out.println("Recursos del año " + anio);
		for (Recurso r : recursos) {
			if (r.getAnio() == anio)
				System.out.println(r);
		}
	}

	public void historialDevoluciones() {
		System.out.println("Historial de Devoluciones");
		for (Prestamo p : prestamos) {
			if (p.getEstado().equals("DEVUELTO"))
				System.out.println(p);
		}
	}

}
