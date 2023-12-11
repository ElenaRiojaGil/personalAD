package ejercicio2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import java.util.Scanner;

public class Negocia {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in) ;
		try {
			//Crear una instancia del JDBC driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Especificar la url de la base de datos.
			// parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            //				jdbc:sqlite:
            // parametro 2 = nombre del usuario
            // parametro 3 = contraseña del usuario
			
			//Establecer una conexión usando el driver que crea el  objeto Connection.
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.102/sindicatos","elena","Pass!123456");
			
			//Crear un objeto Statement, usando Connection.
			
			 
			//Armar el postulado SQL y enviarlo a ejecución usando  el Statement.
			 Statement sentencia = (Statement) conexion.createStatement();
			 ResultSet resultado = sentencia.executeQuery("select * from NegociacionesColectivas");
			 ResultSetMetaData rsmd = resultado.getMetaData();
			 int numeroColumnas = rsmd.getColumnCount();
			 //Recibir los resultados en el objeto ResultSet.
			 while(resultado.next()) {
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
						case Types.DATE:

							System.out.println(rsmd.getColumnLabel(i) + " = " + resultado.getDate(i));

							break;

						default:

							System.out.println("Tipo de dato desconocido.");

							break;

						}

					}

					System.out.println("------------------------");

				}
			 System.out.println("Elija el id del cual quiere modificar la fecha fin y el resultado");
				int id=teclado.nextInt();
				teclado.nextLine();
			 ResultSet resultadoMod = sentencia.executeQuery("select * from NegociacionesColectivas WHERE id=" + id);

				// Recibir los resultados en el objeto ResultSet.
				while (resultadoMod.next()) {
					
					System.out.println("Introduzca la fecha fin");
					String fecha=teclado.nextLine();
					
					System.out.println("Introduzca el resultado");
					String resultad=teclado.nextLine();
					PreparedStatement pstmt = conexion.prepareStatement("UPDATE NegociacionesColectivas SET fecha_fin = ? WHERE id = ?");
					Date fechaMod=Date.valueOf(fecha);
					pstmt.setDate(1, fechaMod);
					pstmt.setInt(2, id);
					int filas = pstmt.executeUpdate();
					
					pstmt = conexion.prepareStatement("UPDATE  NegociacionesColectivas SET resultado = ? WHERE id = ?");
					pstmt.setString(id, resultad);
					int filas2 = pstmt.executeUpdate();
					System.out.println("Correcto");

				}
				
				ResultSet resultadotra = sentencia.executeQuery("select * from trabajadores where sindicato_id=(select sindicato_id from NegociacionesColectivas where CURRENT_DAY()>NegociacionesColectivas.fecha_inicio && CURRENT_DAY()<NegociacionesColectivas.fecha_fin)");
				 ResultSetMetaData rsmdtra = resultado.getMetaData();
				 int numeroColumnastra = rsmd.getColumnCount();
				 //Recibir los resultados en el objeto ResultSet.
				 while(resultado.next()) {
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
							case Types.DATE:

								System.out.println(rsmd.getColumnLabel(i) + " = " + resultado.getDate(i));

								break;

							default:

								System.out.println("Tipo de dato desconocido.");

								break;

							}

						}

						System.out.println("------------------------");

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
