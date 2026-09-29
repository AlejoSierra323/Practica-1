package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuarios {

	private final Map<Integer, Usuarios> mapaUsuarios = new HashMap<>();
	private int id;
	private String nombre;
	private String correoElectronico;

	public Usuarios(int id, String nombre, String correoElectronico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	
	 @Override
	    public String toString() {
	        return "Usuario [ID: " + id + ", Nombre: " + nombre + ", Email: " + correoElectronico + "]";
	    }
	

	 public boolean crearUsuario(int id, String nombre, String correo) {
	        if (mapaUsuarios.containsKey(id)) {
	            System.out.println("Ya existe un usuario con el identificador: " + id);
	            return false;
	        }
	        Usuarios nuevo = new Usuarios(id, nombre, correo);
	        mapaUsuarios.put(id, nuevo);
	        return true;
	    }

	    public Usuarios buscarUsuario(int id) {
	        return mapaUsuarios.get(id); 
	    }

	    public ArrayList<Usuarios> obtenerTodosLosUsuarios() {
	        return new ArrayList<>(mapaUsuarios.values()); 
	    }

	    public boolean modificarUsuario(int id, String nuevoNombre, String nuevoCorreo) {
	        Usuarios usuario = buscarUsuario(id);
	        if (usuario == null) {
	            System.out.println("No se encontró el usuario con ID: " + id);
	            return false;
	        }
	        usuario.setNombre(nuevoNombre);
	        usuario.setCorreoElectronico(nuevoCorreo);
	        return true;
	    }

	    public boolean eliminarUsuario(int id) {
	        if (!mapaUsuarios.containsKey(id)) {
	            System.out.println("No existe el usuario con ID: " + id);
	            return false;
	        }
	        mapaUsuarios.remove(id);
	        return true;
	    }

}
