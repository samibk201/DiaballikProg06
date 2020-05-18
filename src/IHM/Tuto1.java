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

public class Tuto1 extends JFrame{

    JTextArea text;

    Button next;
    Button back;
    Button volum;
    
    Tuto1(){
        super();
    }

    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());


        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bg.png");

        // Panel nord boutton retour+son
        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(back);
        navig.add(volum);

        
        // Panel text
        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowText.setOpaque(false);

        this.text = new JTextArea(" Pour avancer, il suffit de cliquer sur le pion \n puis sur la case "+
                                    "où on veut le déplacer. \n Pour faire une passe on clique \n sur le "+
                                    "pion qui a la balle, \n puis sur celui à qui on veut donner la balle.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 2);
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
       plateau.setIcon(new ImageIcon("ressources/TutoImage/tuto1.png"));

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
        JPanel panelNext = new JPanel();
        panelNext.setLayout(new BorderLayout());
        panelNext.setOpaque(false);
        next = new Button("ressources/ButtonImage/nextSR.png");
        panelNext.add(next, BorderLayout.EAST);
       
        
        // Remplissage panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(navig, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);
        panel.add(panelNext, BorderLayout.SOUTH);


        // Clicks
        // Click suivant
        next.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextClik.png"));
            }
            public void mouseExited(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto2 tuto2 = new Tuto2();
                tuto2.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });
        // click retour
        back.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backCLicked.png"));
            }
            public void mouseExited(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backSR.png"));
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
