package ejercicio20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * A partir del fichero binario “departamentos.dat” creado en el ejercicio 18,
 * realiza un programa Java que permita eliminar un departamento. El programa
 * recibirá desde la línea de comandos el número de departamento a eliminar. Si
 * el departamento no existe, visualiza un mensaje indicándolo. Visualiza
 * también el número total de departamentos que existen en el fichero
 * 
 * @author alu
 *
 */
import ejercicio18.Departamento;
import ejercicio19.GestionDepartamentos;

public class Ejercicio20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GestionDepartamentos departamentos = new GestionDepartamentos("src\\ejercicio18\\departamentos.dat");
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
		try {
			departamentos.escribir(d, num);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**
		 * try { // colocar el cursor donde voy a empeza a escribir
		 * fichero.seek(departamentos.funcion(num));
		 * 
		 * d.setNumero(fichero.readInt()); // escribo el numero de departamento
		 * fichero.writeChars(ej.formateaCadena(d.getNombre(), tamagnoNombre)); //
		 * escribo el nombre del departamento
		 * fichero.writeChars(ej.formateaCadena(d.getLocalidad(), tamagnoLocalidad)); //
		 * escribo la localidad
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 **/

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
