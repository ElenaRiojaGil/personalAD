package xml.ejercicio22;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

/**
 * A partir del fichero XML “departamentos.xml” creado en el ejercicio anterior,
 * realiza un programa Java, utilizando el analizador sintáctico DOM, que lea
 * dicho fichero XML y que visualice por pantalla su estructura y contenido.
 * 
 * @author Elena Rioja
 *
 */
public class Ejercicio22 {
	public static void main(String[] args) {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document document = builder.parse(new File("departamentos.xml"));
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName()+"\n");

			// crear una lista de los libros
			NodeList departamentos = document.getElementsByTagName("dep");

			for (int i = 0; i < departamentos.getLength(); i++) {
				Node dep = departamentos.item(i);
				
				if (dep.getNodeType() == Node.ELEMENT_NODE) {
					
					//dep.getAttributes();
					Element elemento = (Element) dep;
					Node nodo1 = (Node) elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0);
					System.out.println("Numero de departamento: "+dep.getAttributes().item(0).getNodeValue());
					System.out.println("Nombre: " + nodo1.getNodeValue());

					nodo1 = (Node) elemento.getElementsByTagName("localidad").item(0).getChildNodes().item(0);
					System.out.println("localidad: " + nodo1.getNodeValue()+"\n");

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
