
import java.sql.Statement;

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

			Statement sentencia = (Statement) conexion.createStatement();

			ResultSet resultado = sentencia.executeQuery(consulta);

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

		String consulta = "select * from " + nomTabla;

		if (validarNombreTabla(nomTabla, conexion, consulta)) {

			try {

				Statement sentencia = (Statement) conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(consulta);

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

	public void insertarDatoEnTabla(Connection conexion) {
		System.out.println("Introduzca el nombre de la tabla: ");

		String nomTabla = teclado.nextLine();

		// nomTabla = nomTabla.toLowerCase();

		String consulta = "select * from " + nomTabla;

		if (validarNombreTabla(nomTabla, conexion, consulta)) {
			String sql = "";
			String nombre, apellido, direccion, telefono, fechaNac, fechaFin, fechaInicio,idlibro,idsocio,titulo;
			try {
				switch (nomTabla) {

				case "socio":
					System.out.println("Introduzca el nombre de la tabla: ");

					nombre = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					apellido = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					direccion = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					telefono = teclado.nextLine();
					sql = "INSERT INTO socio VALUES (?,?,?,?)";
					PreparedStatement pstm = conexion.prepareStatement(sql);
					pstm.setString(1, nombre);
					pstm.setString(2, apellido);
					pstm.setString(3, direccion);
					pstm.setString(4, telefono);
					// 3,5,'2021-11-09','2021-11-19'
					int cantidad = pstm.executeUpdate();

					break;

				case "prestamo":
					System.out.println("Introduzca el nombre de la tabla: ");

					idsocio = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					idlibro = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					fechaInicio = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					fechaFin = teclado.nextLine();
					sql = "INSERT INTO prestamo VALUES (?,?,?,?)";
					PreparedStatement pstmp = conexion.prepareStatement(sql);
					pstmp.setString(1, idsocio);
					pstmp.setString(2, idlibro);
					pstmp.setString(3, fechaInicio);
					pstmp.setString(4, fechaFin);
					// 3,5,'2021-11-09','2021-11-19'
					int cantidadp = pstmp.executeUpdate();

					break;

				case "libro":
					System.out.println("Introduzca el nombre de la tabla: ");

					titulo = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					idlibro = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					fechaInicio = teclado.nextLine();
					System.out.println("Introduzca el nombre de la tabla: ");

					fechaFin = teclado.nextLine();
					sql = "INSERT INTO prestamo VALUES (?,?,?,?)";
					PreparedStatement pstml = conexion.prepareStatement(sql);
					pstml.setString(1, titulo);
					pstml.setString(2, idlibro);
					pstml.setString(3, fechaInicio);
					pstml.setString(4, fechaFin);
					// 3,5,'2021-11-09','2021-11-19'
					int cantidadl = pstml.executeUpdate();

					break;

				default:

					System.out.println("Tipo de dato desconocido.");

					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void modificalDatoTabla() {

	}

	public void consulta() {

	}

}
