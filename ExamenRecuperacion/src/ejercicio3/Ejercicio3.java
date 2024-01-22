package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			//Crear una instancia del JDBC driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            //				jdbc:sqlite:
            // parametro 2 = nombre del usuario
            // parametro 3 = contraseña del usuario
			
			//Establecer una conexión usando el driver que crea el  objeto Connection.
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.102/AventurasVarias","elena","Pass!123456");
			
			//Crear un objeto Statement, usando Connection.
			
			 
			//Armar el postulado SQL y enviarlo a ejecución usando  el Statement.
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
			 
			 //cerrar los recursos
			 resultado.close();
			 sentencia.close();
			 conexion.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("No ha encontrado la clase");
		}

	}

}
