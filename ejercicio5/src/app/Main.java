package app;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import controlador.HibernateUtil;



public class Main {

	public static void main(String[] args) {
		gestionVentas gestion = new gestionVentas();
		boolean salir = true;
		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		// obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		// ------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();
		// creamos la transacci�n de la sesi�n
		
		Scanner teclado = new Scanner(System.in);
		do {

			menu();

			int opcion = teclado.nextInt();

			switch (opcion) {

				case 1:

					 gestion.modificarProductos(sesion);
					
					
				
					break;

				case 2:
					gestion.eliminarVentas(sesion);
					break;
				case 3:

					salir = false;

					break;

				default:

					System.out.println("Opcion introduciada no valida");

					break;

			}

		} while (salir);
		teclado.close();
		sesion.close();
		fabrica.close();
		System.exit(3);
	}

	public static void menu() {

		System.out.println();

		System.out.println("       Menu      ");

		System.out.println();

		System.out.println("1. Modificar el precio de todos los productos de forma que incluyan un IVA del 21%");

		System.out.println("2. Eliminar las ventas realizadas por un cliente");
		
		System.out.println("3. Salir");

		System.out.println("Introduzca una opcion: ");

	}

}
