package aleatorio.ejercicio18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


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

public class Ejercicio18leer {
	private static int tamagnoNombre = 25;
	private static int tamagnoLocalidad = 50;
	private static int tamagnoReistro = 154; // int + 25 char + 50 char = 4 + 50 + 100 = 154

	public static void main(String[] args) {
		
		Ejercicio18leer ej= new Ejercicio18leer();
		// defino el fichero donde voy a escribir
		RandomAccessFile fichero = null;
		try {
			fichero = new RandomAccessFile("departamentos.dat", "r");
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
			fichero.seek(ej.funcion(2));
			System.out.println(fichero.getFilePointer());

			d.setNumero(fichero.readInt()); // leo el numero de departamento
			d.setNombre(ej.obtenerString(fichero,tamagnoNombre)); // leo el nombre del departamento
			d.setLocalidad(ej.obtenerString(fichero,tamagnoLocalidad)); // leo la localidad

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		// leer un departamento

		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String obtenerString(RandomAccessFile fichero, int tamagno) throws IOException {
		// TODO Auto-generated method stub
		char []tmp = new char[tamagno];
		for (int i = 0; i < tamagno; i++) {
			tmp[i] = fichero.readChar(); 
		}
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
	private int funcion(int numero) {
		int pos = 0;
		pos = tamagnoReistro * (numero - 1) + 1;
		return pos;
	}



}
