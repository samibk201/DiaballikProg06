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

    public InterfaceAcceul acceuil;
    public InterfacePlateau jeu;
    public InterfaceLevel levelIA;
    InterfaceGameSetIA gameSetIA;


    InterfaceJeu() {
        super();
    }

    public void init() {
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setBackground(new Color(53, 79, 82));

        acceuil = new InterfaceAcceul();
        acceuil.init();

        jeu = new InterfacePlateau();
        jeu.init();

        gameSetIA = new InterfaceGameSetIA();
        gameSetIA.init();

        levelIA = new InterfaceLevel();
        levelIA.init();

        acceuil.unJoueur.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
               setOnTop(jeu);
            }  
        });

        acceuil.deuxJoueur.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
               setOnTop(gameSetIA);
            }  
        });

        gameSetIA.next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                setOnTop(levelIA);
            }
        });


        this.add(acceuil, new Integer(0), 0);
        this.add(jeu, new Integer(0), 1);
        this.add(levelIA, new Integer(0), 2);
        this.add(gameSetIA, new Integer(0), 3);
    }

    public void setOnTop(Component panel) {
        this.moveToFront(panel);
    }


}
