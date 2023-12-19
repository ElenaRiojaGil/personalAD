package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class gestionDep {
	Scanner teclado=new Scanner (System.in);
	
	public void modificarDep(Connection conexion, int codigo ) {
		String nombre;
		String localidad;
		System.out.println("Introduzca la nueva direccion del domicilio: ");
		nombre = teclado.nextLine();
		System.out.println("Introduzca el nuevo numero de telefono: ");
		localidad = teclado.nextLine();

		String consulta2 = "UPDATE socio SET nombre= ? , localidad = ? WHERE idDep = ?;";
		PreparedStatement sentenciaPrepared;
		try {
			sentenciaPrepared = conexion.prepareStatement(consulta2);

			sentenciaPrepared.setString(1, nombre);
			sentenciaPrepared.setString(2, localidad);
			sentenciaPrepared.setInt(3, codigo);
			sentenciaPrepared.executeUpdate();

			String consulta = "select * from socio where Codigo = " + codigo;
		//	lecturaDatos(conexion, consulta);

			sentenciaPrepared.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertarEmpleado(Connection conexion, int codigo ) {
		String nombre;
		String localidad;
		System.out.println("Introduzca la nueva direccion del domicilio: ");
		nombre = teclado.nextLine();
		System.out.println("Introduzca el nuevo numero de telefono: ");
		localidad = teclado.nextLine();

		String consulta2 = "insert Empleado VALUES (?,?,?,?);";
		PreparedStatement sentenciaPrepared;
		try {
			sentenciaPrepared = conexion.prepareStatement(consulta2);

			sentenciaPrepared.setString(1, nombre);
			sentenciaPrepared.setString(2, localidad);
			sentenciaPrepared.setInt(3, codigo);
			sentenciaPrepared.executeUpdate();

			String consulta = "select * from socio where Codigo = " + codigo;
		//	lecturaDatos(conexion, consulta);

			sentenciaPrepared.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
