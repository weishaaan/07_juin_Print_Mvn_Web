package com.mora.model;

import com.mora.labeltype.Field;
import com.mora.labeltype.Fields;
import com.mora.labeltype.LabelFormat;
import com.mora.labeltype.LabelType;
import com.mora.labeltype.LabelTypeDatabase;
import com.mora.labeltype.LabelTypeGet;
import com.mora.printer.PrinterDatabase;
import com.mora.printer.Printer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;


@Path("/")
public class GenericResource {

    PrinterStatus printStatus = new PrinterStatus();
    PrintJob printjob = new PrintJob();
    PrinterDatabase printerDatabase = new PrinterDatabase();
    static final Logger logger = Logger.getLogger(GenericResource.class);
    DBConnection dbCon;
    Connection conn;
    ResultSet rslt;

    @GET
    @Path("getAllPrinter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Printer> getAllPrinter() throws IOException {
        
        logger.info("get printer list ! ");
        
        return printerDatabase.getAllPrinters();
    }

    @GET
    @Path("getLabelTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LabelTypeGet> getAllLabel() throws IOException {
        
        logger.info("get label types ! ");
        
        LabelTypeDatabase labelTypeDatabase = new LabelTypeDatabase();
        List<LabelTypeGet> l = new ArrayList<>();
        for (int i = 0; i < labelTypeDatabase.getAllLabelTypes().size(); i++) {
            LabelTypeGet ltg = new LabelTypeGet();
            ltg.setReference(labelTypeDatabase.getAllLabelTypes().get(i).getReference());
            ltg.setLabelName(labelTypeDatabase.getAllLabelTypes().get(i).toString());
            ltg.setListField(labelTypeDatabase.getAllLabelTypes().get(i).getFields().getFields());
            l.add(ltg);
        }
        return l;
    }

    
    
    
    @GET
    @Path("postPrintMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String labelPrint(@QueryParam("ofNum") String ofNum,
                             @QueryParam("type") String type,
                             @QueryParam("userInputs") List<String> userInputs,
                             @QueryParam("ip") String ip,
                             @QueryParam("nbr_label") int nbr_label,
                             @QueryParam("nbr_art") int nbr_art,
                             @QueryParam("nbr_label_h") int nbr_label_h,
                             @QueryParam("nbr_label_p") int nbr_label_p){

        logger.info("post print message ! ");
         
        List<UserInput> ui_list = new ArrayList<>();
        for(int m = 0; m < userInputs.size()/2; m++ ){
            UserInput ui = new UserInput();
            ui.setCode(userInputs.get(m));
            ui.setValue(userInputs.get(m+1));
            ui_list.add(ui);
            m = m + 1;
        }
        
        //ofNum 
        Of of = new Of();
        of.setOfNum(ofNum);

        //Printer ip
        Printer printer = new Printer();
        try {
            printer = printerDatabase.getPrinterByIP(ip);
        } catch (XmlException | IOException ex) {
            logger.error("This is error : can't get printer list");
        }

        //Label type
        Label label = new Label();
        Map<String, LabelType> original = LabelTypeDatabase.getMapLabelTypes(); //return catalogue
        Map<String, LabelType> hashmapB = new HashMap<>();
        for (Entry<String, LabelType> entry : original.entrySet()) {
            String gnr = entry.getValue().getGeneric();
            String rf = entry.getValue().getReference();
            String ln = entry.getValue().getLabelName();
            String des = entry.getValue().getDescription();
            LabelFormat lf = new LabelFormat(entry.getValue().getFormat().getName(), entry.getValue().getFormat().getLength(), entry.getValue().getFormat().getWidth());
            Fields fs = new Fields();
            List<Field> fields = new ArrayList<>();
            for (int i = 0; i < entry.getValue().getFields().getFields().size(); i++) {
                String cd = entry.getValue().getFields().getFields().get(i).getCode();
                String desc = entry.getValue().getFields().getFields().get(i).getDescription();
                String tp = entry.getValue().getFields().getFields().get(i).getType();
                Float x = entry.getValue().getFields().getFields().get(i).getX();
                Float y = entry.getValue().getFields().getFields().get(i).getY();
                String val = entry.getValue().getFields().getFields().get(i).getValue();
                String cal = entry.getValue().getFields().getFields().get(i).getCalculated();
                String sr = entry.getValue().getFields().getFields().get(i).getSource();
                Field fd = new Field(cd, des, tp, x, y, val, cal, sr);
                fields.add(fd);
            }
            fs.setFields(fields);
            hashmapB.put(entry.getKey(), new LabelType(gnr, rf, ln, des, lf, fs));
        }
        LabelType labelType = new LabelType();
        labelType = hashmapB.get(type);

        for (int i = 0; i < labelType.getFields().getFields().size(); i++) {
            for (int j = 0; j < ui_list.size(); j++) {
                if (labelType.getFields().getFields().get(i).getCode().equals(ui_list.get(j).getCode())) {
                    labelType.getFields().getFields().get(i).setSource(ui_list.get(j).getValue());
                    break;
                }
            }
        }
        
        label.setOfNum(ofNum);
        label.setLabelNumber(nbr_label);
        label.setNbrArt(nbr_art);
        label.setLabelType(labelType);
        
        // set printjob
        printjob.setPrinter(printer);
        printjob.setLabel(label);
        printjob.setNbrEtiqHousse(nbr_label_h);
        printjob.setNbreEtiqPrelev(nbr_label_p);
        
        
        //printer information:
        String printer_name, printer_ip;
        printer_name = printjob.getPrinter().getName();
        printer_ip = printjob.getPrinter().getIp();

        //label type information:
        String label_ref;
        int label_num;
        String label_code, label_source;
        Map<String, String> map_post_label_info = new HashMap<>();
        String label_log = "";
        label_ref = printjob.getLabel().getLabelType().getReference();
        label_num = printjob.getLabel().getLabelNumber();

        /* for test
        System.out.println("******************* ofNum is:" + of.getOfNum() + " *******************");
        System.out.println("******************* ip is: " + printer_ip + " *******************");
        System.out.println("******************* label number is: " + label_num + " *******************");
        System.out.println("******************* label reference is :" + label_ref + "*******************");
        */
        
        for (int m = 0; m < printjob.getLabel().getLabelType().getFields().getFields().size(); m++) {
            label_code = printjob.getLabel().getLabelType().getFields().getFields().get(m).getCode();
            label_source = printjob.getLabel().getLabelType().getFields().getFields().get(m).getSource();
            map_post_label_info.put(label_code, label_source);
            System.out.println("label code is :" + label_code);
            System.out.println("label source is :" + label_source);
            label_log = label_log + "label code is : " + label_code + ",label source is :" + label_source + ";";
            if (m == (printjob.getLabel().getLabelType().getFields().getFields().size() - 1)) {
                label_log = label_log.substring(0, label_log.length() - 1);
            }
        }
        
        logger.info("The printer name is : " + printer_name + ", printer ip is : " + printer_ip);
        logger.info("The type of ticket(reference) is : " + label_ref + ", those values changed by users are : [ " + label_log + "]");

        System.out.println("###################################### Original data is ######################################");
        for (int m = 0; m < original.get(type).getFields().getFields().size(); m++) {
            System.out.println("the code is :" + original.get(type).getFields().getFields().get(m).getCode());
            System.out.println("the source is :" + original.get(type).getFields().getFields().get(m).getSource());
        }
        System.out.println("############################################################################");

        //String filepath = FilePathDatabase.getFilePath() + label_ref +".txt";
        String labelmodels = "labelmodels";
        String filepath;
        Map<String, String> filepath_catalogue = FilePathDatabase.getFilePathCatalogue();
        filepath = filepath_catalogue.get(labelmodels) + label_ref + ".txt";
        System.out.println("filepath is " + filepath);

        BufferedReader br = null;
        String s = "";
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filepath));
            System.out.println("######################################FILE CONTENT####################################################################");
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                s = s + sCurrentLine + "\n";
            }
            System.out.println("#########################################################################################################");

            System.out.println("#################################### AFTER CHANGE NUMOF AND INNDICECLIENT ##################################################");
            for (Map.Entry<String, String> entry : map_post_label_info.entrySet()) {
                s = s.replace("$" + entry.getKey().toUpperCase() + "$", entry.getValue());
            }
            System.out.println(s);
            System.out.println("#########################################################################################################");

        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                logger.error(ex);
                ex.printStackTrace();
            }
        }

        Map<String, String> retourData = RetourDatabase.getRetourDatabase();
        String data;
        data = "num OF est : " + printjob.getLabel().getOfNum() + "</p>"
                + "Ip adresse d'imprimante est : " + printjob.getPrinter().getIp() + "</p>"
                + "Nombre d'étiquette est : " + printjob.getLabel().getLabelNumber() + "</p>"
                + "Type d'étiquette(reference) est : " + printjob.getLabel().getLabelType().getReference() + "</p>";
        retourData.put("retourdata", data);

        return "success $post data to web service!";
    }

    @GET
    @Path("getRetourData")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRetourData() {
        
        logger.info("get retour data ! ");
        return RetourDatabase.getRetourDatabase().get("retourdata");
    }
    
    @GET
    @Path("labelof2/{numOf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Of getOF(@PathParam("ofNum") long ofNum) throws SQLException{
        
        logger.info("get of list ! ");
        Of of = new Of();
        
        String uri = null;//"http://localhost:8080/OF_MVN/webresources/home/testJNDI";
        Map<String, String> filepath_catalogue = FilePathDatabase.getFilePathCatalogue();
        uri = filepath_catalogue.get("of_database");
        System.out.println("uri is :" + uri);
          
        try {
            Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
            WebTarget webTarget = client.target(uri + "/" + ofNum);

            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get(Response.class);
            of = response.readEntity(new GenericType<Of>(){});      
             
            System.out.println("ofNum is :" + of.getOfNum());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return of;
    }
    
    @GET
    @Path("labelof/{numOf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Of getOF2(@PathParam("numOf") String numOf)throws SQLException{
    
        
        List<Of> list = new ArrayList<>();
        Of oo = new Of();

        Date date = new Date();
        
        Of of1 = new Of("1","1ref","1sref","1art",1,10,"indice1","refeCli1","eiterExterne1","sq",true,date);
        Of of2 = new Of("2","2ref","2sref","2art",2,28,"indice2","refeCli2","eiterExterne2","sq",true,date);
        Of of3 = new Of("3","3ref","3sref","3art",3,32,"indice3","refeCli3","eiterExterne3","sq",true,date);
        Of of4 = new Of("4","4ref","4sref","4art",4,42,"indice4","refeCli4","eiterExterne4","sq",true,date);
        
        list.add(of1);
        list.add(of2);
        list.add(of3);
        list.add(of4);
        
        for(int i = 0; i <list.size() ; i++){
            if((list.get(i).getOfNum()).equals(numOf) ){
                oo = list.get(i);
                break;
            }
        }
                
        return oo;
    }
}
