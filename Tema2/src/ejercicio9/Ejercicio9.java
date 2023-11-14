package ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Connection conexion = null;
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
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from socio");
				
			 //Recibir los resultados en el objeto ResultSet.
			 while(resultado.next()) {
				
				 System.out.println(resultado.getInt(1)+"-"+resultado.getString(2));
			 }
			// Crear un objeto Statement, usando Connection.
			String socioModificar;
			System.out.println("Escribe el nombre del socio a modificar:");
			socioModificar = teclado.nextLine();

			// Armar el postulado SQL y enviarlo a ejecución usando el Statement.
			
			ResultSet resultadoMod = sentencia.executeQuery("select * from socio WHERE `Nombre`=" + socioModificar);

			// Recibir los resultados en el objeto ResultSet.
			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				System.out.println("Escribe el domicilio del socio a modificar:");
				String domicilioModificar = teclado.nextLine();
				System.out.println("Escribe el telefono del socio a modificar:");
				int telefonoModificar = teclado.nextInt();
				teclado.nextInt();
				PreparedStatement pstmt = conexion.prepareStatement("UPDATE SOCIO SET Domicilio = ? WHERE Codigo = ?");
				pstmt.setString(codigo, domicilioModificar);
				pstmt = conexion.prepareStatement("UPDATE SOCIO SET Telefono = ? WHERE Codigo = ?");
				pstmt.setInt(codigo, telefonoModificar);
				int filas = pstmt.executeUpdate();
				System.out.println("Correcto");

			}

			conexion.commit();
			// cerrar los recursos
			resultado.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
