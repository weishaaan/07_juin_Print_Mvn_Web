package Controller;

import LabelType.LabelTypeConfig;
import Model.TXTFilePathConfig;
import Printer_Marshall.PrinterConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.xml.bind.JAXBException;
import javax.servlet.ServletContextEvent;
import org.apache.xmlbeans.XmlException;
 
public class Servlet implements ServletContextListener {
    
    String fullPath_printer,fullPath_labelType,fullPath_TB01;
    
    @Override
    public void contextInitialized(ServletContextEvent contextEvent){
        System.out.println("---------------servlet for loading printer info-----------------------");
        
        ServletContext context = contextEvent.getServletContext();
        fullPath_printer = context.getRealPath("/WEB-INF/printer_catalog.xml");
        fullPath_labelType = context.getRealPath("/WEB-INF/label_type_catalog.xml");
        fullPath_TB01 = context.getRealPath("/WEB-INF/file_path.xml");
        System.out.println("MyServlet full path is :"+fullPath_printer);
        System.out.println("***********TB01 PATH is**************"+fullPath_TB01);
        
        try {
            PrinterConfig printerConfig = new PrinterConfig(fullPath_printer);
        } catch (XmlException | IOException | JAXBException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            LabelTypeConfig labelTypeConfig = new LabelTypeConfig(fullPath_labelType);
        } catch (XmlException | IOException | JAXBException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TXTFilePathConfig txtFilePath = new TXTFilePathConfig(fullPath_TB01);
    
    }
    
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0){
        System.out.print("servlet context destroyed.");
    }
    
    
}