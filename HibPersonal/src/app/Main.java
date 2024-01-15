package app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import datos.Departamento;

/**
 * Realiza un programa Java que utilice Hibernate para ejecutar las siguientes
 * operaciones de gestión de objetos mapeados a partir de la base de datos
 * personal: A) Modificar un departamento. B) Insertar un empleado. C) Leer un
 * empleado, y además, su departamento correspondiente. D) Eliminar un empleado.
 * E) Eliminar un departamento. Previamente, se debe eliminar todos los
 * empleados de dicho departamento. Utiliza una transacción. (OPCIONAL) En cada
 * apartado, añade las comprobaciones necesarias en caso de errores, visualiza
 * en pantalla los mensajes apropiados para todas las situaciones y también los
 * atributos de los objetos manipulados en Java.
 * 
 */
public class Main {

	public static void main(String[] args) {
		gestionDep gestion = new gestionDep();
		boolean salir = true;
		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		// obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		// ------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();
		// creamos la transacci�n de la sesi�n
		Query<Departamento> q = sesion.createQuery("from Departamento");

		List<Departamento> lista = q.list();
		Scanner teclado = new Scanner(System.in);
		do {

			menu();

			int opcion = teclado.nextInt();

			switch (opcion) {

				case 1:

					 gestion.modificarDep(sesion);
					
					//sesion.saveOrUpdate(depModificado);
				
					break;

				case 2:
					gestion.insertarEmpleado(sesion);
					break;

				case 3:
					gestion.leer(sesion);
					break;

				case 4:
					gestion.eliminarEmp(sesion);
					break;
				case 5:

					break;

				case 0:

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
		System.exit(0);
	}

	public static void menu() {

		System.out.println();

		System.out.println("       Menu      ");

		System.out.println();

		System.out.println("1. Modificar un departamento.");

		System.out.println("2. Insertar un empleado. ");

		System.out.println("3. Leer un empleado, y además, su departamento correspondiente.");

		System.out.println("4. Eliminar un empleado. ");

		System.out.println("5. Eliminar un departamento.");

		System.out.println("0. Salir.");

		System.out.println();

		System.out.println("Introduzca una opcion: ");

	}

}
