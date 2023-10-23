package ejercicio21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ejercicio19.GestionDepartamentos;

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
	public static void main(String[] args) {
		GestionDepartamentos departamentos = new GestionDepartamentos("departamentos.dat");

		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementatio = builder.getDOMImplementation();
			departamentos.abrir();

			Document document = implementatio.createDocument(null, "Departamentos", null);
			document.setXmlVersion("1.0");
			Element elementoEmpleado = document.createElement("dep");
			document.getDocumentElement().appendChild(elementoEmpleado);
			while (departamentos.finFichero() != 0) {
				

				if (departamentos.leer() != null) { 

					int id = departamentos.funcion(0);

					elementoEmpleado.setAttribute("id", Integer.toString(id));

					String nombre = departamentos.leer(id).getNombre();
					Element elemNom = document.createElement("nombre");
					Text textoNom = document.createTextNode(nombre);
					elementoEmpleado.appendChild(elemNom);
					elemNom.appendChild(textoNom);

					String localidad = departamentos.leer(id).getLocalidad();
					Element elemLoc = document.createElement("localidad");
					Text textoLoc = document.createTextNode(localidad);
					elementoEmpleado.appendChild(elemLoc);
					elemNom.appendChild(textoLoc);

				} else
					departamentos.finFichero();
			}
			TransformerFactory xformFactory = TransformerFactory.newInstance();
			Transformer idTransform = xformFactory.newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(System.out);
			idTransform.transform(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
