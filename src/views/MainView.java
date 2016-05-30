/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.MainViewController;
import controller.TicketsViewEleveController;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Maniak
 */
public class MainView extends JFrame {

    private MainViewController mvc;
    private ArrayList<String> filtresCategories;
    private ArrayList<JCheckBox> mesCategories;
    private JButton newProblem;
    private JLabel statuts, categories;
    private JCheckBox mesTickets, allTickets;
    private JRadioButton tous, nonLus, lus, enCours, resolus;
    private ButtonGroup group1, group2;
    private JPanel westPan, mainPan, filtersPan;
    private TicketsViewEleve panTicket = new  TicketsViewEleve();

    public MainView(MainViewController mvc) {
        this.mvc = mvc;
        panTicket = panTicket;
        this.setTitle("Solve-IT : no more problems");
        this.setSize(1100, 750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComposant();
        this.setVisible(true);

    }

    private void initComposant() {

        //------------------ PANNEAU DE GAUCHE ---------------------//
        //----------------------------------------------------------//
        westPan = new JPanel();
        westPan.setBackground(Color.WHITE);
        westPan.setPreferredSize(new Dimension(250, 450));

        //------------------- BOUTON NOUVEAU TICKET ----------------//
        newProblem = new JButton("NOUVEAU TICKET");
        newProblem.setPreferredSize(new Dimension(200, 40));

        //------------------- FILTRES GROUPE 1 ---------------------//
        mesTickets = new JCheckBox("Mes Tickets");
        mesTickets.setBackground(Color.WHITE);
        allTickets = new JCheckBox("Tous");
        allTickets.setBackground(Color.WHITE);
        group1 = new ButtonGroup();
        group1.add(mesTickets);
        group1.add(allTickets);

        //------------------- LABEL SEPARATION ---------------------//
        statuts = new JLabel("STATUTS", SwingConstants.CENTER);
        statuts.setFont(new java.awt.Font("Bold", 1, 15));
        statuts.setForeground(Color.BLUE);

        //--------------------- GROUPE STATUT ---------------------//
        tous = new JRadioButton("Tous");
        tous.setBackground(Color.WHITE);
        nonLus = new JRadioButton("Non Lus");
        nonLus.setBackground(Color.WHITE);
        lus = new JRadioButton("Lus");
        lus.setBackground(Color.WHITE);
        enCours = new JRadioButton("En Cours");
        enCours.setBackground(Color.WHITE);
        resolus = new JRadioButton("Résolus");
        resolus.setBackground(Color.WHITE);
        group2 = new ButtonGroup();
        group2.add(tous);
        group2.add(nonLus);
        group2.add(lus);
        group2.add(enCours);
        group2.add(resolus);

        //------------------- LABEL SEPARATION 2 -------------------//
        categories = new JLabel("CATEGORIES", SwingConstants.CENTER);
        categories.setFont(new java.awt.Font("Bold", 1, 15));
        categories.setForeground(Color.BLUE);

        //------------------- GROUPE DE CATEGORIES -----------------//
        filtersPan = new JPanel(new GridLayout(20, 1, 1, 1));
        filtersPan.setBackground(Color.WHITE);
        filtersPan.setPreferredSize(new Dimension(200, 550));
        filtersPan.setBorder(new TitledBorder(null, "FILTRES"));
        filtersPan.add(mesTickets);
        filtersPan.add(allTickets);
        filtersPan.add(statuts);
        filtersPan.add(tous);
        filtersPan.add(nonLus);
        filtersPan.add(lus);
        filtersPan.add(enCours);
        filtersPan.add(resolus);
        filtersPan.add(categories);

        mesCategories = recupCheckBox();
        for (int i = 0; i < mesCategories.size(); i++) {
            filtersPan.add(mesCategories.get(i));
            mesCategories.get(i).setBackground(Color.WHITE);
        }

        westPan.add(newProblem);
        westPan.add(filtersPan);

        
        //------------------ PANNEAU CENTRAL  ---------------------//
        //---------------------------------------------------------//
        mainPan = new JPanel();
        mainPan.setBackground(Color.WHITE);
        mainPan.setBorder(new TitledBorder(null, "LISTE DES TICKETS"));
        mainPan.add(panTicket);
               
        
        this.getContentPane().add(westPan, BorderLayout.WEST);
        this.getContentPane().add(mainPan, BorderLayout.CENTER);

    }

    public JButton getNewProblem() {
        return newProblem;
    }

    // Méthode d'ajout de checkbox temporaire
    public ArrayList recupCheckBox() {
        ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

        filtresCategories = new ArrayList<>();
        filtresCategories.add("bob");
        filtresCategories.add("bobby");
        filtresCategories.add("bobbinou");

        for (int i = 0; i < filtresCategories.size(); i++) {
            checkBoxList.add(new JCheckBox((String) filtresCategories.get(i)));
        }
        return checkBoxList;
    }

}
