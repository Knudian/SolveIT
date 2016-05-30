package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Maniak
 */

public class NewPasswordView extends JPanel {
    private JPanel north, main, south;
    private JLabel titre,newPassword, confirmNewPassword;
    private JTextField newTextfieldPassword, newConfirmTextfieldPassword;
    
    public NewPasswordView() {
        this.setSize(400,300);
        initComposant();
        this.setVisible(true);
    }
    
    public void initComposant() {
        north = new JPanel();
        titre = new JLabel("MODIFICATION DU PASSWORD");
        north.add(titre);
        
        main = new JPanel(new GridLayout(2,2,5,5));
 
        newPassword = new JLabel("Entrez votre nouveau password : ");
        newTextfieldPassword = new JTextField(15);
        confirmNewPassword = new JLabel("Confirmez votre nouveau password : ");
        newConfirmTextfieldPassword = new JTextField(15);
                
        main.add(newPassword);
        main.add(newTextfieldPassword);
        main.add(confirmNewPassword);
        main.add(newConfirmTextfieldPassword);
            
       
        this.setLayout(new BorderLayout(5,5));
        this.add(north, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
    }

    public JTextField getNewTextfieldPassword() {
        return newTextfieldPassword;
    }

    public JTextField getNewConfirmTextfieldPassword() {
        return newConfirmTextfieldPassword;
    }
    
    
    
    
    
}
