package app;

import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

import datos.Equipo;
import datos.Jugador;

public class ConsultaJugadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ODB baseDatos = ODBFactory.open("baseDatos/testOO", "miusuario", "Pass!123456");
		
		Objects<Jugador> losJugadores= baseDatos.getObjects(Jugador.class);
		for (Iterator iterator = losJugadores.iterator(); iterator.hasNext();) {
			Jugador jugador = (Jugador) iterator.next();
			System.out.println(jugador.getNombre());
			
		}
		
		OID idDelEquipo= OIDFactory.buildObjectOID(11);
		Equipo elEquipo=(Equipo) baseDatos.getObjectFromId(idDelEquipo);
		System.out.println(elEquipo);
		
		baseDatos.close();

	}

}
