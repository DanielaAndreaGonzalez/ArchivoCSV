/**
 * 
 */
package ArchivosCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.opencsv.CSVWriter;
import com.sun.tools.javac.util.List;

/**
 * @author GonzalezHDanielaA
 *
 */
public class ArchivoCSV {
	
	private String nombreArchivo;
	
	public ArchivoCSV() {}
	public ArchivoCSV(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
	public void crearArchivo(String [] nombres)
	{
	
		try {
			String nombre="nombreArchivo";
			String ruta = "C:/td/";
		CsvWriter  writer = new CsvWriter(new FileWriter(ruta+nombre+".csv", true), ',');
		//Datos para identificar las columnas
		writer.write("Nombre");
		writer.write("Telefono");
		writer.write("Email");
		writer.endRecord(); // Deja de escribir en el archivo
		
		//Recorremos la lista y lo insertamos en el archivo
		for(String user : nombres) {
			writer.write(user); 
			writer.endRecord(); // Deja de escribir en el archivo
        }
		
		writer.close(); //cierra el archivo
		
		//String archCSV = "C:/td/archivoCSV.csv";
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void exportarArchivoCSV(ArrayList<Persona> personas)
	{
		
		String salidaArchivo = "salidaPersonas.csv";
		boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
		
		//Si existe un archivo llamado así lo borra
		if(existe)
		{
			File archivoPersonas = new File(salidaArchivo);
			archivoPersonas.delete();
		}
		try {
			//Crea el archivo
			CsvWriter salidaCSV = new CsvWriter(new FileWriter("C:/td/"+salidaArchivo,true),',');
			
			//Datos para identificar las columnas
			salidaCSV.write("nombre");
			salidaCSV.write("apellido");
			salidaCSV.write("correo");
			
			salidaCSV.endRecord(); // Deja de escribir en el archivo
			
			for(Persona per: personas)
			{
				salidaCSV.write(per.getNombre());
				salidaCSV.write(per.getApellido());
				salidaCSV.write(per.getCorreo());
			
				salidaCSV.endRecord(); // Deja de escribir en el archivo
			}
			
			salidaCSV.close();		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void importarCSV() {

		try {
			ArrayList<Persona> personas = new ArrayList<>();
			CsvReader leerPersonas = new CsvReader("C:/td/salidaPersonas.csv");
			leerPersonas.readHeaders();

			// Mientras haya lineas se obtiene los datos del archivo
			while (leerPersonas.readRecord()) {
				String nombre = leerPersonas.get(0);
				String apellido = leerPersonas.get(1);
				String correo = leerPersonas.get(2);

				personas.add(new Persona(nombre, apellido, correo));
			}
			leerPersonas.close();

			// Se recorre la lista y se muestra en la pantalla
			for (Persona persona : personas) {
				System.out.println(persona.getNombre() + "," + persona.getApellido() + "," + persona.getCorreo());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
