/**
 * 
 */
package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import javax.swing.*;


/**
 * @author GonzalezHDanielaA
 *
 */
public class EjemplosBasicos {
	
	private static final Logger LOGGER = Logger.getLogger(EjemplosBasicos.class.getName());

	public static void main(String[] args) {
		
		

		//Archivos de propiedades
		//archivoPropiedades();
		
		//Archivos de Registro
		//archivoRegistro();
		
		
		//Manejo de carpetas (directorios)
		//manejoCarpetas();

		//Creación de archivos de texto
		//crearArchivo_V1();
		
		crearArchivo_V2_invocacionClasePersistencia();
		

	}

	private static void archivoPropiedades() {
		ResourceBundle resourceBundle;
		
		
		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso",new Locale("en","US"));
		JOptionPane.showMessageDialog(null,resourceBundle.getString("saludoBienvenida"));

		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso",new Locale("pt","BR"));
		JOptionPane.showMessageDialog(null,resourceBundle.getString("saludoBienvenida"));
		
		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso");
		JOptionPane.showMessageDialog(null,resourceBundle.getString("idioma"));
		
		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso",new Locale("es","ES"));
		JOptionPane.showMessageDialog(null,resourceBundle.getString("saludoBienvenida"));
		
		
		
//		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso", new Locale("",""));
//		String nombre = resourceBundle.getString("usuario");
//		JOptionPane.showMessageDialog(null,nombre);
//		
//		resourceBundle = ResourceBundle.getBundle("resources/MiRecurso", new Locale("",""));
//		JOptionPane.showMessageDialog(null,resourceBundle.getString("clave"));
	}
	
	private static void archivoRegistro() {
		FileHandler archivo;
		
		try {
//			archivo = new FileHandler("MyLog.txt", true);
			archivo = new FileHandler("src/resources/MyLog.txt",true);
			archivo.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(archivo);
			LOGGER.log(Level.INFO, "Primer mensaje 1.1");
			LOGGER.log(Level.WARNING, "Segundo mensaje 2.1");
			LOGGER.log(Level.SEVERE, "Tercer mensaje 3.1");
			int a = 2;
			int b = 0;
			int c = 0;
			c = a / b;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ArithmeticException e) {
			
			LOGGER.log(Level.SEVERE, String.valueOf(e.toString()));
			
		}
	}
	
	private static void manejoCarpetas() {
		
		String salida, ruta;
		File directorio;
		
		//ruta = "C:/td/directorioPrueba";
		ruta = "C:/td";
		directorio = new File(ruta);
		
		salida = "Los directorios (carpetas) no ocultos de"+ ruta+ " son: \n";
		
		for (File elemento : directorio.listFiles())
		{
//			if(elemento.isDirectory())
			if(elemento.isFile())
				salida+= elemento.getName()+"\n";
			
			if(elemento.isDirectory()  && !elemento.isHidden())
				salida+= elemento.getName()+"\n";
		}
		JOptionPane.showMessageDialog(null, salida);	
	}
	
	private static void crearArchivo_V1() {
		FileWriter archivoSalida;
		Formatter archivo = null;
		String formato, nombre;
		int edad, peso;
		double altura;
		
		formato = "El estudiante %s de edad %d y altura %2.2f es apto para jugar quien tiene un peso de %d\n";
		nombre = "Juan Pablo Galvis";
		edad = 255;
		altura = 1.73;
		peso = 350;
		
		try {
//			Construye un objeto FileWriter dado un nombre de archivo con 
//			un valor booleano que indica si anexar o no los datos escritos.
			archivoSalida = new FileWriter("C:/td/ejemplo.txt",false);
			archivo = new Formatter(archivoSalida);
			
//			archivo = new Formatter("C:/td/directorioPrueba/ejemplo.txt");
			
			archivo.format(formato, nombre,edad,altura,peso);
			
			archivo.flush();
			
			JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			archivo.close();
		}
	}
	
private static void crearArchivo_V2_invocacionClasePersistencia() {
		
		String rutaArchivo,formato, nombre;
		int edad, peso;
		double altura;
//		ArrayList<String> listaDatosSalida = new ArrayList<String>();
//		listaDatosSalida.add("Linea 1");
//		listaDatosSalida.add("Linea 2");
//		listaDatosSalida.add("Linea 3");
//		listaDatosSalida.add("Linea 4");
		rutaArchivo = "C:/td/ejemplo2.txt";
		
		formato = "El estudiante %s de edad %d y altura %2.2f es apto para jugar %d\n";
		nombre = "Juan Pablo Galvis";
		edad = 21;
		altura = 1.73;
		peso = 188;
		
		try {
			Persistencia.almacenarDatos(rutaArchivo, formato, nombre,edad,altura,peso);
//			Persistencia.escribirArchivo(rutaArchivo, listaDatosSalida, false);
			JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
