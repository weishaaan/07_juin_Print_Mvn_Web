package Model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.*;
//import de.lohndirekt.print.*;

public class PrinterStatus {
    
    public void PrinterStatus(){
        // locate print services capable of printing the specified DocFlavor and attributes
        // with null no constraints are used
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Printer Services found:");
        printService(services);

        // Look up the default print service
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        if (service!=null) {
            System.out.println("Default Printer Service found:");
            System.out.println("t" + service);
        }

	
        // find printer service by name
        AttributeSet aset_name = new HashAttributeSet();
        aset_name.add(new PrinterName("Microsoft XPS Document Writer", null));
        services = PrintServiceLookup.lookupPrintServices(null, aset_name);

        System.out.println("Printer Service Microsoft XPS Document Writer:");
        printService(services);
        
        // find printer service by ip
        PrintServiceAttributeSet aset_URI = new HashPrintServiceAttributeSet();
        try {
            aset_URI.add(new PrinterURI(new URI("this ipp is wrong --ipp://hostName/printerName")));
        } catch (URISyntaxException e) {
            System.out.println("URI exception caught: "+e);
        }
        services = PrintServiceLookup.lookupPrintServices(null,aset_URI);  
        // null could be replaced by DocFlavor.INPUT_STREAM.POSTSCRIPT, etc...
        System.out.println("Printer specific URI :");
        printService(services);
        
        /*
        //another way to print to a specific uri
        URI printerURI = null;
        try {
            printerURI = new URI("ipp://SERVER:631/printers/PRINTER_NAME");
        } catch (URISyntaxException ex) {
            Logger.getLogger(PrinterStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        IppPrintService svc = new IppPrintService(printerURI);
        services = PrintServiceLookup.lookupPrintServices(null,aset_URI);  
        // null could be replaced by DocFlavor.INPUT_STREAM.POSTSCRIPT, etc...
        System.out.println("Printer specific URI :");
        printService(services);
        // following is the way to print sth in a format of flavor
        InputStream stream = new BufferedInputStream(new FileInputStream("image.epl"));
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc myDoc = new SimpleDoc(stream, flavor, null);
        DocPrintJob job = svc.createPrintJob();
        job.print(myDoc, null);
        */
        
        /*
        // find services that support a particular input format (e.g. JPEG)
        services = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.JPEG, null);
        System.out.println("Printer Services with JPEG support:");
        printService(services);

        //find services that support a set of print job capabilities (e.g. color)
        aset = new HashAttributeSet();
        aset.add(ColorSupported.SUPPORTED);
        services = PrintServiceLookup.lookupPrintServices(null, aset);

        System.out.println("Printer Services with color support:");
        printService(services);
        */        
    }

    public static void printService(PrintService[] services) {
        
        if (services != null && services.length > 0) {
            for (int i = 0; i < services.length; i++) {
                
                System.out.println("t" + services[i]);
                
                AttributeSet attributes = services[i].getAttributes();
                String printerName = attributes.get(PrinterName.class).toString();
                String printerState = attributes.get(PrinterState.class).toString();
                String printerStateReason = attributes.get(PrinterStateReason.class).toString();
                String printerURI = attributes.get(PrinterURI.class).toString();//.toURL();
                
                /*Interface PrintServiceAttribute,All Known Implementing Classes:
                    ColorSupported, PagesPerMinute, PagesPerMinuteColor, PDLOverrideSupported, 
                    PrinterInfo, PrinterIsAcceptingJobs, PrinterLocation, PrinterMakeAndModel, 
                    PrinterMessageFromOperator, PrinterMoreInfo, PrinterMoreInfoManufacturer,
                    PrinterName, PrinterState, PrinterStateReasons, PrinterURI, QueuedJobCount
                */
                System.out.println("printerName = " + printerName); 
                System.out.println("printerURI = " + printerURI); 
                System.out.println("printerState = " + printerState); // May be IDLE, PROCESSING, STOPPED or UNKNOWN
                System.out.println("printerStateReason = " + printerStateReason); // If your printer state returns STOPPED, for example, you can identify the reason 
                
                if (printerState.equals(PrinterState.STOPPED.toString())) {

                    if (printerStateReason.equals(PrinterStateReason.TONER_LOW.toString())) {

                        System.out.println("Toner level is low.");
                    }
                }
            }
        }
    }
}
