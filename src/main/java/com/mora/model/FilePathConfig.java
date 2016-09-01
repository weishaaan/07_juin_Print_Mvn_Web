package com.mora.model;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FilePathConfig {
    
    public Map<String, String> filepath_catalogue = FilePathDatabase.getFilePathCatalogue();
    
    
    public FilePathConfig(String fullPath_label_model)throws XmlException, IOException, JAXBException {
        
        System.out.println("############################# FilePathCongif #############################");
        File fXmlFile = new File(fullPath_label_model);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NodeList nList = doc.getElementsByTagName("path");
            
        for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                        String name,absolutepath;
                        name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        absolutepath = eElement.getElementsByTagName("absolutepath").item(0).getTextContent();
                        filepath_catalogue.put(name, absolutepath);
			System.out.println("name : " + name);
			System.out.println("absolutepath : " + absolutepath);
			System.out.println("-----------------------------------");
                        
		}
	}
        
    }
    
    
}
