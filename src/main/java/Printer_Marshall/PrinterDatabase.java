package Printer_Marshall;

import Model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlException;

public class PrinterDatabase {
    public static Map<String,Printer> catalogue = new HashMap<String,Printer>();

    public static Map<String,Printer> getMapPrinters(){
        return catalogue;
    }
    
    public List<Printer> getAllPrinters() {
        
        return new ArrayList<Printer>(catalogue.values());
        
    }

    public Printer getPrinterByIP(String ip) throws XmlException, IOException {
        
        Printer p = catalogue.get(ip);
        
        if(p!= null)
            return p;
        else 
            return null;
    }
    
}
