
import java.beans.Statement;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.sql.Types;

import java.util.Scanner;

public class GestionApache {

	static Scanner teclado = new Scanner(System.in);

	public boolean validarNombreTabla(String nomTabla, Connection conexion, String consulta) {

		try {

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setString(1, nomTabla);

			ResultSet resultado = sentencia.executeQuery();

			return resultado.next();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false;

	}

	public void listadoDatos(Connection conexion) {

		System.out.println("Introduzca el nombre de la tabla: ");

		String nomTabla = teclado.nextLine();

		nomTabla = nomTabla.toLowerCase();

		String consulta = "select * from ? ";

		if (validarNombreTabla(nomTabla, conexion, consulta)) {

			try {

				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, nomTabla);

				ResultSet resultado = sentencia.executeQuery();

				ResultSetMetaData rsmd = resultado.getMetaData();

				int numeroColumnas = rsmd.getColumnCount();

				// recorro el resultado

				while (resultado.next()) {

					for (int i = 1; i <= numeroColumnas; i++) {

						switch (rsmd.getColumnType(i)) {

						case Types.INTEGER:

							System.out.println(rsmd.getColumnLabel(i) + " = " + resultado.getInt(i));

							break;

						case Types.VARCHAR:

							System.out.println(rsmd.getColumnLabel(i) + " = " + resultado.getString(i));

							break;

						case Types.FLOAT:

							System.out.println(rsmd.getColumnLabel(i) + " = " + resultado.getFloat(i));

							break;

						default:

							System.out.println("Tipo de dato desconocido.");

							break;

						}

					}

					System.out.println("------------------------");

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

	}

	public void insertarDatoEnTabla() {

	}

	public void modificalDatoTabla() {

	}

	public void consulta() {

	}

}
