package LabelType;

import Model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlException;

public class LabelTypeDatabase {
    public static Map<String,LabelType> catalogue = new HashMap<String,LabelType>();

    public static Map<String,LabelType> getMapLabelTypes(){
        return catalogue;
    }
    
    public List<LabelType> getAllLabelTypes() {
        
        return new ArrayList<LabelType>(catalogue.values());
        
    }
    
    /*
    public LabelType getLabelType(String reference) throws XmlException, IOException {
        LabelType b = catalogue.get(reference);
        if(b!= null)
            return b;
        else 
            return null;
    }
    */
}
