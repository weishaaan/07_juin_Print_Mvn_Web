package Label_Type_Marshall;

import Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelTypeDatabase {
    public static Map<String,LabelType> catalogue = new HashMap<String,LabelType>();

    public static Map<String,LabelType> getMapLabelTypes(){
        return catalogue;
    }
    
    public List<LabelType> getAllLabelTypes() {
        
        return new ArrayList<LabelType>(catalogue.values());
        
    }
/*
    public LabelType getLabelType(String code) throws XmlException, IOException {
        
        LabelType b = catalogue.get(code);
        
        if(b!= null)
            return b;
        else 
            return null;
    }
    */
}
