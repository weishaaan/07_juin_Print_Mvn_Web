package com.mora.model;

import com.mora.labeltype.LabelFormat;
import com.mora.labeltype.LabelType;
import java.util.List;

public class Label {
    
    String ofNum;
    int labelNumber;
    int nbrArt;
    String creationTime;
    String lastPrintTime;
    LabelType labelType;

    public Label(String ofNum, int labelNumber, int nbrArt, String creationTime, String lastPrintTime, LabelType labelType) {
        this.ofNum = ofNum;
        this.labelNumber = labelNumber;
        this.nbrArt = nbrArt;
        this.creationTime = creationTime;
        this.lastPrintTime = lastPrintTime;
        this.labelType = labelType;
    }

    public Label() {
    }
    
    //getting methods
    
    public String getOfNum() {return ofNum;}

    public int getLabelNumber() {return labelNumber;}
    
    public int getNbrArt() {return nbrArt;}

    public String getCreationTime() {return creationTime;}

    public String getLastPrintTime() {return lastPrintTime;}

    public LabelType getLabelType() {return labelType;}
    
    //setting methods
    
    public void setOfNum(String ofNum) {this.ofNum = ofNum;}

    public void setLabelNumber(int labelNumber) {this.labelNumber = labelNumber;}

    public void setCreationTime(String creationTime) {this.creationTime = creationTime;}

    public void setLastPrintTime(String lastPrintTime) {this.lastPrintTime = lastPrintTime;}

    public void setLabelType(LabelType labelType) {this.labelType = labelType;}

    public void setNbrArt(int nbrArt) {this.nbrArt = nbrArt;}
}
