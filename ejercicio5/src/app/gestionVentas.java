package app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
import datos.Producto;
import datos.Venta;

public class gestionVentas {
	Scanner teclado = new Scanner(System.in);

	public void modificarProductos(Session sesion) {

		System.out.println("Leo los productos");
		Transaction tx = sesion.beginTransaction();

		Query<Producto> q = sesion.createQuery("from Producto");

		List<Producto> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		System.out.println("N�mero de registros:" + lista.size());
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Producto productos = (Producto) iterator.next();
			System.out.println("Producto = id:" + productos.getId() + " precio: " + productos.getPrecio());
			System.out.println("------------------------");

		}

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			float iva = producto.getPrecio() * 0.21f;
			float precio = iva + producto.getPrecio();
			producto.setPrecio(precio);
			sesion.update(producto);

		}
		System.out.println("Leo los productos con el iva añadido ");

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Producto productos = (Producto) iterator.next();
			System.out.println("Producto = id:" + productos.getId() + " precio: " + productos.getPrecio());
			System.out.println("------------------------");

		}

		tx.commit();

	}

	public void eliminarVentas(Session sesion) {

		Query<Cliente> q = sesion.createQuery("from Cliente");
		List<Cliente> listaClientes = q.list();

		System.out.println("Lista de clientes:");
		for (Cliente cliente : listaClientes) {
			System.out.println("Cliente: Id = " + cliente.getId() + " nombre = " + cliente.getNombre());
			System.out.println("------------------------");
		}

		System.out.println("¿Qué ventas realizadas por el cliente desea eliminar? Introduzca el id: ");
		int idVenta = teclado.nextInt();
		teclado.nextLine(); // Consumir el salto de línea pendiente

		Venta ventaEliminar = sesion.get(Venta.class, idVenta);

		if (ventaEliminar != null) {
			System.out.println("¿Está seguro que quiere eliminar la venta? (Y/N)");
			String decision = teclado.nextLine().toUpperCase();

			if ("Y".equals(decision)) {
				Transaction tx = sesion.beginTransaction();
				sesion.delete(ventaEliminar);
				tx.commit();
				System.out.println("Venta eliminada correctamente.");
			} else {
				System.out.println("Operación cancelada.");
			}
		} else {
			System.out.println("No se encontró ninguna venta con el id proporcionado.");
		}
	}
}
