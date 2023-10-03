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
			while (caracter > 0) {
				String linea = "";
				while (caracter != '\n' && caracter != -1) {
					linea = linea + (char) caracter;
					caracter = lector.read();
				}
				String[] datos = linea.split(",");
				// System.out.println(estructura(datos) + "\n");
				if (!fechaIncorrecta(datos[3])) {
					datos[3] = "La fecha introducida no es válida";

				}
				System.out.println(datos[4].length());
				if (telefonoCorrecto(datos[4])) {
					tarjeta.write(estructura(datos) + "\n");
				} else {
					//System.out.println(datos[4]);
					datos[4] = "El número de teléfono introducido no es válido";
					tarjeta.write(estructura(datos) + "\n");
				}

				caracter = lector.read();
			}

			lector.close();
			tarjeta.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean telefonoCorrecto(String datos) {
		if (datos.length() >= 9) {
			if (datos.startsWith("976")) {
				//System.out.println(datos);
				return true;
			}else if (datos.startsWith("6")) {
				//System.out.println(datos);
				return true;
			} 
				//System.out.println(datos);
		}
		System.out.println(datos.length());
		return false;
	}

	private static boolean fechaIncorrecta(String datos) {
		String[] datosFecha = datos.split("/");
		if (datosFecha[0].length() == 2 && datosFecha[1].length() == 2 && datosFecha[2].length() == 4) {
			try {
				int dia = Integer.parseInt(datosFecha[0]);
				int mes = Integer.parseInt(datosFecha[1]);
				Integer.parseInt(datosFecha[2]);
				if (dia >= 01 && dia <= 31) {
					if (mes >= 01 && mes <= 12) {
						return true;
					} else
						return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		}
		return false;
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
