package com.mora.printer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"dpi", "ip", "name", "type", "status"})
public class Printer {
    int dpi;
    String ip;
    String name;
    String type;
    Boolean status;

    public Printer(int dpi, String ip, String name, String type, Boolean status) {
        this.dpi = dpi;
        this.ip = ip;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public Printer() {
    }

    @XmlElement(name = "DPI")
    public int getDpi() {
        return dpi;
    }
    
    @XmlElement(name = "IP")
    public String getIp() {
        return ip;
    }
    
    @XmlElement(name = "NAME")
    public String getName() {
        return name;
    }

    @XmlElement(name = "TYPE")
    public String getType() {
        return type;
    }
    
    @XmlElement(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
