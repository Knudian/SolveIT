/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.AdminTech;

/**
 *
 * @author knud
 */
public class AdminTechDAO extends DAO<AdminTech> {
    
    private List<AdminTech> adminTechList;

    @Override
    public AdminTech find(int id_admintech) {
        AdminTech a = null;
        String sql = "SELECT * FROM admintech WHERE id_admintech=?";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(sql);
            pst.setInt(1, id_admintech);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a = new AdminTech(rs.getInt("id_admintech"), rs.getString("fonction"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public List<AdminTech> findAll() {
        this.adminTechList = new ArrayList();
        try {
            String sql = "SELECT * FROM admintech, utilisateur WHERE admintech.id_user = utilisateur.id_user";
            PreparedStatement pst = connexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                this.adminTechList.add(new AdminTech(
                        rs.getInt("id_admintech"),
                        rs.getString("fonction"),
                        rs.getInt("id_user"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("u_login"),
                        rs.getString("u_pwd")
                )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.adminTechList;
    }

    @Override
    public AdminTech create(AdminTech o) {
        this.setChanged();
        /*
            Pour cr�er un utilisateur de type AdminTech,
            il faut que l'objet fourni en entr�e soit un objet de type "User",
            cast� en tant qu'AdminTech, afin de pouvoir attribuer un identifiant,
            ainsi qu'une fonction.
        */
        try {
            
            String sql = "INSERT INTO admintech (id_user, fonction) VALUES (?, ?)";
            PreparedStatement pst = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, o.getId_user());
            pst.setString(2, o.getFonction());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                o.setIdAdminTech(rs.getInt(1));
            }            
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        this.notifyObservers(o);
        return o;
    }
    
    /**
     * Cette m�thode ne peut �tre invoqu�e que pour :
     * - changer la fonction d'un admintech pr�cis,
     * - changer l'id_user de r�f�rence de cet admintech,
     * - les deux � la fois.
     * 
     * @param admintech est l'instance devant �tre modifi�e en base de donn�es.
     * @return l'instance modifi�e, une fois la mise � jour effectu�e.
     */
    @Override
    public AdminTech update(AdminTech admintech) {
        this.setChanged();
        try {
            String sql = "UPDATE INTO admintech (id_user, fonction) VALUES (?, ?) WHERE id_admintech=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, admintech.getId_user());
            pst.setString(2, admintech.getFonction());
            pst.setInt(3, admintech.getIdAdminTech());
            pst.executeQuery();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        this.notifyObservers(admintech);
        return admintech;
    }

    @Override
    public void delete(AdminTech admintech) {
        try {
            String sql = "DELETE FROM admintech WHERE id_admintech=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, admintech.getIdAdminTech());
            pst.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
