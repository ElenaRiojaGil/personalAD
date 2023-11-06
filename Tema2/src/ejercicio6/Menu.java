package ejercicio6;

public class Menu {
	public static void main(String[] args) {
		int opcion = 0;
		boolean salir = false;
		mostrarMenu();
		
		switch (opcion) {
		case 1: {
			

		}
		case 2: {

		}
		case 3: {

		}
		case 4: {

		}
		case 5: {

		}
		case 6: {

		}
		case 7: {

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}

	}

	private static void mostrarMenu() {
		System.out.println("1. Listado de todos los libros");
		System.out.println("2. Listado de todos los socios");
		System.out.println("3. Listado de todos los prestamos");
		System.out.println("4. Listado de libros prestados actualmente.");
		System.out.println("5. Número de libros prestamos a un socio determinado");
		System.out.println("6. Libros que han superado la fecha de fin de préstamo");
		System.out.println("7. Socios que tienen libros que han superado la fecha de fin de préstamo");
	}

}
