package xml.ejemplos;

import java.io.*;

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

public class Escribir {

	public static void main(String[] args) throws FileNotFoundException {

		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementatio = builder.getDOMImplementation();
			Document document = implementatio.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");

			int edad = 21;
			for (int i = 0; i < 10; i++) {
				Element elementoEmpleado = document.createElement("empleado");
				document.getDocumentElement().appendChild(elementoEmpleado);

				elementoEmpleado.setAttribute("id", Integer.toString(i));

				Element elem = document.createElement("nombre");
				Text text = document.createTextNode("Juliana" + i);
				elementoEmpleado.appendChild(elem);
				elem.appendChild(text);
				//elementoEmpleado.setAttribute("id", Integer.toString(i));


				elem = document.createElement("edad");
				text = document.createTextNode(Integer.toString(edad));
				elementoEmpleado.appendChild(elem);
				elem.appendChild(text);

				edad++;
			}

			TransformerFactory xformFactory = TransformerFactory.newInstance();
			Transformer idTransform = xformFactory.newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(new File("src\\xml\\resultado.xml"));
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
}
