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
public class AdminTech extends User {
    
    private int idAdminTech;
    private String fonction;

    public AdminTech(){
        super();
    }
    public AdminTech(int idAdminTech, String fonction) {
        this.idAdminTech = idAdminTech;
        this.fonction = fonction;
    }

    public AdminTech(int idAdminTech, String fonction, int id_user, String nom, String prenom, String u_login, String u_pwd) {
        super(id_user, nom, prenom, u_login, u_pwd);
        this.idAdminTech = idAdminTech;
        this.fonction = fonction;
    }
    /* Getters */
    public int getIdAdminTech() { return this.idAdminTech; }
    public String getFonction() { return this.fonction; }
    /* Setters */
    public void setIdAdminTech(int idAdminTech) { this.idAdminTech = idAdminTech; }
    public void setFonction(String fonction)    { this.fonction = fonction; }

    @Override
    public String toString() {
        
        return super.toString() + "AdminTech : {" + "idAdminTech=" + idAdminTech + ", fonction=" + fonction + "}";
        
    }
    
}
