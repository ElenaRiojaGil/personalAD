import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean salir = true;

		Scanner teclado = new Scanner(System.in);
		GestionApache ga = new GestionApache();

		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			// ESTABLECER LA CONEXIÓN con la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:derby:ejbiblio.db");

			do {

				menu();

				int opcion = teclado.nextInt();

				switch (opcion) {

				case 1:
					
					ga.listadoDatos(conexion);

					break;

				case 2:

					break;

				case 3:

					break;

				case 4:

					break;

				case 0:

					salir = false;

					break;

				default:

					System.out.println("Opcion introduciada no valida");

					break;

				}

			} while (false);

		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

		}

	}

	public static void menu() {

		System.out.println();

		System.out.println("       Menu      ");

		System.out.println();

		System.out.println("1. Listar datos de una tabla.");

		System.out.println("2. Insertar dato.");

		System.out.println("3. Modificar datos tabla.");

		System.out.println("4. Consulta a tablas.");

		System.out.println("0. Salir.");

		System.out.println();

		System.out.println("Introduzca una opcion: ");

	}

}