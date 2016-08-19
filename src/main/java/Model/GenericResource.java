package Model;

import LabelType.Field;
import LabelType.Fields;
import LabelType.LabelFormat;
import LabelType.LabelType;
import LabelType.LabelTypeDatabase;
import LabelType.LabelTypeGet;
import Printer_Marshall.PrinterDatabase;
import Printer_Marshall.Printer;
import java.io.BufferedReader;
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
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

@Path("home")
public class GenericResource {

    PrinterStatus printStatus = new PrinterStatus();
    PrintJob printjob = new PrintJob();
    PrinterDatabase printerDatabase = new PrinterDatabase();
    static final Logger logger = Logger.getLogger(GenericResource.class);

    public GenericResource() {
    }

    @GET
    @Path("printerStatus")
    @Produces(MediaType.TEXT_PLAIN) //MediaType.APPLICATION_XML
    public String PrinterStatus() {
        printStatus.PrinterStatus();
        return "printerStatus";
    }

    @POST
    @Path("postOF")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Of> getOF(OfPost oneOF) {
        List<Of> list = new ArrayList<Of>();
        
        
        
        
        
        return list;
    }

    @GET
    @Path("getOfList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Of> getOfList() {
        List<Of> list = new ArrayList<Of>();
        Of ofclass1 = new Of();
        ofclass1.setOfNum(980319);
        ofclass1.setReference(11226200);
        ofclass1.setSreference("0");
        ofclass1.setArtDesignation("LLA3");
        ofclass1.setNbArtPerContainer("20000");

        list.add(ofclass1);

        Of ofclass2 = new Of();
        ofclass2.setOfNum(980321);
        ofclass2.setReference(11226200);
        ofclass2.setSreference("0");
        ofclass2.setArtDesignation("LLA3");
        ofclass2.setNbArtPerContainer("20000");

        list.add(ofclass2);

        Of ofclass3 = new Of();
        ofclass3.setOfNum(980322);
        ofclass3.setReference(11178303);
        ofclass3.setSreference("12 M");
        ofclass3.setArtDesignation("BAGUE ANTI BRUIT 9435530 M GRI");
        ofclass3.setNbArtPerContainer("5000");
        list.add(ofclass3);

        Of ofclass4 = new Of();
        ofclass4.setOfNum(980323);
        ofclass4.setReference(11216400);
        ofclass4.setSreference("A");
        ofclass4.setArtDesignation("ARMATURE EXT 3279-02 723842");
        ofclass4.setNbArtPerContainer("400");
        list.add(ofclass4);

        Of ofclass5 = new Of();
        ofclass5.setOfNum(980324);
        ofclass5.setReference(11219000);
        ofclass5.setSreference("M");
        ofclass5.setArtDesignation("CAPSULE DE ROULEMENT");
        ofclass5.setNbArtPerContainer("600");
        list.add(ofclass5);

        Of ofclass6 = new Of();
        ofclass6.setOfNum(980325);
        ofclass6.setReference(11220800);
        ofclass6.setSreference("F");
        ofclass6.setArtDesignation("CONNECTEUR TG 8-12 BORNE A GAU");
        ofclass6.setNbArtPerContainer("30");
        list.add(ofclass6);

        Of ofclass7 = new Of();
        ofclass7.setOfNum(980323);
        ofclass7.setReference(11216400);
        ofclass7.setSreference("A");
        ofclass7.setArtDesignation("ARMATURE EXT 3279-02 723842");
        ofclass7.setNbArtPerContainer("400");
        list.add(ofclass7);

        Of ofclass8 = new Of();
        ofclass8.setOfNum(980325);
        ofclass8.setReference(11220800);
        ofclass8.setSreference("F");
        ofclass8.setArtDesignation("CONNECTEUR TG 8-12 BORNE A GAU");
        ofclass8.setNbArtPerContainer("30");
        list.add(ofclass8);

        Of ofclass9 = new Of();
        ofclass9.setOfNum(980326);
        ofclass9.setReference(11220801);
        ofclass9.setSreference("J");
        ofclass9.setArtDesignation("CONNECTEUR TG 8-12 BORNE A DRO");
        ofclass9.setNbArtPerContainer("30");
        list.add(ofclass9);

        Of ofclass10 = new Of();
        ofclass10.setOfNum(980327);
        ofclass10.setReference(11238100);
        ofclass10.setSreference("C");
        ofclass10.setArtDesignation("CANON ISOLANT XG");
        ofclass10.setNbArtPerContainer("5000");
        list.add(ofclass10);

        Of ofclass11 = new Of();
        ofclass11.setOfNum(980328);
        ofclass11.setReference(11238300);
        ofclass11.setSreference("A01");
        ofclass11.setArtDesignation("ENJOLIVEUR CLE MVDV");
        ofclass11.setNbArtPerContainer("1000");
        list.add(ofclass11);

        Of ofclass12 = new Of();
        ofclass12.setOfNum(980329);
        ofclass12.setReference(11238500);
        ofclass12.setSreference("A01");
        ofclass12.setArtDesignation("SOFT CLE MVDV");
        ofclass12.setNbArtPerContainer("161");
        list.add(ofclass12);

        Of ofclass13 = new Of();
        ofclass13.setOfNum(980330);
        ofclass13.setReference(11239000);
        ofclass13.setSreference("A");
        ofclass13.setArtDesignation("OUTER SLEEVE 2023-02PSA065-02E");
        ofclass13.setNbArtPerContainer("800");
        list.add(ofclass13);

        Of ofclass14 = new Of();
        ofclass14.setOfNum(980331);
        ofclass14.setReference(11239300);
        ofclass14.setSreference("N2");
        ofclass14.setArtDesignation("PROTECTEUR DE COLLECTEUR");
        ofclass14.setNbArtPerContainer("900");
        list.add(ofclass14);

        Of ofclass15 = new Of();
        ofclass15.setOfNum(980332);
        ofclass15.setReference(11239800);
        ofclass15.setSreference("B1");
        ofclass15.setArtDesignation("CAPOT TG 8/12");
        ofclass15.setNbArtPerContainer("80");
        list.add(ofclass15);

        return list;
    }

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

    @POST
    @Path("postPrintMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String labelPrint(PostPrintInfo postPrintInfo) {

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
        labelType = hashmapB.get(postPrintInfo.getType());

        for (int i = 0; i < labelType.getFields().getFields().size(); i++) {
            for (int j = 0; j < postPrintInfo.getUserInputs().size(); j++) {
                if (labelType.getFields().getFields().get(i).getCode().equals(postPrintInfo.getUserInputs().get(j).getCode())) {
                    labelType.getFields().getFields().get(i).setSource(postPrintInfo.getUserInputs().get(j).getValue());
                    break;
                }
            }
        }

        label.setLabelNumber(postPrintInfo.getNum());
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
        for (int m = 0; m < original.get(postPrintInfo.getType()).getFields().getFields().size(); m++) {
            System.out.println("the code is :" + original.get(postPrintInfo.getType()).getFields().getFields().get(m).getCode());
            System.out.println("the source is :" + original.get(postPrintInfo.getType()).getFields().getFields().get(m).getSource());
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

}
