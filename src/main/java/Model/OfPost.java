package Model;

public class OfPost {
    String ref;
    String sousref;
    String date1;
    String date2;

    public OfPost() {
    }

    public OfPost(String ref, String sousref, String date1, String date2) {
        this.ref = ref;
        this.sousref = sousref;
        this.date1 = date1;
        this.date2 = date2;
    }

    public String getRef() {
        return ref;
    }

    public String getSousref() {
        return sousref;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setSousref(String sousref) {
        this.sousref = sousref;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
    
    
}
