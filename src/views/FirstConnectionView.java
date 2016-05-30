/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.FirstConnectionViewController;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.beans.User;

/**
 *
 * @author Yoanns
 */
public class FirstConnectionView extends JFrame implements Observer {

    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel labelTitre, labelPwd, labelConfirmPwd;
    private JPasswordField newPwd, newConfirmPwd;
    private JButton annuler, confirmer;

    public FirstConnectionView(FirstConnectionViewController controller) {
        this.setSize(600, 200);
        this.setAlwaysOnTop(true);
        initComposant(controller);
        this.setVisible(true);
    }

    private void initComposant(FirstConnectionViewController controller) {

        // MISE EN PLACE DES PANELS
        // PANEL EN-TETE
        this.panelNorth = new JPanel();
        this.labelTitre = new JLabel("MODIFICATION DU PASSWORD");
        this.panelNorth.add(this.labelTitre);

        // PANEL CENTRE
        this.panelCenter = new JPanel(new GridLayout(2, 2, 5, 5));

        this.labelPwd = new JLabel("Entrez votre nouveau password : ");
        this.newPwd = new JPasswordField(15);
        this.labelConfirmPwd = new JLabel("Confirmez votre nouveau password : ");
        this.newConfirmPwd = new JPasswordField(15);

        this.panelCenter.add(this.labelPwd);
        this.panelCenter.add(this.newPwd);
        this.panelCenter.add(this.labelConfirmPwd);
        this.panelCenter.add(this.newConfirmPwd);

        // PANEL SUD
        this.panelSouth = new JPanel(new GridLayout(1, 2, 5, 5));
        this.annuler = new JButton("Annuler");
        this.annuler.addActionListener(controller);
        this.confirmer = new JButton("Confirmer");
        this.confirmer.addActionListener(controller);

        this.panelSouth.add(this.annuler);
        this.panelSouth.add(this.confirmer);

        // AJOUT DES PANELS AU CONTENT PANE
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(this.panelNorth);
        this.getContentPane().add(this.panelCenter);
        this.getContentPane().add(this.panelSouth);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Exception) {
            Exception e = (Exception) arg;
            JOptionPane.showMessageDialog(this, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        // A VERIFIER MAIS PAS SUR DU TOUT LA....
        else if (arg instanceof User) {
            this.newPwd.setText("");
            this.newConfirmPwd.setText("");
        }
    }

    public JPasswordField getNewPwd() {
        return newPwd;
    }

    public JPasswordField getNewConfirmPwd() {
        return newConfirmPwd;
    }

    public JButton getAnnuler() {
        return annuler;
    }

    public JButton getConfirmer() {
        return confirmer;
    }

}
