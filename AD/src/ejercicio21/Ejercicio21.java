package ejercicio21;

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

import ejercicio18.Departamento;
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
			departamentos.iniciar();
			while (!departamentos.finFichero()) {

				Departamento d = new Departamento();
				d = departamentos.leer();
				//System.out.println(d);
				if (d != null) {
					
					if (d.getNumero()>0) {

						System.out.println(d);

						elementoEmpleado.setAttribute("id", Integer.toString(d.getNumero()));

						String nombre = d.getNombre();
						Element elemNom = document.createElement("nombre");
						Text textoNom = document.createTextNode(nombre);
						elementoEmpleado.appendChild(elemNom);
						elemNom.appendChild(textoNom);

						String localidad = d.getLocalidad();
						Element elemLoc = document.createElement("localidad");
						Text textoLoc = document.createTextNode(localidad);
						elementoEmpleado.appendChild(elemLoc);
						elemNom.appendChild(textoLoc);
					}

				}

			}
			TransformerFactory xformFactory = TransformerFactory.newInstance();
			Transformer idTransform = xformFactory.newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(System.out);
			//idTransform.transform(input, output);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
