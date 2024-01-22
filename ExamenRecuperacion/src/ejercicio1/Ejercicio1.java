package ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Ejercicio1 {

	public static void main(String[] args) {
		File mifichero = new File("src//AventurasVarias.txt");
		try {
			try {
				// CARGAR EL CONTROLADOR JDBC de la base de datos
				Class.forName("org.sqlite.JDBC");

				// ESTABLECER LA CONEXIÓN con la base de datos
				Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\AventurasVarias.db");
				// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
				// jdbc:sqlite:C:\\Users\\Eva Royo\\Documents\\BBDD\\sqlite\\biblioteca.db
				// parametro 2 = nombre del usuario
				// parametro 3 = contraseña del usuario
			FileReader lector = new FileReader(mifichero);
			int caracter = lector.read();
			while (caracter > 0) {
				String linea = "";

				while (caracter != '\n' && caracter != -1) {
					linea = linea + (char) caracter;
					caracter = lector.read();

				}

				System.out.println(linea);
				String datos[] = linea.split(";");
				String nombre = datos[0];
				String apellidos = datos[1];
				System.out.println(apellidos);
				String telefono = datos[2];
				String direccion = datos[3];
				String correo = datos[4];
				String vip = datos[5];
				String nacionalidad = datos[6];

			
			// TODO Auto-generated method stub
			

				// PREPARAMOS LA SENTENCIA SQL
				String sql = "INSERT INTO Clientes VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement pstm = conexion.prepareStatement(sql);
				pstm.setString(2, nombre);
				pstm.setString(3, apellidos);
				pstm.setString(4, telefono);
				pstm.setString(5, direccion);
				pstm.setString(6, correo);
				if(vip!="") {
				pstm.setInt(7, 1);
				}else {
					pstm.setInt(7, 0);
				}
				pstm.setString(8, nacionalidad);
				
				// 3,5,'2021-11-09','2021-11-19'
				int cantidad = pstm.executeUpdate();
				caracter = lector.read();

				// LIBRERAR LOS RECURSOS
			}

				conexion.close();
				lector.close();

			} catch (SQLException | ClassNotFoundException ex) {
				System.out.println("Error en la conexión de la base de datos");
				ex.printStackTrace();
			}

			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
