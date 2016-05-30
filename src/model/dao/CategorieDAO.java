/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    public Categorie create(Categorie cat) {
        this.setChanged();
        String sql = "INSERT INTO categorie (libelle, libelle_court, id_groupe, id_admintech) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cat.getLibelle());
            pst.setString(2, cat.getLibelle_court());
            pst.setInt(3, cat.getIdGroupe());
            pst.setInt(4, cat.getReferent());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        this.notifyObservers(cat);
        return cat;
    }

    @Override
    public Categorie update(Categorie cat) {
        String sql = "UPDATE INTO categorie SET libelle=?, libelle_court=?, id_groupe=?, id_admintech=? WHERE id_categorie=?";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(sql);
            pst.setString(1, cat.getLibelle());
            pst.setString(2, cat.getLibelle_court());
            pst.setInt(3, cat.getIdGroupe());
            pst.setInt(4, cat.getReferent());
            pst.setInt(5, cat.getIdCategorie());
            ResultSet rs = pst.executeQuery();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        return cat;
    }

    @Override
    public void delete(Categorie cat) {
        try {
            String sql = "DELETE FROM categorie WHERE id_categorie=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, cat.getIdCategorie());
            pst.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
