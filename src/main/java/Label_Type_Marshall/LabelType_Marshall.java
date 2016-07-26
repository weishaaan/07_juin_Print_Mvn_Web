package Label_Type_Marshall;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LabelType_Marshall {
    
    public LabelTypes unmarshaller(String fullPath) throws JAXBException {
        
        
        System.out.println("******   Marshall Label_type path is :"+fullPath+"    ******");
        
        JAXBContext jc = JAXBContext.newInstance(LabelTypes.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        LabelTypes lts = (LabelTypes) unmarshaller.unmarshal(new File(fullPath));
        
        for (int i = 0; i < lts.getLabelTypes().size(); i++) {
            LabelType s = lts.getLabelTypes().get(i);
            System.out.println("LabelType " + i + " :");
            System.out.println("description is "+ s.getField().getDescription() );
        }
        return lts;
    }
    
    
}