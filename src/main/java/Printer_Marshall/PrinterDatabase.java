package Printer_Marshall;

import Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrinterDatabase {
    public static Map<String,Printer> catalogue = new HashMap<String,Printer>();

    public static Map<String,Printer> getMapPrinters(){
        return catalogue;
    }
    
    public List<Printer> getAllPrinters() {
        
        return new ArrayList<Printer>(catalogue.values());
        
    }
/*
    public Printer getPrinter(String code) throws XmlException, IOException {
        
        Printer b = catalogue.get(code);
        
        if(b!= null)
            return b;
        else 
            return null;
    }
    */
}
