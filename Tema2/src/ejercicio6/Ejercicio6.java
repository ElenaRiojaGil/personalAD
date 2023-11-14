package ejercicio6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Ejercicio6 {

	public Statement abrir() {
		Statement stm = null;
		try {
			Class.forName("org.sqlite.JDBC");

			// Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
			// jdbc:sqlite:
			// parametro 2 = nombre del usuario
			// parametro 3 = contraseña del usuario

			// Establecer una conexión usando el driver que crea el objeto Connection.
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");

			// Crear un objeto Statement, usando Connection.
			 stm = conexion.createStatement();
		
			 

		} catch (Exception e) {
			// TODO: handle exception
		}
		return stm;

	}

	public void mostrarLibros() {

		try {
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
			ResultSet resultado = stm.executeQuery("select * from LIBRO");
			ResultSetMetaData rsmd = resultado.getMetaData();
			int numColumnas = rsmd.getColumnCount();
			System.out.println("Nombre de la tabla: " + rsmd.getCatalogName(1) + "\n--------------------");

			while (resultado.next()) {
				for (int i = 1; i <= numColumnas; i++) {
					System.out.print(rsmd.getColumnLabel(i) + ": ");
					if (rsmd.getColumnType(i) == Types.VARCHAR) {
						System.out.println(resultado.getString(i));
					} else if (rsmd.getColumnType(i) == Types.INTEGER) {
						System.out.println(resultado.getInt(i));

					}
				}
				System.out.println("--------------------");
			}

			// Recibir los resultados en el objeto ResultSet.

			// cerrar los recursos
			resultado.close();
			stm.close();
			conexion.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("No ha encontrado la clase");
		}
	}
	public void mostrarSocios() {

		try {
			Statement stm = abrir();
			// Armar el postulado SQL y enviarlo a ejecución usando el Statement.
			ResultSet resultado = stm.executeQuery("select * from SOCIOS");
			ResultSetMetaData rsmd = resultado.getMetaData();
			int numColumnas = rsmd.getColumnCount();
			System.out.println("Nombre de la tabla: " + rsmd.getCatalogName(1) + "\n--------------------");

			while (resultado.next()) {
				for (int i = 1; i <= numColumnas; i++) {
					System.out.print(rsmd.getColumnLabel(i) + ": ");
					if (rsmd.getColumnType(i) == Types.VARCHAR) {
						System.out.println(resultado.getString(i));
					} else if (rsmd.getColumnType(i) == Types.INTEGER) {
						System.out.println(resultado.getInt(i));

					}
				}
				System.out.println("--------------------");
			}

			// Recibir los resultados en el objeto ResultSet.

			// cerrar los recursos
			resultado.close();
			stm.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("No ha encontrado la clase");
		}
	}

}
