package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tuto6 extends JFrame{

    JTextArea text;

    JLabel title;

    Button prev;
    Button home;
    Button volum;
    
    Tuto6(){
        super();
    }

    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());

        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bg.png");
        

        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        home = new Button("ressources/ButtonImage/homeBSR.png");
        volum = new Button("ressources/ButtonImage/sound.png");
        navig.add(home);
        navig.add(volum);


        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.setOpaque(false);
        boxNT.add(navig);


        // Panel text
        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout());
        flowText.setOpaque(false);

        text = new JTextArea(" Anti-jeu : \n Si un joueur crée une ligne infranchissable, et que \n 3 pions adverses "+
                                "se situent en face des pions de \n cette ligne, le joueur qui a constitué \n la ligne "+
                                "perd immédiatement.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        flowText.add(text);

        // Image du casque prof
        JLabel prof = new JLabel();
        prof.setIcon(new ImageIcon("ressources/Theme/prof.png"));


        // Panel caque + texte
        JPanel profTxt = new JPanel();
        profTxt.setLayout(new FlowLayout());
        profTxt.setOpaque(false);
        profTxt.add(prof);
        profTxt.add(flowText);


        // Image du plateau
        JLabel plateau = new JLabel();
        plateau.setIcon(new ImageIcon("ressources/TutoImage/tuto6.png"));

        // Panel image plateau
        JPanel flowPla = new JPanel();
        flowPla.setLayout(new FlowLayout());
        flowPla.setOpaque(false);
        flowPla.add(plateau);


        // Box text + plateau
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);
        box.add(profTxt);
        box.add(flowPla);


        // Boutons
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new BorderLayout());
        panelBut.setOpaque(false);
        prev = new Button("ressources/ButtonImage/previousSR.png");
        panelBut.add(prev, BorderLayout.WEST);
       
        
        // Remplissage panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
        prev.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/prevClik.png"));
            }
            public void mouseExited(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/previousSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto5 tuto5 = new Tuto5();
                tuto5.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        home.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeClik.png"));
            }
            public void mouseExited(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeBSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                InterfaceGraphique mainMenu = new InterfaceGraphique();
                mainMenu.run();
                frame.dispose();
            }
        });


        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
