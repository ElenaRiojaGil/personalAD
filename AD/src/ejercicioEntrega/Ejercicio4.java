package ejercicioEntrega;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) {

		try {
			FileReader lector = new FileReader("datos.txt");
			FileWriter tarjeta = new FileWriter("tarjetas.txt");

			int caracter = lector.read();// leo un byte y paso al siguiente
			while (caracter>0) {
				String linea = "";
				while (caracter != '\n'&& caracter!=-1) {
					linea = linea + (char) caracter;
					caracter = lector.read();
				}
				String[] datos = linea.split(",");
				//System.out.println(estructura(datos) + "\n");
				if(!comprobacionFecha(datos[3])) {
					tarjeta.write(estructura(datos)+ "\n");
				}else {
					datos[3]="La fecha introducida no es valida";
					tarjeta.write(estructura(datos)+ "\n");
				}
				
				caracter = lector.read();
			}
			
			lector.close();
			tarjeta.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean comprobacionFecha(String datos) {
		String[] datosFecha=datos.split("/");
		if(datosFecha[0].length()==2 && datosFecha[1].length()==2 && datosFecha[2].length()==4) {
			return false;
		}
		return true;
	}

	public static String estructura(String[] datos) {
		/*
		 * System.out.println("Nombre: " + datos[0]); System.out.println("Apellidos: " +
		 * datos[1]); System.out.println("Fecha de nacimiento: " + datos[3]);
		 * System.out.println("Teléfono: " + datos[4]);
		 */
		return "Nombre: " + datos[0] + "\nApellidos: " + datos[1] + "\nFecha de nacimiento: " + datos[3]
				+ "\nTeléfono: " + datos[4] + "\n";

	}

}
