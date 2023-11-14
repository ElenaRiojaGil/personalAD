

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploMySQl {

	public static void main(String[] args) {
		try {
			//Crear una instancia del JDBC driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            //				jdbc:sqlite:
            // parametro 2 = nombre del usuario
            // parametro 3 = contraseña del usuario
			
			//Establecer una conexión usando el driver que crea el  objeto Connection.
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.102/Tienda","elena","Pass!123456");
			
			//Crear un objeto Statement, usando Connection.
			
			 
			//Armar el postulado SQL y enviarlo a ejecución usando  el Statement.
			 Statement sentencia = (Statement) conexion.createStatement();
			 ResultSet resultado = sentencia.executeQuery("select * from Cliente");
			
			 //Recibir los resultados en el objeto ResultSet.
			 while(resultado.next()) {
				 System.out.println(resultado.getInt(1)+"-"+resultado.getString(2));
			 }
			 
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
