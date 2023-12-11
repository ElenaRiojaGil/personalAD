<<<<<<< HEAD
package ejercicio9;

public class Gestion {
	

}
=======
package ejercicio9;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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
public class Gestion {
	Scanner teclado = new Scanner(System.in);

	public  boolean validarSocio(Connection conexion, int codigoSocio) {

		try {

			String consulta = "select * from socio WHERE Codigo = " + codigoSocio;
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();
			return resultado.next();

		} catch (SQLException e) {
			System.err.println("Error en la sentencia SQL " + e);
			e.printStackTrace();
		}
		return false;
	}

	public  void lecturaDatos(Connection conexion, String consulta) {
		try {
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(consulta);
			ResultSetMetaData rsmd = resultado.getMetaData();
			int numeroColumnas = rsmd.getColumnCount();

			while (resultado.next()) {

				for (int i = 1; i <= numeroColumnas; i++) {

					switch (rsmd.getColumnType(i)) {
					case Types.INTEGER:
						System.out.println(rsmd.getColumnLabel(i) + " : " + resultado.getInt(i));
						break;
					case Types.VARCHAR:
						System.out.println(rsmd.getColumnLabel(i) + " : " + resultado.getString(i));
						break;
					case Types.DATE:
						System.out.println(rsmd.getColumnLabel(i) + " : " + resultado.getDate(i));
						break;
					}
				}
				System.out.println("-----------------------------------");
			}

			conexion.close();
			sentencia.close();
			resultado.close();

		} catch (SQLException e) {
			if (conexion != null) {
				System.err.println("Error de conexion");
				e.printStackTrace();
			}
		}
	}

	public void modificarDatos(Connection conexion, int codigo ) {
		String domicilio;
		int telefono;
		System.out.println("Introduzca la nueva direccion del domicilio: ");
		domicilio = teclado.nextLine();
		System.out.println("Introduzca el nuevo numero de telefono: ");
		telefono = teclado.nextInt();

		String consulta2 = "UPDATE socio SET Domicilio= ? , telefono = ? WHERE Codigo = ?;";
		PreparedStatement sentenciaPrepared;
		try {
			sentenciaPrepared = conexion.prepareStatement(consulta2);

			sentenciaPrepared.setString(1, domicilio);
			sentenciaPrepared.setInt(2, telefono);
			sentenciaPrepared.setInt(3, codigo);
			sentenciaPrepared.executeUpdate();

			String consulta = "select * from socio where Codigo = " + codigo;
			lecturaDatos(conexion, consulta);

			sentenciaPrepared.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
>>>>>>> branch 'master' of https://github.com/ElenaRiojaGil/personalAD.git
