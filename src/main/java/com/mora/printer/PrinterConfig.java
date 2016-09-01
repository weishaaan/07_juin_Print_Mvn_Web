package com.mora.printer;

import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBException;
import org.apache.xmlbeans.XmlException;

public class PrinterConfig {

    public Map<String, Printer> catalogue = PrinterDatabase.getMapPrinters();
    
    public PrinterConfig(String fullPath) throws XmlException, IOException, JAXBException {

        Printer_Marshall m = new Printer_Marshall();
        Printers printers = m.unmarshaller(fullPath);
        System.out.println("PrinterConfig get path is :"+fullPath);
        
        for (int i = 0; i < printers.getPrinters().size(); i++) {
            Printer printer = printers.getPrinters().get(i);
            catalogue.put(printer.getIp(), printer);
            
        }
    }
}
