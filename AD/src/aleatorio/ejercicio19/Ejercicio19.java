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

		GestionDepartamentos departamentos=new GestionDepartamentos("departamentos.dat");
		// defino el fichero donde voy a escribir
		//RandomAccessFile fichero = null;
		try {
			//fichero = new RandomAccessFile("src\\ejercicio18\\departamentos.dat", "rw");
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
		System.out.println("Introduzca el nombre del departamento a modificar: ");
		nom = teclado.next();
		System.out.println("Introduzca el localidad del departamento a modificar: ");
		loc = teclado.next();
		Departamento d = new Departamento(num,nom,loc);
		try {
			System.out.println("Datos antiguos con el nuemro de departamento "+num+" son: "+departamentos.leer(num));
			departamentos.escribir(d,num);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
/**
		try {
			// colocar el cursor donde voy a empeza a escribir
			fichero.seek(departamentos.funcion(num));

			d.setNumero(fichero.readInt()); // escribo el numero de departamento
			fichero.writeChars(ej.formateaCadena(d.getNombre(), tamagnoNombre)); // escribo el nombre del departamento
			fichero.writeChars(ej.formateaCadena(d.getLocalidad(), tamagnoLocalidad)); // escribo la localidad

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		

		System.out.println(d);
		// leer un departamento

		try {
			teclado.close();
			departamentos.cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
