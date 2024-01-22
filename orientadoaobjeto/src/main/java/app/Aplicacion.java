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

		Jugador j1 = new Jugador("Ana", "Martinez", "tenis", new Date("1998/10/12"));
		Jugador j2 = new Jugador("Pedro", "Lopez", "tenis", new Date("1999/07/21"));
		Jugador j3 = new Jugador("Martin", "Gonzalez", "tenis", new Date("1999/12/12"));
		Jugador j4 = new Jugador("Paula", "Fernandez", "tenis", new Date("1997/08/06"));
		Jugador j5 = new Jugador("Santiago", "Vidal", "tenis", new Date("2000/01/12"));
		Jugador j6 = new Jugador("Patricia", "Perez", "baloncesto", new Date("2003/22/05"));
		Jugador j7 = new Jugador("Lara", "Gomez", "esgrima", new Date("2002/14/02"));
		Jugador j8 = new Jugador("Maria", "Vidal", "padel", new Date("2004/08/10"));
		
		baseDatos.store(j1);
		baseDatos.store(j2);
		baseDatos.store(j3);
		baseDatos.store(j4);
		baseDatos.store(j5);
		baseDatos.store(j6);
		baseDatos.store(j7);
		baseDatos.store(j8);
		
		HashSet<Jugador> cjtoJugadoresTenis = new HashSet();
		cjtoJugadoresTenis.add(j1);
		cjtoJugadoresTenis.add(j2);
		cjtoJugadoresTenis.add(j3);
		cjtoJugadoresTenis.add(j4);
		cjtoJugadoresTenis.add(j5);
		Equipo elEquipo = new Equipo("Tenis wins", "absoluta", cjtoJugadoresTenis);
		
		HashSet<Jugador> cjtoJugadoresBasket = new HashSet();
		cjtoJugadoresBasket.add(j6);
		
		Equipo elEquipo2 = new Equipo("Basket wins", "absoluta", cjtoJugadoresBasket);
		
		HashSet<Jugador> cjtoJugadoresEsgrima = new HashSet();
		cjtoJugadoresEsgrima.add(j7);
		
		Equipo elEquipo3 = new Equipo("Esgrima Team", "absoluta", cjtoJugadoresEsgrima);
		
		HashSet<Jugador> cjtoJugadoresPadel = new HashSet();
		cjtoJugadoresPadel.add(j8);
		
		Equipo elEquipo4 = new Equipo("Padel wins", "absoluta", cjtoJugadoresPadel);
		
		baseDatos.store(elEquipo);
		baseDatos.store(elEquipo2);
		baseDatos.store(elEquipo3);
		baseDatos.store(elEquipo4);
		baseDatos.commit();
		baseDatos.close();
		System.out.println("termine");
	}

}
