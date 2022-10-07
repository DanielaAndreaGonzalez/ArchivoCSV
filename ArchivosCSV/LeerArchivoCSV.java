/**
 * 
 */
package ArchivosCSV;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.sun.tools.javac.util.List;

/**
 * @author GonzalezHDanielaA
 *
 */
public class LeerArchivoCSV {
	
	
	public static void main(String args [])
	{
		ArchivoCSV archivo=new ArchivoCSV();
		
		String[] nombres = {"Daniela","Andrea","Isabela","Laura"};
		//Crear archivo 
		archivo.crearArchivo(nombres);
		
		
		Persona persona1 = new Persona();
		persona1.setNombre("Martha");
		persona1.setApellido("Osorio");
		persona1.setCorreo("marthaO@hotmail.com");
		
		Persona persona2 = new Persona();
		persona2.setNombre("Carlos");
		persona2.setApellido("Perez");
		persona2.setCorreo("carlos@hotmail.com");
		
		//Crear archivo con objeto 
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(persona1);
		listaPersona.add(persona2);
		
		archivo.exportarArchivoCSV(listaPersona);
		
		
		//Importar archivo CSV
		
		//archivo.importarCSV();
		
		
		
	}
	
	
	
	
 }

