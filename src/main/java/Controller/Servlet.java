package Controller;

import LabelType.LabelTypeConfig;
import Model.FilePathConfig;
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
    
    String fullPath_printer,fullPath_labelType,fullPath_files_path;
    
    @Override
    public void contextInitialized(ServletContextEvent contextEvent){
        System.out.println("---------------servlet for loading printer info-----------------------");
        
        ServletContext context = contextEvent.getServletContext();
        fullPath_printer = context.getRealPath("/WEB-INF/printer_catalog.xml");
        fullPath_labelType = context.getRealPath("/WEB-INF/label_type_catalog.xml");
        fullPath_files_path = context.getRealPath("/WEB-INF/files_path.xml");
        
        System.out.println("MyServlet full path is :"+fullPath_printer);
        System.out.println("***********label model PATH is**************"+fullPath_files_path);
        
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
        
        try {
            FilePathConfig txtFilePath = new FilePathConfig(fullPath_files_path);
        } catch (XmlException | IOException | JAXBException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0){
        System.out.print("servlet context destroyed.");
    }
    
    
}