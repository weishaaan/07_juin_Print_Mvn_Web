package Label_Type_Marshall;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"code", "description", "type", "x","y","value", "calculated","source"})
public class Field {
    String code;
    String description;
    String type;
    Float x;
    Float y;
    String value;
    String calculated;
    String source;
    
    public Field() {
    }

    public Field(String code, String description, String type, Float x, Float y, String value, String calculated, String source) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.x = x;
        this.y = y;
        this.value = value;
        this.calculated = calculated;
        this.source = source;
    }
    
    @XmlElement(name = "CODE")
    public String getCode() {
        return code;
    }
    
    @XmlElement(name = "DESCRIPTION")    
    public String getDescription() {
        return description;
    }
    
    @XmlElement(name = "TYPE")
    public String getType() {
        return type;
    }

    @XmlElement(name = "X")
    public Float getX() {
        return x;
    }
    
    @XmlElement(name = "Y")
    public Float getY() {
        return y;
    }
    
    @XmlElement(name = "VALUE")
    public String getValue() {
        return value;
    }

    @XmlElement(name = "CALCULATED")
    public String getCalculated() {
        return calculated;
    }

    @XmlElement(name = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCalculated(String calculated) {
        this.calculated = calculated;
    }

    public void setSource(String source) {
        this.source = source;
    }
    
    
    
    
}
