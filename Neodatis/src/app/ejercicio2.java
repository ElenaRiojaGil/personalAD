package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

/**
 * Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes
 * operaciones de gestión de objetos de la base de datos biblioteca: A) Insertar
 * un libro, sin especificar ningún autor. B) Insertar un autor, sin especificar
 * ningún libro. C) Modificar un libro para añadirle un autor existente de la
 * base de datos. D) Modificar un autor para añadirle un libro existente de la
 * base de datos. E) Visualizar todos los libros. F) Visualizar todos los
 * autores.
 */
public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ODB baseDatos = ODBFactory.open("baseDatos/testOO", "miusuario", "Pass!123456");

		boolean salir = true;

		Scanner teclado = new Scanner(System.in);
		Consultas consulta = new Consultas();

		do {

			menu();

			int opcion = teclado.nextInt();

			switch (opcion) {

				case 1:

					consulta.insertarLibro(baseDatos);

					break;

				case 2:
					consulta.insertarAutores(baseDatos);
					break;
					
				case 3:
					consulta.modificarLibro(baseDatos);
					break;

				case 0:

					salir = false;

					break;

				default:

					System.out.println("Opcion introduciada no valida");

					break;

			}

		} while (false);
		
	

	}

	public static void menu() {

		System.out.println();

		System.out.println("       Menu      ");

		System.out.println();

		System.out.println("1. Insertar un libro, sin especificar ningún autor.");

		System.out.println("2. Insertar un autor, sin especificar ningún libro.");

		System.out.println("3. Modificar un libro para añadirle un autor existente de la base de datos.");

		System.out.println("0. Salir.");

		System.out.println();

		System.out.println("Introduzca una opcion: ");

	}

}
