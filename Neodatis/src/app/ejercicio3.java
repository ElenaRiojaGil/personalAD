package app;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
/**
 * Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes consultas sobre la
base de datos personal:
D) Obtener los nombres de los empleados cuyo jefe es “Pedro López“.
E) Obtener el número de empleados del departamento “Ventas”.
F) Obtener el número de empleados de cada departamento. (OPCIONAL)
 */
public class ejercicio3 {
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			ODB baseDatos = ODBFactory.open("baseDatos/personalOO", "miusuario", "Pass!123456");

			boolean salir = true;

			Scanner teclado = new Scanner(System.in);
			Consultas consulta = new Consultas();

			do {

				menu();

				int opcion = teclado.nextInt();

				switch (opcion) {

					case 1:

						consulta.nombresEm(baseDatos);

						break;

					case 2:
						consulta.numEm(baseDatos);
						break;
						
					case 3:
						consulta.numEmxDep(baseDatos);
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

			System.out.println("1. Obtener los nombres de los empleados cuyo jefe es “Pedro López“.");

			System.out.println("2. Obtener el número de empleados del departamento “Ventas”.");

			System.out.println("3. Obtener el número de empleados de cada departamento.");

			System.out.println("0. Salir.");

			System.out.println();

			System.out.println("Introduzca una opcion: ");

		
		
	}

}
