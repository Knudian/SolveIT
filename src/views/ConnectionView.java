/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.ConnectionViewController;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Maniak
 */
public class ConnectionView extends JFrame implements Observer {

    private JPanel panNorth, panMain, panVide, panSouth;
    private JLabel loginLabel, passwordLabel, titleConnection;
    private JButton connectionButton;
    private JTextField loginTextfield;
    private JPasswordField passwordTextfield;
    private ConnectionViewController con;

    public ConnectionView(ConnectionViewController con) {
        this.con = con;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 230);
        this.setTitle("Solve-IT");
        this.setLocationRelativeTo(null);
        this.initComposant();
        this.setVisible(true);
    }

    private void initComposant() {

        // ------------------------------------------------ //
        // -------------- PANNEAU CENTRAL ----------------- //
        // ------------------------------------------------ //
        panNorth = new JPanel();
        panNorth.setBackground(Color.WHITE);
        panNorth.setPreferredSize(new Dimension(500, 50));
        titleConnection = new JLabel("CONNEXION");
        titleConnection.setFont(new java.awt.Font("Bold", 1, 20));
        panNorth.add(titleConnection);

        // ------------------------------------------------ //
        // -------------- PANNEAU CENTRAL ----------------- //
        // ------------------------------------------------ //
        JPanel grid = new JPanel(new GridLayout(3, 2, 5, 25));
        grid.setBackground(Color.WHITE);
        panMain = new JPanel();
        panMain.setBackground(Color.WHITE);
        loginLabel = new JLabel("Entrez votre login : ");
        loginLabel.setFont(new java.awt.Font("Bold", 1, 18));
        loginTextfield = new JTextField(15);
        passwordLabel = new JLabel("Entrez votre password : ");
        passwordLabel.setFont(new java.awt.Font("Bold", 1, 18));
        passwordTextfield = new JPasswordField(15);

        connectionButton = new JButton("Je me connecte");
        connectionButton.setPreferredSize(new Dimension(160, 35));
        connectionButton.setFont(new java.awt.Font("Bold", 1, 16));
        connectionButton.addActionListener(this.con);
        panVide = new JPanel();
        panVide.setBackground(Color.white);

        // ------------------------------------------------ //
        // ----------------- PANNEAU SUD ------------------ //
        // ------------------------------------------------ //
        panSouth = new JPanel();
        panSouth.setBackground(Color.WHITE);
        panSouth.add(connectionButton);

        grid.add(loginLabel);
        grid.add(loginTextfield);
        grid.add(passwordLabel);
        grid.add(passwordTextfield);
        grid.add(panVide);
        panMain.add(grid);

        this.getContentPane().add(panNorth, BorderLayout.NORTH);
        this.getContentPane().add(panMain, BorderLayout.CENTER);
        this.getContentPane().add(panSouth, BorderLayout.SOUTH);

    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub

    }

    public JButton getConnectionButton() {
        return connectionButton;
    }

    public JTextField getLoginTextfield() {
        return loginTextfield;
    }

    public JPasswordField getPasswordTextfield() {
        return passwordTextfield;
    }

    public void erreurLoginPwd() {
        JOptionPane.showMessageDialog(null, "login/pwd invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}
