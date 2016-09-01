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


@Path("home")
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
        return printerDatabase.getAllPrinters();
    }

    @GET
    @Path("getLabelTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LabelTypeGet> getAllLabel() throws IOException {
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
    public String labelPrint(@QueryParam("ofNum") long ofNum,
                          @QueryParam("ip") String ip,
                          @QueryParam("num") int num,
                          @QueryParam("type") String type,
                          @QueryParam("userInputs") List<String> userInputs) {

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

        //Printer
        Printer printer = new Printer();
        try {
            printer = printerDatabase.getPrinterByIP(ip);
        } catch (XmlException | IOException ex) {
            logger.error("This is error : can't get printer list");
        }

        //Label
        
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

        label.setLabelNumber(num);
        label.setLabelType(labelType);

        printjob.setPrinter(printer);
        printjob.setLabel(label);

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

        System.out.println("******************* ofNum is:" + of.getOfNum() + " *******************");
        System.out.println("******************* ip is: " + printer_ip + " *******************");
        System.out.println("******************* label number is: " + label_num + " *******************");
        System.out.println("******************* label reference is :" + label_ref + "*******************");

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
        //Les logs doivent tracer la date et l'heure + le type d'étiquette 
        //+ toutes les valeurs modifiées par l'utilisateur + l'imprimante utilisée.

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
        data = "num OF est : " + of.getOfNum() + "</p>"
                + "Ip adresse d'imprimante est : " + printer_ip + "</p>"
                + "Nombre d'étiquette est : " + label_num + "</p>"
                + "Type d'étiquette(reference) est : " + label_ref + "</p>";
        retourData.put("retourdata", data);

        return "success $post data to web service!";
    }

    @GET
    @Path("getRetourData")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRetourData() {
        return RetourDatabase.getRetourDatabase().get("retourdata");
    }
    
    @GET
    @Path("getOfList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Of> getOF(@QueryParam("ref") long ref,
                          @QueryParam("sref") String sref,
                          @QueryParam("date_start") String date_start,
                          @QueryParam("date_end") String date_end) throws SQLException{
        
        //System.out.println("date_start: " + date_start);//08/03/2016
        String date1 = null;
        String date2 = null;
        String path_mysql = "?REFERENCE=" + ref ;
        List<Of> return_list = new ArrayList<>();
        String uri = null;//"http://localhost:8080/OF_MVN/webresources/home/testJNDI";
        Map<String, String> filepath_catalogue = FilePathDatabase.getFilePathCatalogue();
        uri = filepath_catalogue.get("of_database");
        System.out.println("uri is :" + uri);

        if(sref !=null && !sref.equals("")){
            path_mysql = path_mysql + "&SREFERENCE1=" + sref;
        }
        
        if(date_start!=null && !date_start.equals("") && date_end!=null && !date_end.equals("")){
            date1 = "\"" + date_start.substring(6, 10)+'-'+date_start.substring(0,2)+'-'+date_start.substring(3,5)+" 00:00:00 "+"\"";
            date2 = "\"" + date_end.substring(6, 10)+'-'+date_end.substring(0,2)+'-'+date_end.substring(3,5)+" 00:00:00 "+"\"";
            path_mysql = path_mysql+ "&date_start=" + date1 +"&date_end=" + date2;
        }
                        
        try {
            Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
            WebTarget webTarget = client.target(uri+path_mysql);

            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get(Response.class);
            return_list = response.readEntity(new GenericType<List<Of>>(){});      
             
            System.out.println("list size is :" + return_list.size());
            
            StringBuilder builder = new StringBuilder("=== Ofs ===\n");
            for (Of of: return_list) {
                builder.append("OfNum: ").append(of.getOfNum()).append(", ")
                        .append("reference: ").append(of.getReference()).append("\n");          
            }
            builder.append("==================");
            System.out.println(builder.toString());   
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return return_list;
    }
    
    @GET
    @Path("getOfList2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Of getOF2(@QueryParam("ofNum") long ofNum)throws SQLException{
    
        List<Of> list = new ArrayList<>();
        Of oo = new Of();
        Date date1 = new Date();
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        try {
            date1 = dateformat3.parse("15/10/2007 12:22:11");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Of of1 = new Of(1,"1ref","1sref","1art",1,1,date1);
        Of of2 = new Of(2,"2ref","2sref","2art",2,2,date1);
        Of of3 = new Of(3,"3ref","3sref","3art",3,3,date1);
        Of of4 = new Of(4,"4ref","4sref","4art",4,4,date1);
        
        list.add(of1);
        list.add(of2);
        list.add(of3);
        list.add(of4);
        
        for(int i = 0; i <list.size() ; i++){
            if(list.get(i).getOfNum()==ofNum){
                oo = list.get(i);
                break;
            }
        }
        return oo;
    }
}
