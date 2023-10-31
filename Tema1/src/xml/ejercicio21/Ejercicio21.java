package xml.ejercicio21;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import aleatorio.ejercicio18.Departamento;
import aleatorio.ejercicio19.GestionDepartamentos;

/**
 * A partir del fichero binario “departamentos.dat” creado en el ejercicio 18,
 * realiza un programa Java, utilizando el analizador sintáctico DOM, que cree
 * un fichero XML “departamentos.xml” y que visualice por pantalla su estructura
 * y contenido.
 * 
 * @author alu
 *
 */

public class Ejercicio21 {
	public static void main(String[] args) throws IOException {
		GestionDepartamentos departamentos = new GestionDepartamentos("departamentos.dat");

		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementatio = builder.getDOMImplementation();
			departamentos.abrir();

			Document document = implementatio.createDocument(null, "Departamentos", null);
			document.setXmlVersion("1.0");

			Departamento d;
			departamentos.iniciarXML();

			while (!departamentos.finFichero()) {

				d = departamentos.leer();
				// System.out.println(d);
				if (d != null) {

					if (d.getNumero() > 0) {
						Element elementoEmpleado = document.createElement("dep");
						document.getDocumentElement().appendChild(elementoEmpleado);

						// System.out.println(Integer.toString(d.getNumero()));

						elementoEmpleado.setAttribute("id", Integer.toString(d.getNumero()));
						CrearElemento("nombre", d.getNombre().trim(), elementoEmpleado, document);
						CrearElemento("localidad", d.getLocalidad().trim(), elementoEmpleado, document);

					}

				}

			}
			Source input = new DOMSource(document);
			Result output = new StreamResult(new File("departamentos.xml"));
			Transformer idTransform = TransformerFactory.newInstance().newTransformer();
			idTransform.transform(input, output);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void CrearElemento(String dato, String valor, Element raiz, Document document) {

		Element elem = document.createElement(dato);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}

}