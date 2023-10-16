package ejercicio18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Realiza un programa Java que cree un fichero binario para guardar datos de
 * departamentos. Dale el nombre “departamentos.dat” e introduce varios
 * departamentos, accediendo de forma aleatoria al fichero Para su uso en
 * posteriores ejercicios, el fichero binario “departamentos.dat” deberá
 * contener varios registros de departamentos ordenados por el número de
 * departamento. Este campo será un identificador único que se utilizará
 * posteriormente para acceder a la posición que ocupa un registro dentro del
 * fichero y obtener sus datos.
 * 
 * @author alu
 *
 */

public class Ejercicio18 {
	private static int tamagnoNombre = 25;
	private static int tamagnoLocalidad = 50;
	private static int tamagnoReistro = 154; // int + 25 char + 50 char = 4 + 50 + 100 = 154

	public static void main(String[] args) {
		ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

		Departamento d1 = new Departamento(101, "Mátematicas", "Zaragoza");
		listaDepartamentos.add(d1);
		Departamento d2 = new Departamento(98, "Física", "Zaragoza");
		listaDepartamentos.add(d2);
		Departamento d3 = new Departamento(2, "Ingles", "Huesca");
		listaDepartamentos.add(d3);
		Departamento d4 = new Departamento(213, "Física", "Teruel");
		listaDepartamentos.add(d4);

		// defino el fichero donde voy a escribir
		RandomAccessFile fichero = null;
		try {
			fichero = new RandomAccessFile("src\\ejercicio18\\departamentos.dat", "rw");
		} catch (FileNotFoundException e) {
			System.err.println("No existe el fichero");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// escribir un departamento

		// int posicion = 1;
		Departamento d = new Departamento();

		try {
			// colocar el cursor donde voy a empeza a escribir
			fichero.seek(funcion(d.getNumero()));

			d.setNumero(fichero.readInt()); // escribo el numero de departamento
			fichero.writeChars(formateaCadena(d.getNombre(), tamagnoNombre)); // escribo el nombre del departamento
			fichero.writeChars(formateaCadena(d.getLocalidad(), tamagnoLocalidad)); // escribo la localidad

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// leer un departamento
		try {
			fichero.seek(funcion(213));
			leer(fichero, tamagnoReistro);
			System.out.println("El curso se ha quedado en la posicion " + fichero.getFilePointer());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String formateaCadena(String cadena, int tamagno) {
		// TODO Auto-generated method stub
		StringBuffer tmp = new StringBuffer();
		tmp.append(cadena);
		tmp.setLength(tamagno);

		return new String(tmp);
	}

	/**
	 * Calcular la posicion dentro del fichero en la que debe estar el cursor para
	 * leer el registro "numero"
	 * 
	 * @param numero de registro al que quiero acceder
	 * @return la posicion dentro del fichero en la que debe estar el cursor para
	 *         leer el registro "numero"
	 */
	private static int funcion(int numero) {
		int pos = 0;
		pos = tamagnoReistro * (numero - 1) + 1;
		return pos;
	}

	private static void leer(RandomAccessFile fichero, int tamagnoReistro) throws IOException {
		System.out.println(fichero.readInt());
		char nombre[] = new char[tamagnoReistro];
		for (int i = 0; i < tamagnoReistro - 1; i++) {
			nombre[i] = fichero.readChar();
		}
		System.out.println(nombre);
	}

}
