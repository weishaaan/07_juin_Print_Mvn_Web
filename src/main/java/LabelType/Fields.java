package LabelType;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Fields {

    public List<Field> fields = null;
    
    public Fields(List<Field> fields){
        this.fields = fields;
    }
    
    public Fields(){
        
    }
       
    @XmlElement(name = "FIELD")
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    
}


