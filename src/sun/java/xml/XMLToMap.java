package sun.java.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLToMap {
	
	public static Map<String,Object> toMap(Document doc){
		NodeList nodeList = doc.getChildNodes();
		
		
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		
		FileReader reader = new FileReader("d:/marketoCreateLead.xml");

	}

}
