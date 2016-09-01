package com.mora.model;

//long ofNum, long reference, String sreference

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "of")
@XmlAccessorType (XmlAccessType.FIELD)
public class Of {
    long ofNum;
    String reference;
    String sreference;
    String artDesignation;
    int nbArtPerContainer;
    int qteOfEntete;
    Date datePlainfDebut;
    
    public Of() {
    }

    public Of(long ofNum, String reference, String sreference, String artDesignation, int nbArtPerContainer, int qteOfEntete, Date datePlainfDebut) {
        this.ofNum = ofNum;
        this.reference = reference;
        this.sreference = sreference;
        this.artDesignation = artDesignation;
        this.nbArtPerContainer = nbArtPerContainer;
        this.qteOfEntete = qteOfEntete;
        this.datePlainfDebut = datePlainfDebut;
    }

    public long getOfNum() {
        return ofNum;
    }

    public String getReference() {
        return reference;
    }

    public String getSreference() {
        return sreference;
    }

    public String getArtDesignation() {
        return artDesignation;
    }

    public int getNbArtPerContainer() {
        return nbArtPerContainer;
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

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setSreference(String sreference) {
        this.sreference = sreference;
    }

    public void setArtDesignation(String artDesignation) {
        this.artDesignation = artDesignation;
    }

    public void setNbArtPerContainer(int nbArtPerContainer) {
        this.nbArtPerContainer = nbArtPerContainer;
    }

    public void setQteOfEntete(int qteOfEntete) {
        this.qteOfEntete = qteOfEntete;
    }

    public void setDatePlainfDebut(Date datePlainfDebut) {
        this.datePlainfDebut = datePlainfDebut;
    }
    
    
    
}
