package com.mora.model;

public class Config {
    int defaultPrinter_ID;
    
    public Config(int defaultPrinter_ID) {
        this.defaultPrinter_ID = defaultPrinter_ID;
    }

    public Config() {
    }
    
    public int getDefaultPrinter_ID() {
        return defaultPrinter_ID;
    }

    public void setDefaultPrinter_ID(int defaultPrinter_ID) {
        this.defaultPrinter_ID = defaultPrinter_ID;
    }

}
