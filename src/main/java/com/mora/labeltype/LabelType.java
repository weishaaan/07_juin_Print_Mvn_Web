package com.mora.labeltype;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"generic", "reference", "labelName", "description","format","fields"})
public class LabelType {
    String generic;
    String reference;
    String labelName;
    String description;
    LabelFormat format;
    Fields fields;

    public LabelType() {
    }

    public LabelType(String generic, String reference, String labelName, 
            String description, LabelFormat format, Fields fields) {
        this.generic = generic;
        this.reference = reference;
        this.labelName = labelName;
        this.description = description;
        this.format = format;
        this.fields = fields;
    }
    
    @XmlElement(name = "GENERIC")
    public String getGeneric() {
        return generic;
    }

    @XmlElement(name = "REFERENCE")
    public String getReference() {
        return reference;
    }

    @XmlElement(name = "LABELNAME")
    public String getLabelName() {
        return labelName;
    }

    @XmlElement(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    
    @XmlElement(name = "FORMAT")
    public LabelFormat getFormat() {
        return format;
    }
    
    
    @XmlElement(name = "FIELDS")
    public Fields getFields() {
        return fields;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFormat(LabelFormat format) {
        this.format = format;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    
    
    @Override
    public String toString() {
      return getReference()+" - "+ getLabelName();
  }
}