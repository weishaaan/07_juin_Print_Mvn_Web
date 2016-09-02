package com.mora.labeltype;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CATALOG")
@XmlAccessorType (XmlAccessType.FIELD)
public class LabelTypes {
  
    @XmlElement(name = "LABELTYPE")
    public List<LabelType> labelTypes;

    public List<LabelType> getLabelTypes() {
        return labelTypes;
    }
 
    public void setLabelTypes(List<LabelType> labelTypes) {
        this.labelTypes = labelTypes;
    }
}
