package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlException;

public class FilePathDatabase {
    public static Map<String,String> filepath_catalogue = new HashMap<>();

    public static Map<String,String> getFilePathCatalogue(){
        return filepath_catalogue;
    }
    
    public List<String> getFilePath() {
        return new ArrayList<String>(filepath_catalogue.values());
    }
    
}
