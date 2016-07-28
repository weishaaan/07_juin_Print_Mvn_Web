package Model;

import Label.Label;
import Printer_Marshall.Printer;

public class PrintJob {   
    Label label;
    Printer printer;
    Config config;
    
    public PrintJob(Label label,Printer printer, Config config) {
        this.label = label;
        this.printer = printer;
        this.config = config;
    }

    public PrintJob() {
        
    }
    
    public void print(){
        // print(ofnum, nbre, labelCode, printer): type
    
    }
    
    public void save(){
        
    }
    
    //******************* GET & SET ************************************
    public Label getLabel() {
        return label;
    }

    public Printer getPrinter() {
        return printer;
    }

    public Config getConfig() {
        return config;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
    
    
}
