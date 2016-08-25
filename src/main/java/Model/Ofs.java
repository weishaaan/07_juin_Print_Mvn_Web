package Model;

import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "ofsList")
@XmlAccessorType (XmlAccessType.FIELD)
public class Ofs {
    
    @XmlElement(name="of")
    private List<Of> ofList;
 
    public List<Of> getEmployeeList() {
        return ofList;
    }
 
    public void setEmployeeList(List<Of> ofList) {
        this.ofList = ofList;
    }
}
