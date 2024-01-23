package app;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import datos.Autor;
import datos.Jugador;
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

		baseDatos.close();
	}
	
	public void insertarAutores(ODB baseDatos) {
		String nombre, apellido,nacionalidad;
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

		baseDatos.close();
	}
	
	public void modificarLibro(ODB baseDatos) {
		String titulo, autor;
		int numAutores;
		Libro l1 = new Libro();
		System.out.println("Introduzca el titulo del libro: ");
		titulo = teclado.nextLine();
		IQuery query = new CriteriaQuery(Libro.class, Where.equal("titulo", titulo));
		List<Autor> autores = null;
		
		System.out.println("¿Cuantos autores tiene el libro?: ");
		numAutores = teclado.nextInt();
		for (int i = 0; i < numAutores; i++) {
			System.out.println("Introduzca el nombre del autor del libro (solo uno): ");
			autor = teclado.nextLine();
			IQuery query2 = new CriteriaQuery(Autor.class, Where.equal("nombre", autor));
			Objects<Autor> losautores = baseDatos.getObjects(query2);
			
			
		}
		l1.setAutores(autores);
		
		baseDatos.close();
		
		
		baseDatos.store(l1);

		baseDatos.close();
	}
}
