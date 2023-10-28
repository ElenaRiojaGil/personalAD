package xml.ejemplos;

import java.io.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class libros {

	public static void main(String[] args) {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document document = builder.parse(new File("src\\xml\\libros.xml"));
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz :" + document.getDocumentElement().getNodeName());

			// crear una lista de los libros
			NodeList libros = document.getElementsByTagName("libro");
			System.out.println("Cantidad de libros " + libros.getLength());

			for (int i = 0; i < libros.getLength(); i++) {
				Node libro = libros.item(i);
				if (libro.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) libro;
					Node nodo1 = (Node) elemento.getElementsByTagName("titulo").item(0).getChildNodes().item(0);
					System.out.println("\ntitulo: " + nodo1.getNodeValue());
					for (int j = 0; j < elemento.getElementsByTagName("autor").getLength(); j++) {
						
							nodo1 = (Node) elemento.getElementsByTagName("autor").item(j).getChildNodes().item(0);
							System.out.println("autor: " + nodo1.getNodeValue());
						}

					}
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
