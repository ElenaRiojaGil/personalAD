package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import datos.Autor;
import datos.Libro;

public class Consultas {
	Scanner teclado = new Scanner(System.in);

	public void insertarLibro(ODB baseDatos) {
		String titulo, editorial;
		int agno, paginas;
		Libro l1 = new Libro();
		System.out.println("Introduzca el titulo del libro: ");
		titulo = teclado.nextLine();
		l1.setTitulo(titulo);
		System.out.println("Introduzca la editorial del libro: ");
		editorial = teclado.nextLine();
		l1.setEditorial(editorial);
		System.out.println("Introduzca el año de publicacion del libro: ");
		agno = teclado.nextInt();
		l1.setAgno(agno);
		System.out.println("Introduzca el numero de paginas del libro: ");
		paginas = teclado.nextInt();
		l1.setPaginas(paginas);

		baseDatos.store(l1);
		baseDatos.commit();

	}

	public void insertarAutores(ODB baseDatos) {
		String nombre, apellido, nacionalidad;
		int edad;

		Autor a1 = new Autor();
		System.out.println("Introduzca el nombre del autor: ");
		nombre = teclado.nextLine();
		a1.setNombre(nombre);
		System.out.println("Introduzca el apellido del autor: ");
		apellido = teclado.nextLine();
		a1.setApellido(apellido);
		System.out.println("Introduzca la nacionalidad del autor: ");
		nacionalidad = teclado.nextLine();
		a1.setNacionalidad(nacionalidad);
		System.out.println("Introduzca la edad del autor: ");
		edad = teclado.nextInt();
		a1.setEdad(edad);

		baseDatos.store(a1);
		baseDatos.commit();

	}

	public static void mostrarL(ODB baseDatos) {
		Objects<Libro> losJugadores = baseDatos.getObjects(Libro.class);
		for (Iterator iterator = losJugadores.iterator(); iterator.hasNext();) {
			Libro jugador = (Libro) iterator.next();
			System.out.println(jugador.getTitulo());

		}

	}

	public static void mostrarA(ODB baseDatos) {
		Objects<Autor> losJugadores = baseDatos.getObjects(Autor.class);
		for (Iterator iterator = losJugadores.iterator(); iterator.hasNext();) {
			Autor jugador = (Autor) iterator.next();
			System.out.println(jugador.getNombre() + " " + jugador.getApellido());

		}

	}

	public void modificarLibro(ODB baseDatos) {
		mostrarL(baseDatos);

		// Solicitar al usuario el título del libro a modificar
		System.out.println("Introduzca el titulo del libro: ");
		String titulo = teclado.nextLine();

		// Buscar el libro en la base de datos
		IQuery query = new CriteriaQuery(Libro.class, Where.equal("titulo", titulo));
		Objects<Libro> libros = baseDatos.getObjects(query);

		if (libros.size() > 0) {
			// Obtener el libro
			Libro libro = libros.getFirst();

			// Mostrar todos los autores
			mostrarA(baseDatos);

			// Solicitar al usuario el nombre del autor a añadir al libro
			System.out.println("Introduzca el nombre del autor del libro: ");
			String nombre = teclado.nextLine();

			// Buscar el autor en la base de datos
			IQuery query2 = new CriteriaQuery(Autor.class, Where.equal("nombre", nombre));
			Objects<Autor> autores = baseDatos.getObjects(query2);

			if (autores.size() > 0) {
				// Obtener el autor
				Autor autor = autores.getFirst();

				// Verificar si el conjunto de autores en el libro es null y, si es así,
				// inicializarlo
				if (libro.getAutores() == null) {
					libro.setAutores(new ArrayList<>());
				}

				// Asignar el autor al libro
				libro.getAutores().add(autor);

				// Almacenar el libro modificado en la base de datos y realizar un commit
				baseDatos.store(libro);
				baseDatos.commit();

				System.out.println("Autor añadido al libro correctamente.");
			} else {
				System.out.println("No se encontró el autor en la base de datos.");
			}
		} else {
			System.out.println("No se encontró el libro en la base de datos.");
		}
	}

	public void nombresEm(ODB baseDatos) {
		
	
}
	public void numEm(ODB baseDatos) {
		
		
}

public void numEmxDep(ODB baseDatos) {
		
		
}


}
