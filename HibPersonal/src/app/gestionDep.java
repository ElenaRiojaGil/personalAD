package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import datos.*;

public class gestionDep {
	Scanner teclado = new Scanner(System.in);

	/**
	 * Modifica un departamento ya existente
	 * 
	 * @param conexion
	 * @param codigo
	 */
	public Departamento modificarDep(Session sesion) {
		byte id;
		System.out.println("Leo los departamentos");
		Transaction tx = sesion.beginTransaction();

		Query<Departamento> q = sesion.createQuery("from Departamento");

		List<Departamento> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		System.out.println("N�mero de registros:" + lista.size());

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Departamento departamento = (Departamento) iterator.next();
			System.out.println("Departamento = id:" + departamento.getIdDep()+" nombre: "+departamento.getNombre()+" localizacion:"+departamento.getLocalidad());
			System.out.println("------------------------");

		}

		String nombre;
		String localidad;
		System.out.println("Introduzca el id del departamento a modificar: ");
		id = teclado.nextByte();
		teclado.nextLine();
		System.out.println("Introduzca la nueva nombre: ");
		nombre = teclado.nextLine();
		System.out.println("Introduzca el nuevo numero de localidad: ");
		localidad = teclado.nextLine();
		
		Departamento empDepModifi = (Departamento) sesion.get(Departamento.class, id);
		//Set empleados = empDepModifi.getEmpleados();
		//Departamento depModificado = new Departamento();
		empDepModifi.setIdDep(id);
		empDepModifi.setLocalidad(localidad);
		empDepModifi.setNombre(nombre);
		sesion.update(empDepModifi);
		
		
		System.out.println("N�mero de registros:" + lista.size());

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Departamento departamento = (Departamento) iterator.next();
			System.out.println("Departamento = id:" + departamento.getIdDep()+" nombre: "+departamento.getNombre()+" localizacion:"+departamento.getLocalidad());
			System.out.println("------------------------");

		}
		
		tx.commit();
		return empDepModifi;
	

	
	}

	/**
	 * Inserta un nuevo empleado
	 * 
	 * @param conexion
	 */
	public void insertarEmpleado(Session sesion) {
		String apellido, oficio, fechaAlta;
		float salario, comision;
		short idEmp;
		byte idDep;

		System.out.println("Introduzca el id del departamento del nuevo empleado: ");
		idEmp = teclado.nextShort();
		try {
			// creamos la transacci�n de la sesi�n

			Empleado q = (Empleado) sesion.get(Empleado.class, idEmp);
			while (q == null) {
				System.out.println("Introduzca el id del nuevo empleado: ");
				idEmp = teclado.nextShort();
				q = (Empleado) sesion.get(Empleado.class, idEmp);
			}

			System.out.println("Introduzca el apellido del nuevo empleado: ");
			apellido = teclado.nextLine();
			System.out.println("Introduzca el oficio del nuevo empleado: ");
			oficio = teclado.nextLine();
			System.out.println("Introduzca el apellido del nuevo empleado: ");
			fechaAlta = teclado.nextLine();
			Date fechaModAlta = Date.valueOf(fechaAlta);
			teclado.nextLine();
			System.out.println("Introduzca el salario del nuevo empleado: ");
			salario = teclado.nextFloat();
			System.out.println("Introduzca la comision del nuevo empleado: ");
			comision = teclado.nextFloat();
			System.out.println("Introduzca el id del departamento del nuevo empleado: ");
			idDep = teclado.nextByte();
			Departamento id_dep = (Departamento) sesion.get(Departamento.class, idDep);
			while (id_dep == null) {
				System.out.println("Introduzca un id de departamento existente: ");
				idDep = teclado.nextByte();
				id_dep = (Departamento) sesion.get(Departamento.class, idDep);
			}

			Empleado nuevoEmp = new Empleado(idEmp, id_dep, apellido, oficio, fechaModAlta, salario, comision);

			sesion.save(nuevoEmp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated catch block

	}

	/**
	 * lee todos los datos de un empleado en concreto
	 * 
	 * @param conexion
	 */
	public void leer(Session sesion) {
		try {

			// creamos la transacci�n de la sesi�n
			System.out.println("Introduzca el id del departamento del nuevo empleado: ");
			int idEmp = teclado.nextShort();

			Empleado q = (Empleado) sesion.get(Empleado.class, idEmp);
			if (q != null) {
				System.out.println(q);
			}
			System.out.println("------------------------");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void eliminarEmp(Session sesion) {
		int id;
		System.out.println("Leo los empleados");
		Query<Empleado> q = sesion.createQuery("from Empleado");

		List<Empleado> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator<Empleado> iter = lista.iterator();
		System.out.println("N�mero de registros:" + lista.size());
		while (iter.hasNext()) {
			// extraer el objeto
			Empleado empleado = (Empleado) iter.next();
			System.out.println("Empleado id =" + empleado.getIdEmp() + "nombre = " + empleado.getApellido());
			System.out.println("------------------------");

		}
		String decision = "N";
		while (decision.toUpperCase() == "N")
			System.out.println("¿Que empleado desea eliminar? Introduzca el id: ");
		id = teclado.nextInt();
		Empleado empEliminar = (Empleado) sesion.get(Empleado.class, id);
		if (q != null) {
			System.out.println("Esta seguro que quiere eliminar el empleado: " + empEliminar + " (Y/N)");
			decision = teclado.nextLine();

		}
	}

}
