package app;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

import datos.*;
/**
 * Realiza un programa Java que utilice Hibernate para ejecutar las siguientes operaciones de
gestión de objetos mapeados a partir de la base de datos personal:
A) Modificar un departamento.
B) Insertar un empleado.
C) Leer un empleado, y además, su departamento correspondiente.
D) Eliminar un empleado.
E) Eliminar un departamento. Previamente, se debe eliminar todos los empleados de dicho
departamento. Utiliza una transacción. (OPCIONAL)
En cada apartado, añade las comprobaciones necesarias en caso de errores, visualiza en
pantalla los mensajes apropiados para todas las situaciones y también los atributos de los
objetos manipulados en Java.

 */
public class Main {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		System.out.println("Leo los empleados");	
		Query<Empleado> q = sesion.createQuery("from Empleado");
		
		List <Empleado> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator <Empleado> iter = lista.iterator();
		System.out.println("N�mero de registros:"  + lista.size());
		while (iter.hasNext())
		{
		   //extraer el objeto
			Empleado empleado = (Empleado) iter.next(); 
			System.out.println("Empleado nombre = " + empleado.getApellido() + " salario=" + empleado.getSalario());		   
		}

		System.out.println("FUNCIONO!!");
		
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		System.exit(0);	
		
	}

}
