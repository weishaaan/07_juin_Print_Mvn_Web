package Label_Type_Marshall;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class LabelType {
    
    Field field;

    public LabelType(Field field) {
        this.field = field;
    }

    public LabelType() {
    }
    

    @XmlElement(name = "FIELD")
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
    
    
}