package Model;

import Controller.Servlet;
import LabelType.Field;
import LabelType.Fields;
import LabelType.LabelFormat;
import LabelType.LabelType;
import LabelType.LabelTypeDatabase;
import LabelType.LabelTypeGet;
import Printer_Marshall.PrinterDatabase;
import Printer_Marshall.Printer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Path("home")
public class GenericResource {
    
    PrinterStatus printStatus = new PrinterStatus();
    PrintJob printjob = new PrintJob();
    PrinterDatabase printerDatabase = new PrinterDatabase();
    
    
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
        ofclass1.setOfNum(1);
        ofclass1.setReference(1);
        ofclass1.setSreference("a1");
        ofclass1.setArtDesignation("ArtDesignation");
        ofclass1.setNbArtPerContainer("NbArtPerContainer");
        
        list.add(ofclass1);
        
        Of ofclass2 = new Of();
        ofclass2.setOfNum(2);
        ofclass2.setReference(2);
        ofclass2.setSreference("a2");
        ofclass2.setArtDesignation("ArtDesignation");
        ofclass2.setNbArtPerContainer("NbArtPerContainer");
        
        list.add(ofclass2);
        
        Of ofclass3 = new Of();
        ofclass3.setOfNum(3);
        ofclass3.setReference(3);
        ofclass3.setSreference("a3");
        ofclass3.setArtDesignation("ArtDesignation");
        ofclass3.setNbArtPerContainer("NbArtPerContainer");
        list.add(ofclass3);
        
        Of ofclass4 = new Of();
        ofclass4.setOfNum(4);
        ofclass4.setReference(4);
        ofclass4.setSreference("a4");
        ofclass4.setArtDesignation("ArtDesignation");
        ofclass4.setNbArtPerContainer("NbArtPerContainer");
        list.add(ofclass4);
        
