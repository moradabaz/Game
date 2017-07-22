package Pruebas;

import java.util.Collection;
import java.util.LinkedList;

public class PruebaColecciones {
		
	
	public static void main(String[] args)
	{
	Collection<String> coleccion = new LinkedList<String>();	
	
	coleccion.add("Hola");
	coleccion.add("Como estas");
	coleccion.add("Muy bien");
	coleccion.add("Nombre");
	coleccion.add("Apellidos");
	
	for(String colec : coleccion)
	{
		if(colec.contains("Nombre"));
			coleccion.remove("Nombre");
			coleccion.add("NAME");
	}
	}
}
