import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int num;
		RegistroEstudiantes re = new RegistroEstudiantes();
		Scanner teclado = new Scanner(System.in);
		do {
			
			System.out.println(
					"1. Agregar Estudiante\n2. Mostrar Estudiantes\n3. Buscar Estudiante\n4. Eliminar Estudiante\n5. Salir");
			num = teclado.nextInt();
			switch (num) {
			case 1:
				re.agregarEstudiante();
				break;
			case 2:
				re.mostrarEstudiantes();
				break;
			case 3:
				re.buscarEstudiante();
				break;
			case 4:
				re.eliminarEstudiante();
				break;
			case 5:
				break;

			}
			
		} while (num != 5);
		teclado.close();
	}
}
