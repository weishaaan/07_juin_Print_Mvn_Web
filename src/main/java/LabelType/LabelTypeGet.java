package LabelType;

import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"labelName", "reference", "listField"})
public class LabelTypeGet {
    String reference;
    String labelName;
    List<Field> listField;
    
    
    public LabelTypeGet(String reference, String labelName, List<Field> listField) {
        this.reference = reference;
        this.labelName = labelName;
        this.listField = listField;
    }

    public LabelTypeGet() {
    }

    public String getReference() {
        return reference;
    }

    public String getLabelName() {
        return labelName;
    }

    public List<Field> getListField() {
        return listField;
    }

    public void setListField(List<Field> listField) {
        this.listField = listField;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    
    
}
