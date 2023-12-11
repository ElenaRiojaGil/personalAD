package aleatorio.ejercicio19;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

import aleatorio.ejercicio18.Departamento;

/**
 * A partir de fichero binario “departamentos.dat” creado en el ejercicio 18,
 * realiza un programa Java que permita modificar los datos de un departamento.
 * El programa recibirá desde la línea de comandos el número de departamento a
 * modificar, el nuevo nombre de departamento y la nueva localidad. Si el
 * departamento no existe, visualiza un mensaje indicándolo. Visualiza también
 * los datos antiguos y los nuevos datos del departamento.
 * 
 * @author alu
 *
 */
public class Ejercicio19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GestionDepartamentos departamentos = new GestionDepartamentos("src\\ejercicio19\\departamentos.dat");
		// AD/src/ejercicio19/departamentos.dat
		try {
			// fichero = new RandomAccessFile("src\\ejercicio18\\departamentos.dat", "rw");
			departamentos.abrir();
		} catch (FileNotFoundException e) {
			System.err.println("No existe el fichero");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num;
		String nom, loc;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduzca el número del departamento a modificar: ");
		num = teclado.nextInt();
		teclado.nextLine();
		
		try {
			if (departamentos.leer(num).getNumero() != 0) {
				System.out.println("Introduzca el nombre del departamento a modificar: ");
				nom = teclado.next();
				System.out.println("Introduzca el localidad del departamento a modificar: ");
				loc = teclado.next();
				Departamento d = new Departamento(num, nom, loc);

				try {
					System.out.println(
							"Datos antiguos con el nuemro de departamento " + num + " son: " + departamentos.leer(num));
					departamentos.escribir(d, num);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println(d);
			} else
				System.err.println("No existe el numero de departamento");
			teclado.close();
			departamentos.cerrar();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
