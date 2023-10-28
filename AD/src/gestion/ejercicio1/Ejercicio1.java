package gestion.ejercicio1;

import java.io.File;

/**
 * Escribe un programa Java que inicialice cuatro objetos de tipo File: dos que
 * hagan referencia a ficheros, que uno exista y otro no, y los otros dos a
 * directorios, que uno exista y el otro no. El programa debe averiguar si
 * existen dichos ficheros o directorios, independientemente de que sean una
 * cosa o la otra. También debe averiguar para cada objeto que exista si es un
 * fichero o directorio. A la hora de visualizar el nombre del fichero o
 * directorio, prueba a usar los diferentes métodos get que ofrece la clase File
 * para ver la diferencia que hay entre cada uno de ellos.
 * 
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("D:\\Documentos\\ElenaRioja\\AD\\WORKSPACE\\ejemplosAD\\Ficheros\\saludo.txt");
		File f2 = new File("D:\\Documentos\\ElenaRioja\\AD\\WORKSPACE\\ejemplosAD\\Ficheros\\patata.txt");
		File d1 = new File("D:\\Documentos\\ElenaRioja\\AD\\WORKSPACE\\ejemplosAD\\Ficheros");
		File d2 = new File("D:\\Documentos\\ElenaRioja\\AD\\WORKSPACE\\ejemplosAD\\Ficherospatata");
		
		
		System.out.println(existe(f1));
		System.out.println(existe(f2));
		System.out.println(existe(d1));
		System.out.println(existe(d2));
		
		/*if (f1.exists()) {
			if (f1.isFile()) {
				System.out.println("El " + f1.getName() + " existe y es un fichero");
			} else
				System.out.println("El " + f1.getName() + " existe y es un directorio");
		} else
			System.out.println("El " + f1.getName() + " no existe");
		if (f2.exists()) {
			if (f2.isFile()) {
				System.out.println("El " + f2.getName() + " existe y es un fichero");
			} else
				System.out.println("El " + f2.getName() + " existe y es un directorio");
		} else
			System.out.println("El " + f2.getName() + " no existe");
		if (d1.exists()) {
			if (d1.isFile()) {
				System.out.println("El " + d1.getName() + " existe y es un fichero");
			} else
				System.out.println("El " + d1.getName() + " existe y es un directorio");
		} else
			System.out.println("El " + d1.getName() + " no existe");
		if (d2.exists()) {
			if (d2.isFile()) {
				System.out.println("El " + d2.getName() + " existe y es un fichero");
			} else
				System.out.println("El " + d2.getName() + " existe y es un directorio");
		} else
			System.out.println("El " + d2.getName() + " no existe");
			*/
	}

	public static String existe(File file) {
		if (file.exists()) {
			String es;
			es=ficheroDirectorio(file);
			return es;
		} else
			return "El " + file.getName() + " no existe";
	}
	
	public static String ficheroDirectorio(File file) {
		if (file.isFile()) {
			return "El " + file.getName() + " existe y es un fichero";
		} else
		return "El " + file.getName() + " existe y es un directorio";
	}

}
