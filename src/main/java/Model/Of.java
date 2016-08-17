package Model;

//long ofNum, long reference, String sreference
public class Of {
    long ofNum;
    long reference;
    String sreference;
    String artDesignation;
    String nbArtPerContainer;

    public Of() {
    }
    
    public Of(long ofNum, long reference, String sreference, String artDesignation, String nbArtPerContainer) {
        this.ofNum = ofNum;
        this.reference = reference;
        this.sreference = sreference;
        this.artDesignation = artDesignation;
        this.nbArtPerContainer = nbArtPerContainer;
    }

    
    

    public String getArtDesignation() {
        return artDesignation;
    }

    public String getNbArtPerContainer() {
        return nbArtPerContainer;
    }
    
    public long getOfNum() {
        return ofNum;
    }

    public long getReference() {
        return reference;
    }

    public String getSreference() {
        return sreference;
    }
    
    public void setOfNum(long ofNum) {
        this.ofNum = ofNum;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public void setSreference(String sreference) {
        this.sreference = sreference;
    }

    public void setArtDesignation(String artDesignation) {
        this.artDesignation = artDesignation;
    }

    public void setNbArtPerContainer(String nbArtPerContainer) {
        this.nbArtPerContainer = nbArtPerContainer;
    }
    
    
    
    
    
}
