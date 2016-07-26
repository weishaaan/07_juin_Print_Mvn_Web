package Printer_Marshall;

import Model.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Printer_Marshall {
    
    public Printers unmarshaller(String fullPath) throws JAXBException {
       
        System.out.println("Marshall get path is :"+fullPath);
        
        //xmlPath = "src/main/webapp/WEB-INF/printer_catalog.xml";
        JAXBContext jc = JAXBContext.newInstance(Printers.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Printers printers = (Printers) unmarshaller.unmarshal(new File(fullPath));
        
        for (int i = 0; i < printers.getPrinters().size(); i++) {
            Printer printer = printers.getPrinters().get(i);
            System.out.println("--------------------Printer INFO---------------------");
            System.out.println(
            "DPI is : "+ printer.getDpi() + ", IP is : " + printer.getIp()
            + ", name is : " + printer.getName() + ", status is : "+ 
            printer.getStatus() +", type is :" + printer.getType());
                    
        }
        return printers;
    }
}
