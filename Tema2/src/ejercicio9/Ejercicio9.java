package ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Realiza un programa Java que utilice el driver o conector JDBC con la base de
 * datos biblioteca, creada en SQLite o MySQL, y que modifique un socio
 * existente de la tabla SOCIO. Los datos del socio a modificar son el domicilio
 * y el teléfono y se introducirán por teclado. En el caso de que el socio a
 * modificar no exista en la tabla SOCIO, se deberá mostrar un mensaje por
 * pantalla.
 * 
 * @author elena rioja
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Connection conexion = null;
		Gestion gestion = new Gestion();

		try {
			// Crear una instancia del JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
			// jdbc:sqlite:
			// parametro 2 = nombre del usuario
			// parametro 3 = contraseña del usuario

			// Establecer una conexión usando el driver que crea el objeto Connection.
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.102/biblioteca", "elena", "Pass!123456");


			// Imprimimos primero el listado de los socios para que el usuario sepa cuales
			// puede y no modificar.

			System.out.println("Listado de todos los socios: ");
			String consulta = "select * from socio";
			gestion.lecturaDatos(conexion, consulta);

			try {
				// ya que puede haber varios socios con el mismo nombre
				System.out.println("Introduzca el numero del socio que desea modificar: ");
				int codigoSocio = teclado.nextInt();
				teclado.nextLine();

				if (!gestion.validarSocio(conexion, codigoSocio)) {
					System.err.println("El codigo del socio " + codigoSocio + " no se ha encontrado.");
				} else {
					gestion.modificarDatos(conexion, codigoSocio);

				}

			} catch (InputMismatchException e) {
				System.err.println("Error " + e.getMessage());
			}

			conexion.commit();
			// cerrar los recursos
			conexion.close();
			teclado.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e2) {

				}
			}
			System.err.println("Error de conexion");
		}
	}

}
