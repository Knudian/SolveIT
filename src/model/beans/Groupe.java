/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.List;

/**
 *
 * @author knud
 */
public class Groupe {
    /* Attributs */
    private int idGroupe;
    private String libelle;
    
    /* Constructeur */
    public Groupe(){ this.idGroupe =0; }

    public Groupe(int idGroupe, String libelle) {
        this.idGroupe = idGroupe;
        this.libelle = libelle;
    }
    
    /* Getters */
    public int getIdGroupe()   { return this.idGroupe; }
    public String getLibelle() { return this.libelle; }
    /* Setters */
    public void setIdGroupe(int idGroupe)  { this.idGroupe = idGroupe; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    @Override
    public String toString() {
        return "Groupe{" + "idGroupe=" + this.idGroupe + ", libelle=" + this.libelle + "}";
    }
    
}
