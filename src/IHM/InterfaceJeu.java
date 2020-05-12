package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JComponent;


public class InterfaceJeu extends JLayeredPane {

    public InterfaceAccueil acceuil;
    public InterfaceLevel levelIA;
    public InterfaceGameSetIA gameSetIA;
    public InterfaceGameSetJ gameSetJ;
    public InterfaceTuto tuto;
    public InterfaceTuto2 tuto2;
    public InterfaceTuto3 tuto3;
    public InterfaceTuto4 tuto4;
    public InterfaceTuto5 tuto5;


    InterfaceJeu() {
        super();
    }

    public void init() {
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setBackground(new Color(53, 79, 82));

        // Initialisation des fenêtres

        acceuil = new InterfaceAccueil();
        acceuil.init();

        gameSetIA = new InterfaceGameSetIA();
        gameSetIA.init();

        gameSetJ = new InterfaceGameSetJ();
        gameSetJ.init();

        levelIA = new InterfaceLevel();
        levelIA.init();

        tuto = new InterfaceTuto();
        tuto.init();
        
        tuto2 = new InterfaceTuto2();
        tuto2.init();

        tuto3 = new InterfaceTuto3();
        tuto3.init();

        tuto4 = new InterfaceTuto4();
        tuto4.init();

        tuto5 = new InterfaceTuto5();
        tuto5.init();

        acceuil.setVisible(true);
        gameSetIA.setVisible(false);
        gameSetJ.setVisible(false);
        levelIA.setVisible(false);
        tuto.setVisible(false);
        tuto2.setVisible(false);
        tuto3.setVisible(false);
        tuto4.setVisible(false);
        tuto5.setVisible(false);

        // Gestion des clicks
        acceuil.unJoueur.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e){
                gameSetJ.setVisible(true);  
                gameSetIA.setVisible(false);
                acceuil.setVisible(false);
                levelIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }  
        });

        acceuil.deuxJoueur.addMouseListener(new MouseAdapter(){  
            public void mouseClicked(MouseEvent e){  
               gameSetIA.setVisible(true);
               gameSetIA.setVisible(false);
               acceuil.setVisible(false);
               levelIA.setVisible(false);
               tuto.setVisible(false);
               tuto2.setVisible(false);
               tuto3.setVisible(false);
               tuto4.setVisible(false);
               tuto5.setVisible(false);
            }  
        });

        gameSetIA.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                levelIA.setVisible(true);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        acceuil.tutoriel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });
        
        tuto.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto2.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto2.previous.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto2.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto3.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto3.previous.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto2.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto3.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto4.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto4.previous.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto3.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto4.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        tuto4.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto5.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto4.setVisible(false);
            }
        });

        tuto5.previous.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tuto4.setVisible(true);
                levelIA.setVisible(false);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
                gameSetIA.setVisible(false);
                tuto.setVisible(false);
                tuto2.setVisible(false);
                tuto3.setVisible(false);
                tuto5.setVisible(false);
            }
        });

        

        this.add(acceuil);
        this.add(levelIA);
        this.add(gameSetIA);
        this.add(gameSetJ);
        this.add(tuto);
        this.add(tuto2);
        this.add(tuto3);
        this.add(tuto4);
        this.add(tuto5);
    }
}
