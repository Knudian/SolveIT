/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.beans.User;
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
 * @author Shrink
 */
public class UserDAO extends DAO<User> {

    private List<User> userList;

    @Override
    public User find(int id) {
        User user = null;

        try {
            String sql = "SELECT * FROM Utilisateur WHERE id_user=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id_user"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("u_login"),
                        rs.getString("u_pwd")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (user);
    }

    public User findByLogin(String login) {
        User user = null;

        try {
            String sql = "SELECT * FROM Utilisateur WHERE u_login=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id_user"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("u_login"),
                        rs.getString("u_pwd")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (user);
    }

    @Override
    public List<User> findAll() {
        this.userList = new ArrayList();

        try {
            String sql = "SELECT * FROM Utilisateur";
            ResultSet rs = connexion.createStatement().executeQuery(sql);

            while (rs.next()) {
                this.userList.add(new User(
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

        return userList;
    }

    @Override
    public User create(User user) {
        this.setChanged();
        try {
            String sql = "INSERT INTO Utilisateur (prenom, nom, u_login, u_pwd) VALUES (?,?, ?, ?) ";
            PreparedStatement pst = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getPrenom());
            pst.setString(2, user.getNom());
            pst.setString(3, user.getU_login());
            pst.setString(4, user.getU_pwd());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                user.setId_user(rs.getInt(1));
            }
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        this.notifyObservers(user);
        return user;
    }

    @Override
    public User update(User user) {
//        this.setChanged(); // voir le commentaire suivant
        try {
            String sql = "UPDATE Utilisateur SET nom=?, prenom=?, u_login=?, u_pwd=? WHERE id_user=? ";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setString(1, user.getPrenom());
            pst.setString(2, user.getNom());
            pst.setString(3, user.getU_login());
            pst.setString(4, user.getU_pwd());
            pst.setInt(5, user.getId_user());
            pst.executeUpdate();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
//        this.notifyObservers(p); // Ici pas d'interet parce qu'on change directement le tableau....
        return user; // Ici l'idée est de retourner la requete Find(p.getId)
    }

    @Override
    public void delete(User user) {
        this.setChanged();
        try {
            String sql = "DELETE FROM Utilisateur WHERE id_user=?";
            PreparedStatement pst = connexion.prepareStatement(sql);
            pst.setInt(1, user.getId_user());
            pst.executeUpdate();

        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        this.notifyObservers();
    }
}
