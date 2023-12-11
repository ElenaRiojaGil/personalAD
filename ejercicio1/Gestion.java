package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Gestion {

		private static int tamagnoNombre = 25;
		private static int tamagnoReistro = 154; // int + 25 char + 50 char = 4 + 50 + 100 = 154
		private RandomAccessFile fichero;
		private String nomFichero;

		public Gestion(String nomfichero) {
			this.nomFichero = nomfichero;
		}

		public void abrir() throws FileNotFoundException {
			fichero = new RandomAccessFile(nomFichero, "rw");
		}

		/**
		 * Cerrar el fichero de las personas
		 * 
		 * @throws IOException
		 */
		public void cerrar() throws IOException {
			if (fichero != null) {
				fichero.close();
			}
		}

		/**
		 * Escribir una persona en mi agenda en la posici�n indicada
		 * 
		 * @param registro la persona que quiero escribir
		 * @param pos      la posici�n donde quiero escribir
		 * @throws IOException
		 */
		public void escribir(Trabajadores registro, int pos) throws IOException {
			if (fichero != null) {
				// posiciono el puntero en el sitio que quiero ...
				fichero.seek(funcion(pos));
				this.escribir(registro);
			}
		}

		/**
		 * Escribir una persona en la posici�n en la que actualmente est� el cursor
		 * 
		 * @param registro la persona que se quiere escribir en el fichero
		 * @throws IOException
		 */
		public void escribir(Trabajadores registro) throws IOException {
			if (fichero != null) {

				// nombre de una persona ocupa 10 characteres --> 10 *2 = 20 bytes para
				// almacenar el nombre
				// 4 bytes para almacenar el entero de edad
				// el email del due�o de la persona ocupa 50 caracteres --> 30*2 = 60 bytes para
				// almacenar el email

				// PARA ESCRIBIR EL ID
				fichero.writeInt(registro.getNumero());

				// escribir la NOMBRE
				StringBuffer bufferN = new StringBuffer();
				if (registro.getNombre() != null) {
					bufferN.append(registro.getNombre());
				}
				bufferN.setLength(tamagnoNombre);
				fichero.writeChars(bufferN.toString());

				// PARA ESCRIBIR EL SALARIO
				StringBuffer bufferE = new StringBuffer();
				bufferE.append(registro.getSalario());
				
				// PARA ESCRIBIR EL SINDICATO
				fichero.writeInt(registro.getSindicato());
			}

		}

		public int funcion(int numero) {
			int pos = 0;
			pos = tamagnoReistro * (numero - 1) + 1;
			return pos;
		}

		/**
		 * Leer del fichero un registro cualquiera, el par�metro indica la posici�n del
		 * registro
		 * 
		 * @param pos
		 * @return
		 * @throws IOException
		 */
		public Trabajadores leer(int pos) throws IOException {

			if (fichero != null) {
				fichero.seek(funcion(pos));
			}

			return this.leer();
		}

		/**
		 * Leer del fichero la persona que se encuentra en la posici�n actual del cursor
		 * 
		 * @return la persona leida o null si ha llegado al final del fichero
		 */
		public Trabajadores leer() {

			Trabajadores registro = null;

			if (fichero != null) {

				try {
					registro = new Trabajadores();

					// TENGO QUE IR LEYENDO EN ORDEN LO QUE HE ESCRITO ANTES
					// leo el ID
					registro.setNumero(fichero.readInt());

					char campoN[] = new char[tamagnoNombre];
					for (int i = 0; i < tamagnoNombre; i++) {
						campoN[i] = fichero.readChar();
						
					}
					// leo el NOMBRE
					registro.setNombre(new String(campoN));

					// leo la LOCALIDAD
					char campoS[] = new char[tamagnoNombre];
					for (int i = 0; i < tamagnoNombre; i++) {
						campoN[i] = fichero.readChar();
						
					}
					registro.setSalario(new String(campoS));
					registro.setSindicato(fichero.readInt());

				} catch (Exception e) {
					// entrar� aqu� cuando haya llegado al final del fichero
					registro = null;
				}
			}

			return registro;
		}

		public boolean finFichero() throws IOException {

			if (fichero.getFilePointer() >= fichero.length()) {
				return true;
			}
			return false;

		}

		public void iniciar() throws IOException {
			fichero.seek(0);
		}

		public void eliminar(Trabajadores d, int pos) {
			funcion(pos);
			
		}
		public void leerfichero(File file) {
			try {
				FileReader lector = new FileReader(file);
				int caracter = lector.read();// leo un byte y paso al siguiente
				while (caracter > 0) {
					System.out.print((char) caracter);
					caracter = lector.read();
				}
				lector.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void escribirfichero(File file, String linea) {
			try {
				// mifichero.createNewFile();
				FileWriter escritor = new FileWriter(file, true);

				/*
				 * Scanner sc = new Scanner(System.in); String linea= sc.nextLine();
				 */
				escritor.write(linea + "\n");

				escritor.close();
				// ¿cómo hago para que no se sobreescribra? CAMBIAR FALSE POR TRUE

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public boolean comparar(File file, String linea) {
		FileReader lector;
			try {
				lector = new FileReader(file);
				String frase=leerLinea(lector);
				while (frase != null) {
					if(linea.equals(frase))return true;
					
					frase = leerLinea(lector);
				}
				

				lector.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;

		}

		public String leerLinea(FileReader lector) throws IOException{
			int byteEntrada = lector.read();
			if (byteEntrada<0) return null;
			String frase="";
			while (byteEntrada != '\n') {
				frase = frase + (char) byteEntrada;
				byteEntrada = lector.read();
			}
			return null;
		}
	}


