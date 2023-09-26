import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiantes {
	ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	Scanner teclado = new Scanner(System.in);

	public void agregarEstudiante() {

		String nom;
		int edadEs;
		String mat;
		Estudiante estudiante;

		System.out.print("Introduzca el nombre del estudiante ");
		nom = teclado.nextLine();
		System.out.print("Introduzca la edad del estudiante ");
		edadEs = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Introduzca el numero de la matricula del estudiante ");
		mat = teclado.nextLine();

		estudiante = new Estudiante(nom, edadEs, mat);

		estudiantes.add(estudiante);
		// System.out.print(estudiante);
	}

	public void mostrarEstudiantes() {
		for (Estudiante e : estudiantes) {
			System.out.println("Nombre: " + e.getNombre());
			System.out.println("Edad: " + e.getEdad());
			System.out.println("Matricula: " + e.getMatricula() + "\n");
		}

	}

	public void buscarEstudiante() {
		String mat;
		System.out.print("Introduzca el numero de la matricula del estudiante ");
		mat = teclado.nextLine();
		for (Estudiante e : estudiantes) {
			if (e.getMatricula().equals(mat)) {
				System.out.println("Nombre: " + e.getNombre());
				System.out.println("Edad: " + e.getEdad());
				System.out.println("Matricula: " + e.getMatricula());
			} else
				System.out.print("El estudiante no esta registrado");
		}

	}

	public void eliminarEstudiante() {
		String mat;
		System.out.print("Introduzca el numero de la matricula del estudiante ");
		mat = teclado.nextLine();
		for (Estudiante e : estudiantes) {
			if (e.getMatricula().equals(mat)) {
				estudiantes.remove(e);

			}

		}

	}

}
