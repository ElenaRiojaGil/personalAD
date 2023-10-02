package ejercicioEntrega;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		try {
			FileReader lector = new FileReader("datos.txt");
			FileWriter tarjeta=new FileWriter("tarjetas.txt");
			
			String linea="";
			
			
			int caracter = lector.read();// leo un byte y paso al siguiente
			while (caracter > 0) {
				linea=linea+(char)caracter;
				caracter = lector.read();
			}
			lector.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void estructura() {
		System.out.println("Nombre: ");
		System.out.println("Apellidos: ");
		System.out.println("Fecha de nacimiento: ");
		System.out.println("Teléfono: ");
		
		
	}

}
