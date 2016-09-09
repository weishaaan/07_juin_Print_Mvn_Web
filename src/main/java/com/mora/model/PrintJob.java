package com.mora.model;

import com.mora.printer.Printer;

public class PrintJob {   
    Label label;
    Printer printer;
    Config config;
    int nbrEtiqHousse;
    int nbreEtiqPrelev;

    public PrintJob(Label label, Printer printer, Config config, int nbrEtiqHousse, int nbreEtiqPrelev) {
        this.label = label;
        this.printer = printer;
        this.config = config;
        this.nbrEtiqHousse = nbrEtiqHousse;
        this.nbreEtiqPrelev = nbreEtiqPrelev;
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

    public int getNbrEtiqHousse() {
        return nbrEtiqHousse;
    }

    public int getNbreEtiqPrelev() {
        return nbreEtiqPrelev;
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

    public void setNbrEtiqHousse(int nbrEtiqHousse) {
        this.nbrEtiqHousse = nbrEtiqHousse;
    }

    public void setNbreEtiqPrelev(int nbreEtiqPrelev) {
        this.nbreEtiqPrelev = nbreEtiqPrelev;
    }
    
    
    
}
