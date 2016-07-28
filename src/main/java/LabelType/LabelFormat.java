package LabelType;

import javax.xml.bind.annotation.XmlElement;

public class LabelFormat {
    String formatName;
    Float width;
    Float length;

    public LabelFormat(String formatName, Float width, Float length) {
        this.formatName = formatName;
        this.width = width;
        this.length = length;
    }

    public LabelFormat() {
    }
    
    
    @XmlElement(name = "FORMATNAME")
    public String getName() {return formatName;}

    @XmlElement(name = "WIDTH")
    public Float getWidth() {return width;}

    @XmlElement(name = "LENGTH")
    public Float getLength() {return length;}
    
    //setting methods
    public void setName(String formatName) {this.formatName = formatName;}

    public void setWidth(Float width) {this.width = width;}

    public void setLength(Float length) {this.length = length;}
    
    
}
