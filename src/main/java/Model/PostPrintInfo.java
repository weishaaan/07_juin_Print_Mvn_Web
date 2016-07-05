package Model;

class PostPrintInfo {
    long ofNum;
    String printerName;
    int num;
    String type;
    String express;
    String prefix;
    String bl;

    public PostPrintInfo(long ofNum, String printerName, int num, String type, String express, String prefix, String bl) {
        this.ofNum = ofNum;
        this.printerName = printerName;
        this.num = num;
        this.type = type;
        this.express = express;
        this.prefix = prefix;
        this.bl = bl;
    }

    
    public PostPrintInfo() {
    }

    
    public long getOfNum() {
        return ofNum;
    }

    public String getPrinterName() {
        return printerName;
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public String getExpress() {
        return express;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getBl() {
        return bl;
    }

    public void setOfNum(long ofNum) {
        this.ofNum = ofNum;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }
    
    
            
}
