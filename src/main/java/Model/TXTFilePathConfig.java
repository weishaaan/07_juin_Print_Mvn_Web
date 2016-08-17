package Model;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TXTFilePathConfig {
    String s;
    
    public TXTFilePathConfig(String fullPath_TB01) {
        System.out.println("~~~~~~~~~~TXTFilePath~~~~~~~~~~~~~~~");
        File fXmlFile = new File(fullPath_TB01);
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
        s = doc.getElementsByTagName("path").item(0).getTextContent();
        FilePathDatabase.setFilePath(s);
        System.out.println("s is :" + s);
        System.out.println("~~~~~~~~~~TXTFilePath~~~~~~~~~~~~~~~");
        
        System.out.println("FilePathDatabase.getFilePath() is ~~~" + FilePathDatabase.getFilePath());
    }
    
    
}
