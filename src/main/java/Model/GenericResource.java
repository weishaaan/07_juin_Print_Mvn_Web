package Model;

import LabelType.LabelType;
import LabelType.LabelTypeDatabase;
import LabelType.LabelTypeGet;
import Printer_Marshall.PrinterDatabase;
import Printer_Marshall.Printer;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("home")
public class GenericResource {
    
    PrinterStatus printStatus = new PrinterStatus();
    PrintJob printjob = new PrintJob();
    PrinterDatabase printerDatabase = new PrinterDatabase();
    LabelTypeDatabase labelTypeDatabase = new LabelTypeDatabase();
    
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
    @Path("getAllPrinter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Printer> getAllPrinter() throws IOException{
        return printerDatabase.getAllPrinters();
    }
    
    @GET
    @Path("getLabelTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LabelTypeGet> getAllLabel() throws IOException{
            
        List<LabelTypeGet> l = new ArrayList<LabelTypeGet>();
        for(int i = 0 ; i < labelTypeDatabase.getAllLabelTypes().size() ; i++){
            LabelTypeGet ltg = new LabelTypeGet();
            ltg.setReference(labelTypeDatabase.getAllLabelTypes().get(i).getReference());
            ltg.setS(labelTypeDatabase.getAllLabelTypes().get(i).toString());
            
            l.add(ltg);
        }
        
        return l;
    }
    //reference toString getReference()+" - "+ getLabelName();
    
    
    @POST
    @Path("postPrintMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postNameRunBat(PostPrintInfo postPrintInfo){  
        
        /*
        printjob.setOfNum(postPrintInfo.getOfNum());
        printjob.setIp(postPrintInfo.getIp());
        printjob.setNum(postPrintInfo.getNum());
        printjob.setType(postPrintInfo.getType());
        printjob.setExpress(postPrintInfo.getExpress());
        printjob.setDate(postPrintInfo.getDate());
        printjob.setBl(postPrintInfo.getBl());
        */
        
        System.out.println("Successfully $POST params to web service!");
        
        return  "result ";
          //printjob.getOfNum()+printjob.getBl()+printjob.getExpress()+printjob.getDate()+printjob.getIp()+printjob.getType(); 
    }
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
 

