/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.beans.User;
import model.dao.UserDAO;
import views.FirstConnectionView;

/**
 *
 * @author Yoanns
 */
public class FirstConnectionViewController implements ActionListener {

    private FirstConnectionView vue;
    private UserDAO userDAO;
    private User user;

    public FirstConnectionViewController(User user) {
        this.vue = new FirstConnectionView(this);
        this.userDAO = new UserDAO();
        this.userDAO.addObserver(this.vue);
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pwd :"
                + String.valueOf(this.vue.getNewPwd().getPassword()) + "pwd2 : " +
                String.valueOf(this.vue.getNewConfirmPwd().getPassword()));
        if (e.getSource() == this.vue.getAnnuler()) {
            resetPwdField();
        } else if (e.getSource() == this.vue.getConfirmer()) {
            if (String.valueOf(this.vue.getNewPwd().getPassword()).
                    equals(String.valueOf(this.vue.getNewConfirmPwd().getPassword())) == false) {
                resetPwdField();
                JOptionPane.showMessageDialog(null,
                        "Les mots de passe ne correspondent pas",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                this.user.setU_pwd(String.valueOf(this.vue.getNewPwd().getPassword()));
                this.userDAO.update(this.user);
                this.vue.dispose();
            }
        }
    }

    private void resetPwdField() {
        this.vue.getNewPwd().setText("");
        this.vue.getNewConfirmPwd().setText("");
    }
}
