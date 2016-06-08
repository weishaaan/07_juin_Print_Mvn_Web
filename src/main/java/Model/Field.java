package Model;

public class Field {
    String name;
    String type;
    Float x;
    Float y;
    String value;
    String calculated;

    public Field(String name, String type, Float x, Float y, String value, String calculated) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.value = value;
        this.calculated = calculated;
    }

    public String getName() {return name;}

    public String getType() {return type;}

    public Float getX() {return x;}

    public Float getY() {return y;}

    public String getValue() {return value;}

    public String getCalculated() {return calculated;}

    public void setName(String name) {this.name = name;}

    public void setType(String type) {this.type = type;}

    public void setX(Float x) {this.x = x;}

    public void setY(Float y) {this.y = y;}

    public void setValue(String value) {this.value = value;}

    public void setCalculated(String calculated) {this.calculated = calculated;}
    
    
           
    
           
    
}
