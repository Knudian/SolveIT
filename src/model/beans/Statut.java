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
public class Statut {
    /* Attributs */
    private int idStatut;
    private int idticket;
    private String statutDate;
    private int statuttype;
    /* Constructeurs */
    public Statut(){ this.idStatut = 0; }

    public Statut(int idStatut, int idticket, String statutDate, int statuttype) {
        this.idStatut = idStatut;
        this.idticket = idticket;
        this.statutDate = statutDate;
        this.statuttype = statuttype;
    }
    /* Getters */
    public int getIdStatut()        { return this.idStatut; }
    public int getIdticket()        { return this.idticket; }
    public String getStatutDate()   { return this.statutDate; }
    public int getStatuttype()      { return this.statuttype; }
    /* Setters */
    public void setIdStatut(int idStatut) { this.idStatut = idStatut; }
    public void setIdticket(int idticket) { this.idticket = idticket; }
    public void setStatutDate(String statutDate) { this.statutDate = statutDate; } 
    public void setStatuttype(int statuttype) { this.statuttype = statuttype; }

    @Override
    public String toString() {
        return "Statut{" + "idStatut=" + idStatut + ", idticket=" + idticket + ", statutDate=" + statutDate + ", statuttype=" + statuttype + '}';
    }
}
