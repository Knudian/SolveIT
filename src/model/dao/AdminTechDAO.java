/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.*;
import java.util.*;
import model.beans.AdminTech;

/**
 *
 * @author knud
 */
public class AdminTechDAO extends DAO<AdminTech> {
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminTech create(AdminTech o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminTech update(AdminTech o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AdminTech o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
