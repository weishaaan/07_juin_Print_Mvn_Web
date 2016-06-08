package Model;

public class LabelFormat {
    String name;
    Float width;
    Float length;

    public LabelFormat(String name, Float width, Float length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }
    
    //getting methods
    public String getName() {return name;}

    public Float getWidth() {return width;}

    public Float getLength() {return length;}
    
    //setting methods
    public void setName(String name) {this.name = name;}

    public void setWidth(Float width) {this.width = width;}

    public void setLength(Float length) {this.length = length;}
    
    
}
