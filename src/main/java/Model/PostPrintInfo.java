package Model;

class PostPrintInfo {
    long ofNum;
    String ip;
    int num;
    String type;
    String express;
    String date;
    String bl;

    public PostPrintInfo(long ofNum, String ip, int num, String type, String express, String date, String bl) {
        this.ofNum = ofNum;
        this.ip = ip;
        this.num = num;
        this.type = type;
        this.express = express;
        this.date = date;
        this.bl = bl;
    }

    
    public PostPrintInfo() {
    }

    
    public long getOfNum() {
        return ofNum;
    }

    public String getIp() {
        return ip;
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

    public String getDate() {
        return date;
    }

    public String getBl() {
        return bl;
    }

    public void setOfNum(long ofNum) {
        this.ofNum = ofNum;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }
    
    
            
}
