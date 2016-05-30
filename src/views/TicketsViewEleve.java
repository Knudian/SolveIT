/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.TicketsViewEleveController;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Maniak
 */

public class TicketsViewEleve extends JPanel{

    private JButton voir, etat;
    private JPanel gridPan, rightPan, panVide, panVide1, panVide2;
    private JLabel titre, commCourt, commlong, dateAuteur;
    
    public TicketsViewEleve () {
        initComposant();
        this.setVisible(true);
        
    }

    private void initComposant() {
        gridPan = new JPanel(new GridLayout(3,1,5,5));
        gridPan.setBackground(Color.WHITE);
        
        titre = new JLabel("Titre du ticket");
        commCourt = new JLabel("Commentaire court du ticket");
        dateAuteur = new JLabel("30/05/2016, Maniak");
        
        gridPan.add(titre);
        gridPan.add(commCourt);
        gridPan.add(dateAuteur);
        
        rightPan = new JPanel(new GridLayout(5,1,5,5));
        rightPan.setBackground(Color.WHITE);
        panVide = new JPanel();
        panVide.setBackground(Color.WHITE);
        panVide1 = new JPanel();
        panVide1.setBackground(Color.WHITE);
        panVide2 = new JPanel();
        panVide2.setBackground(Color.WHITE);
        
        etat = new JButton();
        etat.setEnabled(false);
        etat.setBackground(Color.GREEN);
        voir = new JButton("Voir");
        
        rightPan.add(etat);
        rightPan.add(panVide);
        rightPan.add(panVide1);
        rightPan.add(panVide2);
        rightPan.add(voir);
        
        this.setLayout(new BorderLayout());
        this.setBorder(new BevelBorder(1));
        this.add(gridPan, BorderLayout.CENTER);
        this.add(rightPan, BorderLayout.EAST);
        
    }
    
}
