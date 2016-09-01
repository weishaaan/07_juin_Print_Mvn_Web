package com.mora.labeltype;

import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBException;
import org.apache.xmlbeans.XmlException;

public class LabelTypeConfig {

    public Map<String, LabelType> catalogue = LabelTypeDatabase.getMapLabelTypes();
    
    public LabelTypeConfig(String fullPath) throws XmlException, IOException, JAXBException {
        
        LabelType_Marshall m = new LabelType_Marshall();
        LabelTypes labelTypes = m.unmarshaller(fullPath);
        
        for (int i = 0; i < labelTypes.getLabelTypes().size(); i++) {
            LabelType labelType = labelTypes.getLabelTypes().get(i);
            catalogue.put(labelType.getReference(), labelType);
        }
    }
}

