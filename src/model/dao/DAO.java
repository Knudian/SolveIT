/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.ConnexionMySql;
import java.sql.Connection;
import java.util.List;
import java.util.Observable;


/**
 *
 * @author Shrink
 * @param <T>
 */
public abstract class DAO <T> extends Observable{
    
    protected Connection connexion;

    public DAO() {
        this.connexion = ConnexionMySql.getInstance();
    }
    
    public abstract T find (int id);
    public abstract List <T> findAll ();
    public abstract T create (T o);
    public abstract T update (T o);
    public abstract void delete (T o);
    
}
