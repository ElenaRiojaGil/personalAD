package aleatorio.ejercicio20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import aleatorio.ejercicio18.Departamento;
import aleatorio.ejercicio19.GestionDepartamentos;

public class Ejercicio20 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		GestionDepartamentos departamentos = new GestionDepartamentos("departamentos.dat");
		// defino el fichero donde voy a escribir
		try {
			departamentos.abrir();
		} catch (FileNotFoundException e) {
			System.err.println("No existe el fichero");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num;

		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduzca el número del departamento a modificar: ");
		num = teclado.nextInt();
		teclado.nextLine();

		Departamento d = new Departamento();

		departamentos.eliminar(d, num);

		System.out.println(d);

		try {
			teclado.close();
			departamentos.cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
