package ejercicio6;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		int opcion = 0;
		boolean salir = false;
		Scanner teclado = new Scanner(System.in);
		Ejercicio6 eje = new Ejercicio6();
		do {
			mostrarMenu();
			System.out.println("¿Que opcion elige? ");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1: {
				eje.mostrarLibros();
				break;
			}
			case 2: {
				eje.mostrarSocios();
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				break;
			}
			case 7: {
				break;
			}
			case 0: {
				salir = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
		} while (!salir);
		teclado.close();

	}

	private static void mostrarMenu() {
		System.out.println("1. Listado de todos los libros");
		System.out.println("2. Listado de todos los socios");
		System.out.println("3. Listado de todos los prestamos");
		System.out.println("4. Listado de libros prestados actualmente.");
		System.out.println("5. Número de libros prestamos a un socio determinado");
		System.out.println("6. Libros que han superado la fecha de fin de préstamo");
		System.out.println("7. Socios que tienen libros que han superado la fecha de fin de préstamo");
		System.out.println("0. Salir");
	}

}
