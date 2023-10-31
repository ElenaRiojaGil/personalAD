package gestion.ejercicio2;

import java.io.File;
import java.util.Scanner;
/**
 * Realiza un programa Java que muestre los ficheros de un directorio. El nombre
 * del directorio se pasará al programa desde la línea de comandos al
 * ejecutarlo. Modifica el programa anterior para que muestre los nombres de los
 * ficheros de un directorio, cuya extensión coincida con la que se pase como
 * segundo argumento.
 * 
 *
 */

public class Ejercicio2 {
	
	public static void main(String[]args) {
		String dir;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nombre del directorio");
		dir=sc.nextLine();
		File dire=new File(dir);
		String[] lista=dire.list();
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		
		sc.close();
	}

}
