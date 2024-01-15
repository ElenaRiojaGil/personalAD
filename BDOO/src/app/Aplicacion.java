package app;


import java.util.Date;
import java.util.HashSet;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import datos.Equipo;
import datos.Jugador;

public class Aplicacion {

	public static void main(String[] args) {

		// Conectarnos a la BD
		ODB baseDatos = ODBFactory.open("baseDatos/testOO", "miusuario", "Pass!123456");

		Jugador j1 = new Jugador("Ana", "Martinez", "tenis", new Date("1999/12/12"));
		Jugador j2 = new Jugador("Pedro", "Lopez", "tenis", new Date("1999/12/12"));
		Jugador j3 = new Jugador("Martin", "Gonzalez", "tenis", new Date("1999/12/12"));
		Jugador j4 = new Jugador("Paula", "Fernandez", "tenis", new Date("1999/12/12"));
		Jugador j5 = new Jugador("Santiago", "Vidal", "tenis", new Date("2000/01/12"));

		HashSet<Jugador> cjtoJugadores = new HashSet();
		cjtoJugadores.add(j1);
		cjtoJugadores.add(j2);
		cjtoJugadores.add(j3);
		cjtoJugadores.add(j4);
		cjtoJugadores.add(j5);
		Equipo elEquipo = new Equipo("Tenis wins", "absoluta", cjtoJugadores);
		baseDatos.store(elEquipo);
		baseDatos.commit();
		baseDatos.close();
		System.out.println("termine");
	}

}
