/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


//long ofNum, long reference, String sreference
public class Of {
    long ofNum;
    long reference;
    String sreference;
    String artDesignation;
    String nbArtPerContainer;

    public void setArtDesignation(String artDesignation) {
        this.artDesignation = artDesignation;
    }

    public void setNbArtPerContainer(String nbArtPerContainer) {
        this.nbArtPerContainer = nbArtPerContainer;
    }

    public String getArtDesignation() {
        return artDesignation;
    }

    public String getNbArtPerContainer() {
        return nbArtPerContainer;
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

    public long getOfNum() {
        return ofNum;
    }

    public long getReference() {
        return reference;
    }

    public String getSreference() {
        return sreference;
    }
    
    
    
    
}
