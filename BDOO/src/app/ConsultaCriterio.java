package app;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import org.neodatis.odb.Objects;

import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import datos.Jugador;

public class ConsultaCriterio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ODB baseDatos = ODBFactory.open("baseDatos/testOO", "miusuario", "Pass!123456");

		IQuery query = new CriteriaQuery(Jugador.class, Where.equal("deporte", "tenis"));
		Objects<Jugador> losTenistas = baseDatos.getObjects(query);

		for (Jugador jugador : losTenistas) {
			System.out.println(jugador.getNombre() + " " + jugador.getApellidos());
		}
		System.out.println();
		IQuery query2 = new CriteriaQuery(Jugador.class,
				new And().add(Where.equal("deporte", "tenis")).add(Where.like("nombre", "P%")));
		Objects<Jugador> losTenistas2 = baseDatos.getObjects(query2);
		for (Jugador jugador : losTenistas2) {
			System.out.println(jugador.getNombre() + " " + jugador.getApellidos());
		}
		baseDatos.close();

	}

}
