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
	
	//public void listarRecursosDisponibles() {
		//System.out.println("   Recursos Disponibles   ");
		//for (Recurso rec : recursos) {
			//if (rec.isDisponible()) {
				//System.out.println(rec);
			//}
		//}
	//}
	
	//public void listarRecursosPrestados() {
		//System.out.println("   Recursos prestados   ");
		//for (Recurso re : recursos) {
			//if (!re.isDisponible()) {
				//System.out.println(re);
			//}
		//}
	//}
}
