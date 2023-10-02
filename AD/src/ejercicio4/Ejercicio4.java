package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Escribe un programa Java que pida una serie de frases por teclado hasta que
 * se inserte como frase la palabra “fin”. Dichas frases deberán guardarse en un
 * fichero de texto. A continuación, el programa visualizará el contenido del
 * fichero, frase por frase. Cada vez que se ejecute el programa, se tienen que
 * descartar las frases que ya estaban escritas en el fichero. Realiza este
 * ejercicio sin usar la clase BufferedReader.
 * 
 * 
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {

		Ejercicio4 ej4 = new Ejercicio4();
		File mifichero = new File("ejercicio4.txt");
		if (!mifichero.exists()) {
			ej4.escribirfichero(mifichero, "");
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("que quieres escribir?");
		String linea = sc.nextLine();
		while (!linea.equals("fin")) {

			if (!ej4.comparar(mifichero, linea)) {
				ej4.escribirfichero(mifichero, linea);
			} else {

				System.out.println("La frase ya esta en el fichero");
			}
			linea = sc.nextLine();
		}

		ej4.leerfichero(mifichero);
		sc.close();

	}

	public void leerfichero(File file) {
		try {
			FileReader lector = new FileReader(file);
			int caracter = lector.read();// leo un byte y paso al siguiente
			while (caracter > 0) {
				System.out.print((char) caracter);
				caracter = lector.read();
			}
			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escribirfichero(File file, String linea) {
		try {
			// mifichero.createNewFile();
			FileWriter escritor = new FileWriter(file, true);

			/*
			 * Scanner sc = new Scanner(System.in); String linea= sc.nextLine();
			 */
			escritor.write(linea + "\n");

			escritor.close();
			// ¿cómo hago para que no se sobreescribra? CAMBIAR FALSE POR TRUE

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean comparar(File file, String linea) {
	FileReader lector;
		try {
			lector = new FileReader(file);
			String frase=leerLinea(lector);
			while (frase != null) {
				if(linea.equals(frase))return true;
				
				frase = leerLinea(lector);
			}
			

			lector.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	private String leerLinea(FileReader lector) throws IOException{
		int byteEntrada = lector.read();
		if (byteEntrada<0) return null;
		String frase="";
		while (byteEntrada != '\n') {
			frase = frase + (char) byteEntrada;
			byteEntrada = lector.read();
		}
		return null;
	}

}
