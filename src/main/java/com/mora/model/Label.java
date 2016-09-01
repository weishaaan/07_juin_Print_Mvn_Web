package com.mora.model;

import com.mora.labeltype.LabelFormat;
import com.mora.labeltype.LabelType;
import java.util.List;

public class Label {
    
    int labelNumber;
    String creationTime;
    String lastPrintTime;
    LabelFormat labelFormat;
    LabelType labelType;
    
    
    public Label(int labelNumber,String creationTime,String lastPrintTime,LabelFormat labelFormat,LabelType labelType){
        this.labelNumber = labelNumber;
        this.creationTime = creationTime;
        this.lastPrintTime = lastPrintTime;
        this.labelFormat = labelFormat;
        this.labelType = labelType;
        
    }

    public Label() {
    }
    
    
    //getting methods
    public int getLabelNumber() {return labelNumber;}

    public String getCreationTime() {return creationTime;}

    public String getLastPrintTime() {return lastPrintTime;}

    public LabelFormat getLabelFormat() {return labelFormat;}

    public LabelType getLabelType() {return labelType;}

    //setting methods
    public void setLabelNumber(int labelNumber) {this.labelNumber = labelNumber;}

    public void setCreationTime(String creationTime) {this.creationTime = creationTime;}

    public void setLastPrintTime(String lastPrintTime) {this.lastPrintTime = lastPrintTime;}

    public void setLabelFormat(LabelFormat labelFormat) {this.labelFormat = labelFormat;}

    public void setLabelType(LabelType labelType) {this.labelType = labelType;}

}
