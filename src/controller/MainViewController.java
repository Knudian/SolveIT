/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.beans.User;
import views.MainView;

/**
 *
 * @author Maniak
 */
public class MainViewController implements ActionListener {
    
    private User user;
    private MainView vue;

    public MainViewController(User user) {
        this.user = user;
        this.vue = new MainView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
