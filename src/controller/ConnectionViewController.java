/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import views.ConnectionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.beans.User;
import model.dao.UserDAO;

/**
 *
 * @author Shrink
 */
public class ConnectionViewController implements ActionListener {

    private ConnectionView vue;
    private UserDAO userDAO;

    public ConnectionViewController() {
        this.vue = new ConnectionView(this);
        this.userDAO = new UserDAO();
        this.userDAO.addObserver(this.vue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user;
        
        if (e.getSource() == vue.getConnectionButton()) {
            String login = this.vue.getLoginTextfield().getText();
            String pwd = String.valueOf(this.vue.getPasswordTextfield().getPassword());

            if (checkUserExists(login) == false) {
                vue.erreurLoginPwd();
            } else if (checkUserRightPwd(pwd, login) == false) {
                vue.erreurLoginPwd();
            } else if (checkUserFirstConnect(pwd) == true) {
                user = this.userDAO.findByLogin(login);
                System.out.println("1ere connexion");
                new FirstConnectionViewController(user);
                this.vue.getLoginTextfield().setText("");
                this.vue.getPasswordTextfield().setText("");
            } else {
                System.out.println("C'est la vue principale là... Si Si !!");
                user = this.userDAO.findByLogin(login);
                new MainViewController(user);
                this.vue.dispose();
            }

        }

    }

    private boolean checkUserExists(String login) {
        if (this.userDAO.findByLogin(login) == null) {
            return false;
        }
        return true;
    }

    private boolean checkUserRightPwd(String pwd, String login) {
        if (this.userDAO.findByLogin(login).getU_pwd().equals(pwd)) {
            return true;
        }
        return false;
    }

    private boolean checkUserFirstConnect(String pwd) {
        if (pwd.equals("P@ssword")) {
            return true;
        }
        return false;
    }

}
