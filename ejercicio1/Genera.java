package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Genera {

	public static void main(String[] args) {
		Trabajadores a1 = new Trabajadores();
		Gestion departamentos = new Gestion("src//ejercicio1//Trabajadores.txt");

		try {
			File mifichero = new File("src//ejercicio1//Trabajadores.txt");
			String linea = "";
			FileReader lector = new FileReader(mifichero);
			linea = departamentos.leerLinea(lector);
			// System.out.println(linea);

			int caracter = lector.read();
			System.out.println(linea);
			while (caracter > 0) {
				linea = "";
				while (caracter != '\n') {
					linea = linea + (char) caracter;
					caracter = lector.read();
				}
				System.out.println(linea);
				String datos[] = linea.split(",");
				int id = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String salario = (datos[2]);
				int sindicato = Integer.parseInt(datos[3]);
				a1 = new Trabajadores(id, nombre, salario, sindicato);
				departamentos.escribir(a1, id);
				System.out.println(linea);
				caracter = lector.read();
			}

			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
