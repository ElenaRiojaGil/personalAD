package app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Producto;
import datos.Venta;

public class gestionVentas {
	Scanner teclado = new Scanner(System.in);

	public Producto modificarProductos(Session sesion) {
		byte id;
		System.out.println("Leo los departamentos");
		Transaction tx = sesion.beginTransaction();

		Query<Producto> q = sesion.createQuery("from Producto");

		List<Producto> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		System.out.println("N�mero de registros:" + lista.size());
		float precio=0;
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			float iva=producto.getPrecio()*(21/100);
			 precio=iva+producto.getPrecio();
	
		

		}

	

		Producto empDepModifi = (Producto) sesion.get(Producto.class, precio);
		// Set empleados = empDepModifi.getEmpleados();
		// Departamento depModificado = new Departamento();
		empDepModifi.setPrecio(precio);
		sesion.update(empDepModifi);

		System.out.println("N�mero de registros:" + lista.size());

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Producto departamento = (Producto) iterator.next();
			System.out.println("Producto = id:" + departamento.getId() + " nombre: " + departamento.getDescripcion()
					+ " localizacion:" + departamento.getPrecio());
			System.out.println("------------------------");

		}

		tx.commit();
		return empDepModifi;

	}

	public void eliminarVentas(Session sesion) {
		int id;
		System.out.println("Leo los empleados");
		Query<Venta> q = sesion.createQuery("from Empleado");

		List<Venta> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator<Venta> iter = lista.iterator();
		System.out.println("N�mero de registros:" + lista.size());
		while (iter.hasNext()) {
			// extraer el objeto
			Venta empleado = (Venta) iter.next();
			//System.out.println("Empleado id =" + empleado.getIdEmp() + "nombre = " + empleado.getApellido());
			System.out.println("------------------------");

		}
		String decision = "N";
		while (decision.toUpperCase() == "N")
			System.out.println("¿Que empleado desea eliminar? Introduzca el id: ");
		id = teclado.nextInt();
		Venta empEliminar = (Venta) sesion.get(Venta.class, id);
		if (q != null) {
			System.out.println("Esta seguro que quiere eliminar el empleado: " + empEliminar + " (Y/N)");
			decision = teclado.nextLine();

		}

	}
}
