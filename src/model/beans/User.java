/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Shrink
 */
public class User {

    private int id_user;
    private String nom;
    private String prenom;
    private String u_login;
    private String u_pwd;

    public User() {
        this.id_user = 0;
    }

    public User(int id_user, String nom, String prenom, String u_login, String u_pwd) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.u_login = u_login;
        this.u_pwd = u_pwd;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user
                + ", nom=" + nom + ", prenom=" + prenom +
                ", u_login=" + u_login + ", u_pwd=" + u_pwd + "}";
    }
    
    public int getId_user() {
        return this.id_user;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getU_login() {
        return this.u_login;
    }

    public String getU_pwd() {
        return this.u_pwd;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setU_login(String u_login) {
        this.u_login = u_login;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

}
