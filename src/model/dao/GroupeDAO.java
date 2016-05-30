/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.beans.Groupe;
import model.beans.User;

/**
 *
 * @author knud
 */
public class GroupeDAO extends DAO<Groupe> {

    @Override
    public Groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groupe> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe create(Groupe o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe update(Groupe o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Groupe o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getSessionsId(){
        int a = -1;
        try {
            String sql = "SELECT id_groupe FROM groupe WHERE libelle like 'Session%'";
            PreparedStatement pst = connexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a = rs.getInt("id_groupe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
}
