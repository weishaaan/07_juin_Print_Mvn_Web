package Printer_Marshall;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CATALOG")
@XmlAccessorType (XmlAccessType.FIELD)
public class Printers{
    @XmlElement(name = "PRINTER")
    public List<Printer> printers = null;

    public List<Printer> getPrinters() {
        return printers;
    }
 
    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }
}
