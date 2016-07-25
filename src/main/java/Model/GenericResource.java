package Model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.management.monitor.Monitor;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;

@Path("home")
public class GenericResource {
    
    PrinterStatus printStatus = new PrinterStatus();
    PrintJob printjob = new PrintJob();
    
    public GenericResource() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN) //MediaType.APPLICATION_XML
    public String Test(){
        return "5:31 pm";
    }
    
    @GET
    @Path("printerStatus")
    @Produces(MediaType.TEXT_PLAIN) //MediaType.APPLICATION_XML
    public String PrinterStatus(){
        printStatus.PrinterStatus();
        return "printerStatus";
    }
   
    @GET
    @Path("getOfList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Of> getOfList() {
        
        ArrayList<Of> list = new ArrayList<Of>();

        Of ofclass1 = new Of();
        ofclass1.setOfNum(1L);
        ofclass1.setReference(1L);
        ofclass1.setSreference("a1");
        list.add(ofclass1);
        
        Of ofclass2 = new Of();
        ofclass2.setOfNum(2L);
        ofclass2.setReference(2L);
        ofclass2.setSreference("a2");
        list.add(ofclass2);
        
        Of ofclass3 = new Of();
        ofclass3.setOfNum(3L);
        ofclass3.setReference(3L);
        ofclass3.setSreference("a3");
        list.add(ofclass3);
        
        Of ofclass4 = new Of();
        ofclass4.setOfNum(4L);
        ofclass4.setReference(4L);
        ofclass4.setSreference("a4");
        list.add(ofclass4);
        
        return list;
    }
    
    @GET
    @Path("getPrinterList")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PrinterDatabase> getPrinterList() {
        
        ArrayList<PrinterDatabase> list = new ArrayList<PrinterDatabase>();
        
        PrinterDatabase p1 = new PrinterDatabase();
        p1.setPrinterName("printer1");
        list.add(p1);
        PrinterDatabase p2 = new PrinterDatabase();
        p2.setPrinterName("printer2");
        list.add(p2);
        PrinterDatabase p3 = new PrinterDatabase();
        p3.setPrinterName("printer3");
        list.add(p3);
        PrinterDatabase p4 = new PrinterDatabase();
        p4.setPrinterName("printer4");
        list.add(p4);
        
        return list;
    }
    
    @POST
    @Path("postPrintMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postNameRunBat(PostPrintInfo postPrintInfo){  
        
        printjob.setOfNum(postPrintInfo.getOfNum());
        printjob.setPrinterName(postPrintInfo.getPrinterName());
        printjob.setNum(postPrintInfo.getNum());
        printjob.setType(postPrintInfo.getType());
        printjob.setExpress(postPrintInfo.getExpress());
        printjob.setPrefix(postPrintInfo.getPrefix());
        printjob.setBl(postPrintInfo.getBl());
        
        System.out.println("Successfully $POST params to web service!");
        
        return  "result:"+printjob.getBl()+printjob.getExpress()+printjob.getPrefix()+printjob.getPrinterName()+printjob.getType(); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
 

