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


    InterfaceJeu() {
        super();
    }

    public void init() {
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setBackground(new Color(53, 79, 82));

        acceuil = new InterfaceAccueil();
        acceuil.init();

        gameSetIA = new InterfaceGameSetIA();
        gameSetIA.init();

        levelIA = new InterfaceLevel();
        levelIA.init();

        acceuil.unJoueur.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e){  
                gameSetIA.setVisible(true);
                acceuil.setVisible(false);
                levelIA.setVisible(false);
            }  
        });

        acceuil.deuxJoueur.addMouseListener(new MouseAdapter(){  
            public void mouseClicked(MouseEvent e){  
               gameSetIA.setVisible(true);
               acceuil.setVisible(false);
               levelIA.setVisible(false);
            }  
        });

        gameSetIA.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                levelIA.setVisible(true);
                acceuil.setVisible(false);
                gameSetIA.setVisible(false);
            }
        });


        this.add(acceuil, new Integer(0), 0);
        this.add(levelIA, new Integer(0), 1);
        this.add(gameSetIA, new Integer(0), 2);
    }

    /*public void setOnTop(Component panel) {
        this.moveToFront(panel);
    }*/


}
