package main;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

	private static final String FILE_USUARIOS = "usuarios.csv";
	private static final String FILE_RECURSOS = "recursos.csv";
	private static final String FILE_PRESTAMOS = "prestamos.csv";

	public static void guardarDatos(List<Usuarios> usuarios, List<Recurso> recursos, List<Prestamo> prestamos) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_USUARIOS))) {
			for (Usuarios u : usuarios) {
				writer.println(u.toCSV());
			}
		} catch (IOException e) {
			System.out.println("Error al guardar usuarios: " + e.getMessage());
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_RECURSOS))) {
			for (Recurso r : recursos) {
				writer.println(r.toCSV());
			}
		} catch (IOException e) {
			System.out.println("Error al guardar recursos: " + e.getMessage());
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PRESTAMOS))) {
			for (Prestamo p : prestamos) {
				writer.println(p.toCSV());
			}
		} catch (IOException e) {
			System.out.println("Error al guardar préstamos: " + e.getMessage());
		}
	}

	public static void cargarUsuarios(List<Usuarios> usuarios) {
		File file = new File(FILE_USUARIOS);
		if (!file.exists())
			return;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] p = line.split(";");
				int id = Integer.parseInt(p[0]);
				String nombre = p[1];
				String email = p[2];
				usuarios.add(new Usuarios(id, nombre, email));
			}
		} catch (Exception e) {
			System.out.println("Error al cargar fichero de usuarios.");
		}
	}

	public static void cargarRecursos(List<Recurso> recursos) {
		File file = new File(FILE_RECURSOS);
		if (!file.exists())
			return;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] p = line.split(";");
				String tipo = p[0];
				int id = Integer.parseInt(p[1]);
				String titulo = p[2];
				int anio = Integer.parseInt(p[3]);
				boolean disp = Boolean.parseBoolean(p[4]);

				if (tipo.equalsIgnoreCase("LIBRO")) {
					recursos.add(new Libro(id, titulo, anio, disp, p[5], Integer.parseInt(p[6])));
				} else if (tipo.equalsIgnoreCase("PELICULA")) {
					recursos.add(new Pelicula(id, titulo, anio, disp, p[5], Integer.parseInt(p[6])));
				} else if (tipo.equalsIgnoreCase("VIDEOJUEGO")) {
					recursos.add(new Videojuego(id, titulo, anio, disp, p[5], Integer.parseInt(p[6])));
				}
			}
		} catch (Exception e) {
			System.out.println("Error al cargar fichero de recursos.");
		}
	}

	public static void cargarPrestamos(List<Prestamo> prestamos, List<Usuarios> usuarios, List<Recurso> recursos) {
		File file = new File(FILE_PRESTAMOS);
		if (!file.exists())
			return;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] p = line.split(";");
				int idU = Integer.parseInt(p[0]);
				int idR = Integer.parseInt(p[1]);
				LocalDate fPres = LocalDate.parse(p[2]);
				LocalDate fDev = p[3].equals("null") ? null : LocalDate.parse(p[3]);
				String estado = p[4];

				Usuarios u = buscarUsuarioPorId(usuarios, idU);
				Recurso r = buscarRecursoPorId(recursos, idR);

				if (u != null && r != null) {
					prestamos.add(new Prestamo(u, r, fPres, fDev, estado));
				}
			}
		} catch (Exception e) {
			System.out.println("Error al cargar fichero de préstamos.");
		}
	}

	private static Usuarios buscarUsuarioPorId(List<Usuarios> list, int id) {
		for (Usuarios u : list)
			if (u.getId() == id)
				return u;
		return null;
	}

	private static Recurso buscarRecursoPorId(List<Recurso> list, int id) {
		for (Recurso r : list)
			if (r.getId() == id)
				return r;
		return null;
	}
}
