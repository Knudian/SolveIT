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
public class Ticket {
    /* Attributs */
    private int idTicket;
    private Statut ticketStatut;
    private String titre;
    private String commentaire;
    private User redacteur;
    private int categorie;
    
    /* Constructeurs */
    public Ticket(){
        this.idTicket = 0;
    }
    
    public Ticket(int idTicket, int categorie, String titre, String commentaire, Statut statut, User redacteur) {
        this.idTicket = idTicket;
        this.categorie = categorie;
        this.titre = titre;
        this.commentaire = commentaire;
        this.ticketStatut = statut;
        this.redacteur = redacteur;
    }
    /* Getters */
    public int getIdTicket()        { return this.idTicket; }
    public Statut getTicketStatut() { return this.ticketStatut; }
    public String getTitre()        { return this.titre; }
    public String getCommentaire()  { return this.commentaire; }
    public User getRedacteur()      { return this.redacteur; }
    public int getCategorie()       { return this.categorie; }
    /* Setters */
    public void setIdTicket(int idTicket)            { this.idTicket = idTicket; }
    public void setTicketStatut(Statut ticketStatut) { this.ticketStatut = ticketStatut; }
    public void setTitre(String titre)               { this.titre = titre; }
    public void setCommentaire(String commentaire)   { this.commentaire = commentaire; }
    public void setRedacteur(User redacteur)         { this.redacteur = redacteur; }
    public void setCategorie(int categorie)          { this.categorie = categorie; }
    /* ToString */

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + this.idTicket
                + ", ticketStatut=" + this.ticketStatut
                + ", titre=" + this.titre
                + ", commentaire=" + this.commentaire
                + ", redacteur=" + this.redacteur
                + ", categorie=" + this.categorie + "}";
    }
    
}
