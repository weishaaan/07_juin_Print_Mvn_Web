package Model;

import java.util.List;

class PostPrintInfo {
    long ofNum;
    String ip;
    int num;
    String type;
    List<UserInput> userInputs;
    
    /*
    String express;
    String date;
    String bl;
*/
    public PostPrintInfo(long ofNum, String ip, int num, String type,List<UserInput> userInputs) {
        this.ofNum = ofNum;
        this.ip = ip;
        this.num = num;
        this.type = type;
        this.userInputs = userInputs;
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

    public List<UserInput> getUserInputs() {
        return userInputs;
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
    
    public void setUserInputs(List<UserInput> userInputs) {
        this.userInputs = userInputs;
    }
    
}
