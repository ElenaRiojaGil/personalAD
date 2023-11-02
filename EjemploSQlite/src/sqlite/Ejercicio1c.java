package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1c {
	public static void main(String[] args) {

		
		try {
			// Crear una instancia del JDBC driver
			Class.forName("org.sqlite.JDBC");

			// Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
			// jdbc:sqlite:
			// parametro 2 = nombre del usuario
			// parametro 3 = contraseña del usuario

			// Establecer una conexión usando el driver que crea el objeto Connection.
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");

			// Crear un objeto Statement, usando Connection.
			Statement stm = conexion.createStatement();

			// Armar el postulado SQL y enviarlo a ejecución usando el Statement.
			//Libros que han superado la fecha de fin de préstamo
			ResultSet resultado = stm.executeQuery(
					"SELECT titulo from LIBRO where Codigo=(SELECT p.CodigoLibro from PRESTAMO p where p.FechaFin< date()) ;");
			
			 //Recibir los resultados en el objeto ResultSet.
			while (resultado.next()) {
				String titulo = resultado.getString("Titulo");
				System.out.println(titulo);
			}

			// cerrar los recursos
			resultado.close();
			stm.close();
			conexion.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("No ha encontrado la clase");
		}
	}
}
