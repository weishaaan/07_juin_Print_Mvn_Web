package com.mora.model;

//long ofNum, long reference, String sreference

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "of")
@XmlAccessorType (XmlAccessType.FIELD)
public class Of {
    
    String ofNum;
    String reference;
    String sreference;
    String artDesignation;
    int nbArtPerContainer;
    int qteOfEntete;
    String xIndiceEtiq;
    String referenceCli;
    String tiersExterne;
    String sigleQualite;
    boolean aqp; 
    Date dateOf;
    
    public Of() {
    }

    public Of(String ofNum, String reference, String sreference, String artDesignation, int nbArtPerContainer, int qteOfEntete,String xIndiceEtiq, String referenceCli, String tiersExterne, String sigleQualite, boolean aqp, Date dateOf) {
        this.ofNum = ofNum;
        this.reference = reference;
        this.sreference = sreference;
        this.artDesignation = artDesignation;
        this.nbArtPerContainer = nbArtPerContainer;
        this.qteOfEntete = qteOfEntete;
        this.xIndiceEtiq = xIndiceEtiq;
        this.referenceCli = referenceCli;
        this.tiersExterne = tiersExterne;
        this.sigleQualite = sigleQualite;
        this.aqp = aqp;
        this.dateOf = dateOf;
    }

    public String getOfNum() {
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

    public String getxIndiceEtiq() {
        return xIndiceEtiq;
    }

    public String getReferenceCli() {
        return referenceCli;
    }

    public String getTiersExterne() {
        return tiersExterne;
    }

    public String getSigleQualite() {
        return sigleQualite;
    }

    public boolean isAqp() {
        return aqp;
    }

    public Date getDateOf() {
        return dateOf;
    }

    public void setOfNum(String ofNum) {
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

    public void setxIndiceEtiq(String xIndiceEtiq) {
        this.xIndiceEtiq = xIndiceEtiq;
    }

    public void setReferenceCli(String referenceCli) {
        this.referenceCli = referenceCli;
    }

    public void setTiersExterne(String tiersExterne) {
        this.tiersExterne = tiersExterne;
    }

    public void setSigleQualite(String sigleQualite) {
        this.sigleQualite = sigleQualite;
    }

    public void setAqp(boolean aqp) {
        this.aqp = aqp;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }
    
    
    
}