        return list;
    }
    
    
    @GET
    @Path("getAllPrinter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Printer> getAllPrinter() throws IOException{
        return printerDatabase.getAllPrinters();
    }
    /*
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
    */
    
    @GET
    @Path("getLabelTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LabelTypeGet> getAllLabel() throws IOException{
        LabelTypeDatabase labelTypeDatabase = new LabelTypeDatabase();
        List<LabelTypeGet> l = new ArrayList<LabelTypeGet>();
        for(int i = 0 ; i < labelTypeDatabase.getAllLabelTypes().size() ; i++){
            LabelTypeGet ltg = new LabelTypeGet();
            ltg.setReference(labelTypeDatabase.getAllLabelTypes().get(i).getReference());
            ltg.setLabelName(labelTypeDatabase.getAllLabelTypes().get(i).toString());
            ltg.setListField(labelTypeDatabase.getAllLabelTypes().get(i).getFields().getFields());
            l.add(ltg);
        }
        
        
        return l;
    }
    
    @POST
    @Path("postPrintMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String labelPrint(PostPrintInfo postPrintInfo){  
        LabelTypeDatabase labelTypeDatabase = new LabelTypeDatabase();
        //{"ofNum":"2","ip":"192.168.1.1","num":"3","type":"GALIASTD",
        //"userInputs":[{"code":"Z1","value":"z1"}]}
        
        //ofNum
        Of of = new Of();
        of.setOfNum(postPrintInfo.getOfNum());
        
        //Printer
        Printer printer = new Printer();
        try {
            printer = printerDatabase.getPrinterByIP(postPrintInfo.getIp());
        } catch (XmlException | IOException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Label
        Label label = new Label();
        Map<String,LabelType> original = labelTypeDatabase.getMapLabelTypes(); //return catalogue
        Map<String,LabelType> hashmapB = new HashMap<String,LabelType>();
        for (Entry<String,LabelType> entry : original.entrySet()) {
            String gnr = entry.getValue().getGeneric();
            String rf = entry.getValue().getReference();
            String ln = entry.getValue().getLabelName();
            String des = entry.getValue().getDescription();
            LabelFormat lf = new LabelFormat(entry.getValue().getFormat().getName(),entry.getValue().getFormat().getLength()
                            ,entry.getValue().getFormat().getWidth());
            Fields fs = new Fields();
            List<Field> fields = new ArrayList<Field>();
            for (int i = 0; i < entry.getValue().getFields().getFields().size(); i++) {
                String cd = entry.getValue().getFields().getFields().get(i).getCode();
                String desc = entry.getValue().getFields().getFields().get(i).getDescription();
                String tp = entry.getValue().getFields().getFields().get(i).getType();
                Float x = entry.getValue().getFields().getFields().get(i).getX();
                Float y = entry.getValue().getFields().getFields().get(i).getY();
                String val = entry.getValue().getFields().getFields().get(i).getValue();
                String cal = entry.getValue().getFields().getFields().get(i).getCalculated();
                String sr = entry.getValue().getFields().getFields().get(i).getSource();
                Field fd = new Field(cd,des,tp,x,y,val,cal,sr);
                fields.add(fd);
            }
            fs.setFields(fields);
            hashmapB.put(entry.getKey(), new LabelType(gnr,rf,ln,des,lf,fs));
        }
        LabelType labelType = new LabelType();
        labelType = hashmapB.get(postPrintInfo.getType());
        
        for(int i = 0; i<labelType.getFields().getFields().size(); i++){
            for(int j = 0; j < postPrintInfo.getUserInputs().size(); j++){
                if(labelType.getFields().getFields().get(i).getCode().equals(postPrintInfo.getUserInputs().get(j).getCode())){
                    labelType.getFields().getFields().get(i).setSource(postPrintInfo.getUserInputs().get(j).getValue());
                    break;
                }
            }
        }
        
        label.setLabelNumber(postPrintInfo.getNum());
        label.setLabelType(labelType);
        
        printjob.setPrinter(printer);
        printjob.setLabel(label);
        
        System.out.println("******************* ofNum is:" + of.getOfNum() + " *******************");
        System.out.println("******************* ip is: " + printjob.getPrinter().getIp() + " *******************");
        System.out.println("******************* label number is: " + printjob.getLabel().getLabelNumber() + " *******************");
        System.out.println("******************* label reference is :" + printjob.getLabel().getLabelType().getReference() + "*******************");
        
        Boolean b = false;
        String numOf = null;
        String indiceClient = null;
        String numOf_old = "$NUMOF$";
        String indiceClient_old = "$INDICECLIENT$";
        
        for (int m = 0; m < printjob.getLabel().getLabelType().getFields().getFields().size(); m++) {
            if(printjob.getLabel().getLabelType().getFields().getFields().get(m).getCode().equals("NUMOF")){
                b = true;
                numOf = printjob.getLabel().getLabelType().getFields().getFields().get(m).getSource();
                System.out.println("~~~~ numOf is "+ numOf);
            }
             if(printjob.getLabel().getLabelType().getFields().getFields().get(m).getCode().equals("INDICECLIENT")){
                b = true;
                indiceClient = printjob.getLabel().getLabelType().getFields().getFields().get(m).getSource();
                System.out.println("~~~~ indiceClient is "+ indiceClient);
             }
            System.out.println("the code is :" + printjob.getLabel().getLabelType().getFields().getFields().get(m).getCode());
            System.out.println("the source is :" + printjob.getLabel().getLabelType().getFields().getFields().get(m).getSource());
        }
        System.out.println("###################################### Original data is ######################################");
        for (int m = 0; m < original.get(postPrintInfo.getType()).getFields().getFields().size(); m++) {
            System.out.println("the code is :" + original.get(postPrintInfo.getType()).getFields().getFields().get(m).getCode());
            System.out.println("the source is :" + original.get(postPrintInfo.getType()).getFields().getFields().get(m).getSource());
        }
        System.out.println("############################################################################");
        
        String filepath = FilePathDatabase.getFilePath();
        System.out.println("filepath is " + filepath );
        
        BufferedReader br = null;
        String s="";
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filepath)); //"/Users/LizSHAN/MORA/TB01.txt"
            System.out.println("######################################FILE CONTENT####################################################################");
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                if(b){
                    s = s + sCurrentLine.replace(numOf_old, numOf).replace(indiceClient_old, indiceClient)+"\n";   
                }
            }
            System.out.println("#########################################################################################################");
            
            if(b){
                System.out.println("we have $NUMOF$ and $INDICECLIENT$ input .");
                System.out.println("#################################### AFTER CHANGE NUMOF AND INNDICECLIENT ##################################################");
                System.out.println(s);
                System.out.println("#########################################################################################################");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return  "result!";
    
    }
    
}
    
    
 

