/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author knud
 */
public class Categorie {
    /* Attributs */
    private int idCategorie;
    private int idGroupe;
    private String libelle;
    private String libelle_court;
    private int idReferent;
    /* Constructeur */
    public Categorie(){
        this.idCategorie = 0;
    }

    public Categorie(int idCategorie, int idGroupe, String libelle, String libelle_court, int referent) {
        this.idCategorie = idCategorie;
        this.idGroupe = idGroupe;
        this.libelle = libelle;
        this.libelle_court = libelle_court;
        this.idReferent = referent;
    }
    /* Getters */
    public int getIdCategorie()      { return this.idCategorie; }
    public int getIdGroupe()         { return this.idGroupe; }
    public String getLibelle()       { return this.libelle; }
    public String getLibelle_court() { return this.libelle_court; }
    public int getReferent()        { return this.idReferent; }
    /* Setters */
    public void setIdCategorie(int idCategorie)        { this.idCategorie = idCategorie; }
    public void setIdGroupe(int idGroupe)              { this.idGroupe = idGroupe; }
    public void setLibelle(String libelle)             { this.libelle = libelle; }
    public void setLibelle_court(String libelle_court) { this.libelle_court = libelle_court; }
    public void setReferent(int referent)             { this.idReferent = referent; }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + this.idCategorie
                + ", idGroupe=" + this.idGroupe
                + ", libelle=" + this.libelle
                + ", libelle_court=" + this.libelle_court
                + ", referent=" + this.idReferent + '}';
    }
    
}
