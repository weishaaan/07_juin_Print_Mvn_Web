package Model;

//long ofNum, long reference, String sreference

import java.util.Date;

public class Of {
    long ofNum;
    long reference;
    String sreference;
    String artDesignation;
    String nbArtPerContainer;
    int qteOfEntete;
    Date datePlainfDebut;
    
    public Of() {
    }

    public Of(long ofNum, long reference, String sreference, String artDesignation, String nbArtPerContainer, int qteOfEntete, Date datePlainfDebut) {
        this.ofNum = ofNum;
        this.reference = reference;
        this.sreference = sreference;
        this.artDesignation = artDesignation;
        this.nbArtPerContainer = nbArtPerContainer;
        this.qteOfEntete = qteOfEntete;
        this.datePlainfDebut = datePlainfDebut;
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

    public int getQteOfEntete() {
        return qteOfEntete;
    }

    public Date getDatePlainfDebut() {
        return datePlainfDebut;
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

    public void setQteOfEntete(int qteOfEntete) {
        this.qteOfEntete = qteOfEntete;
    }

    public void setDatePlainfDebut(Date datePlainfDebut) {
        this.datePlainfDebut = datePlainfDebut;
    }
    
    
    
    
    
}
