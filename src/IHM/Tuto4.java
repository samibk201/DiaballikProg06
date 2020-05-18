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


public class Tuto4 extends JFrame{

    JTextArea text;

    JLabel title;

    Button next;
    Button prev;
    Button home;
    Button volum;
    
    Tuto4(){
        super();
    }

    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());

        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bg.png");
        

        // Panel nord bouton retour + son
        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        home = new Button("ressources/ButtonImage/homeBSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(home);
        navig.add(volum);


        // Panel text
        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout());
        flowText.setOpaque(false);

        text = new JTextArea(" Un pion peut se déplacer uniquement \n orthogonalement et une case "+
                            "à la fois. \n Un pion avec une balle ne peut pas bouger.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
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
        plateau.setIcon(new ImageIcon("ressources/TutoImage/tuto4.png"));

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
        next = new Button("ressources/ButtonImage/nextSR.png");
        prev = new Button("ressources/ButtonImage/previousSR.png");
        panelBut.add(next, BorderLayout.EAST);
        panelBut.add(prev, BorderLayout.WEST);
   
        
        // Remplissage panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(navig, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);
        

        // Clicks
        // Click bouton suivant
        next.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextClik.png"));
            }
            public void mouseExited(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto5 tuto5 = new Tuto5();
                tuto5.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Click bouton précédent
        prev.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/prevClik.png"));
            }
            public void mouseExited(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/previousSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto3 tuto3 = new Tuto3();
                tuto3.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Click bouton menu
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
