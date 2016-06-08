package Model;

import java.util.List;

public class LabelType {
    String generic;
    int reference;
    List<Field> field;
    
    public LabelType(String generic, int reference,List<Field> field) {
        this.generic = generic;
        this.reference = reference;
        this.field = field;
    }

     
    
    //getting methods
    public String getGeneric() {return generic;}

    public int getReference() {return reference;}

    public List<Field> getField() {return field;}
    
    //setting methods
    public void setGeneric(String generic) {this.generic = generic;}

    public void setReference(int reference) {this.reference = reference;}
    
}
