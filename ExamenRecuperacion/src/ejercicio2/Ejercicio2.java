package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		try {
			// CARGAR EL CONTROLADOR JDBC de la base de datos
			Class.forName("org.sqlite.JDBC");

			// ESTABLECER LA CONEXIÓN con la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\ejercicio2\\AventurasVarias.db");
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
			// jdbc:sqlite:C:\\Users\\Eva Royo\\Documents\\BBDD\\sqlite\\biblioteca.db
			// parametro 2 = nombre del usuario
			// parametro 3 = contraseña del usuario

			// PREPARAMOS LA SENTENCIA SQL
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from Clientes where vip='1'");

			// recorro el resultado
			System.out.println("Vip");
			while (resultado.next()) {
				System.out.println(resultado.getString(1) + " - " + resultado.getString(2) + " - " + resultado.getString(3)
						+ " - " + resultado.getString(4) + " - " + resultado.getString(5) + " - " + resultado.getString(6)
						+ " - " + resultado.getString(8));
			}
			resultado = sentencia.executeQuery("select * from Clientes where vip='0'");
			System.out.println("no Vip");
			// recorro el resultado
			while (resultado.next()) {
				System.out.println(resultado.getString(1) + " - " + resultado.getString(2) + " - " + resultado.getString(3)
						+ " - " + resultado.getString(4) + " - " + resultado.getString(5) + " - " + resultado.getString(6)
						+ " - " + resultado.getString(8));
			}
			
			System.out.println("--------------------------------------");
			System.out.println("Lista clientes");
			resultado = sentencia.executeQuery("select * from Clientes");
		
			// recorro el resultado
			while (resultado.next()) {
				System.out.println(resultado.getString(1) + " - " + resultado.getString(2));
			}
			System.out.println("introduzca el id del cliente que quiere modificar el telefono: ");
			int id=teclado.nextInt();
			teclado.nextLine();
			System.out.println("introduzca el nuevo numero de telefono del cliente: ");
			String telefono=teclado.nextLine();
			resultado = sentencia.executeQuery("select * from Clientes where id="+id);
			PreparedStatement pstmt = conexion.prepareStatement("UPDATE Clientes SET telefono = ? WHERE id = ?");
			
			pstmt.setString(1, telefono);
			pstmt.setInt(2, id);
			int filas = pstmt.executeUpdate();
			
			// LIBRERAR LOS RECURSOS
			resultado.close();
			sentencia.close();
			conexion.close();
			teclado.close();

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error en la conexión de la base de datos");
			ex.printStackTrace();
		}

	}

}
