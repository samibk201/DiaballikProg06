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

public class Tuto2 extends JFrame{

    JTextArea text;

    Button next;
    Button prev;
    Button home;
    Button volum;
    
    Tuto2(){
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

        text = new JTextArea(" Une partie se joue à 2. \n On peut commencer la partie selon "+
                                "deux configurations : \n     - tous les pions d'un joueur sont devant lui \n"+
                                "     - deux pions sont placés dans le camp adverse \n" +
                                " La balle est placée sur le pion centrale.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        flowText.add(text);

        JLabel prof = new JLabel();
        prof.setIcon(new ImageIcon("ressources/Theme/prof.png"));

        JPanel profTxt = new JPanel();
        profTxt.setLayout(new FlowLayout());
        profTxt.setOpaque(false);
        profTxt.add(prof);
        profTxt.add(flowText);


        // Chargement image plateau
        JLabel plateau = new JLabel();
        plateau.setIcon(new ImageIcon("ressources/TutoImage/tuto2.png"));

        JPanel flowPla = new JPanel();
        flowPla.setLayout(new FlowLayout());
        flowPla.setOpaque(false);
        flowPla.add(plateau);

        // Box text+plateaux
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
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
        next.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextClik.png"));
            }
            public void mouseExited(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto3 tuto3 = new Tuto3();
                tuto3.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        prev.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/prevClik.png"));
            }
            public void mouseExited(MouseEvent e){
                prev.setIcon(new ImageIcon("ressources/ButtonImage/previousSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto1 tuto1 = new Tuto1();
                tuto1.init(frame.getWidth(), frame.getHeight());
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
