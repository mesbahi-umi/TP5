package org.example.Presentation.Views;

import javax.swing.*;
import java.awt.*;


public class HomeFrame extends JFrame {


    /* menu*/
    JMenuBar menuBar;
    JMenu gestionMenu ;
    JMenuItem ajouterMenuItem;
    JMenuItem supprimerMenuItem;
    JMenuItem modifierMenuItem;
    JMenuItem afficherMenuItem;
    JMenuItem quitterMenuItem;
    JLabel label;
    public HomeFrame() {
        // Set up the window
        setTitle("Gestion d' adherents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 450); // Adjust the size as needed


        menuBar = new JMenuBar();
        gestionMenu = new JMenu("Menu");
        ajouterMenuItem = new JMenuItem("Ajouter");
        supprimerMenuItem = new JMenuItem("Supprimer");
        modifierMenuItem = new JMenuItem("Modifier");
        afficherMenuItem = new JMenuItem("Afficher");
        quitterMenuItem = new JMenuItem("Quitter");

        label = new JLabel("TP5 : Gestion d' adherents Avec Swing et JDBC");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setForeground(Color.BLUE);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        /* menu configuration*/
        gestionMenu.add(ajouterMenuItem);
        gestionMenu.add(supprimerMenuItem);
        gestionMenu.add(modifierMenuItem);
        gestionMenu.add(afficherMenuItem);
        gestionMenu.add(quitterMenuItem);
        menuBar.add(gestionMenu);
        /* set actions to items */

        ajouterMenuItem.addActionListener(e -> {
            setVisible(false);
            AddAdherentFrame dialogFrame = new AddAdherentFrame("Ajouter Adherent", this);
        });
        afficherMenuItem.addActionListener(e -> {
            setVisible(false);
            ShowAllAdherentFrame showAllAdherentFrame = new ShowAllAdherentFrame("Afficher Adherents", this);
        });
        supprimerMenuItem.addActionListener(e -> {
            setVisible(false);
            DeleteAdherentFrame deleteAdherentFrame = new DeleteAdherentFrame("Supprimer Adherent", this);
        });


        quitterMenuItem.addActionListener(e -> {
            // show confirmation dialog
            int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        setJMenuBar(menuBar);

        // Center the window and make it visible
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new HomeFrame();
    }

}