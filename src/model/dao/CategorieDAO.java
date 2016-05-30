/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Categorie;

/**
 *
 * @author knud
 */
public class CategorieDAO extends DAO<Categorie> {

    private List<Categorie> categorieList;

    @Override
    public Categorie find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> findAll() {
        this.categorieList = new ArrayList();

        String sql = "SELECT * FROM categorie";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.categorieList.add(new Categorie(
                        rs.getInt("id_categorie"),
                        rs.getInt("id_groupe"),
                        rs.getString("libelle"),
                        rs.getString("libelle_court"),
                        rs.getInt("id_admintech")
                    )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return this.categorieList;
    }

    @Override
    public Categorie create(Categorie o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorie update(Categorie o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Categorie o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Categorie> findCategoriesForFilters() {

        this.categorieList = new ArrayList();

        String sql = "SELECT * FROM categorie WHERE id_groupe!=5";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.categorieList.add(new Categorie(
                        rs.getInt("id_categorie"),
                        rs.getInt("id_groupe"),
                        rs.getString("libelle"),
                        rs.getString("libelle_court"),
                        rs.getInt("id_admintech")
                    )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return this.categorieList;

    }
}
