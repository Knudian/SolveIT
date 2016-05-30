/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.beans.Statut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author knud
 */
public class StatutDAO extends DAO<Statut> {

    private List<Statut> statutList;
    
    /**
     * Recherche le dernier statut d'un ticket.
     * @param id_ticket l'identifiant du ticket à rechercher.
     * @return le dernier statut d'un ticket
     */
    

    @Override
    public List<Statut> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Statut create(Statut o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Statut update(Statut o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Statut o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Statut find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Retourne la valeur de statut du ticket identifié par 'id_ticket"
     * @param id_ticket identifiant du ticket à rechercher.
     * @return la valeur de statut du ticket.
     */
    public int findStatutOfTicket(int id_ticket) {
        int v_statut = -1;
        try {
            String sql = "SELECT val_statut from statut WHERE id_ticket=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, id_ticket);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                v_statut = rs.getInt("val_statut");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v_statut;
    }
}
