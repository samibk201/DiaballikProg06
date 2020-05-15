package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Moteur.Joueur;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameSetJ extends JFrame{

    JLabel title;
    Button name;
    Button avatar;
    Button color;
    Button plateau;

    ButtonGroup bgPlat;
    public JRadioButton standard;
    public JRadioButton melange;

    ButtonGroup bgAvatar1;
    ButtonGroup bgAvatar2;
    public JRadioButton a1j1;
    public JRadioButton a2j1;
    public JRadioButton a3j1;
    public JRadioButton a1j2;
    public JRadioButton a2j2;
    public JRadioButton a3j2;

    ButtonGroup bgColor;
    ButtonGroup bgColor2;
    ButtonGroup bgColorW;
    ButtonGroup bgColorB;
    public JRadioButton white;
    public JRadioButton black;
    public JRadioButton white2;
    public JRadioButton black2;


    public Button start; 
    public Button back;
    public Button volum;

    GameSetJ(){
        super();
    }

    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());

        // Background
        Background background = new Background();
        background.Background(frame);
        
        
        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(back);
        navig.add(volum);

        title = new JLabel();
        title.setIcon(new ImageIcon("ressources/Titles/paramTitle.png"));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        // Panel navig + titre
        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.setOpaque(false);
        boxNT.add(navig);
        boxNT.add(title);


        // Choix plateau
        JPanel panelPlato = new JPanel();
        panelPlato.setLayout(new BoxLayout(panelPlato, BoxLayout.Y_AXIS));
        panelPlato.setOpaque(false);
        plateau = new Button("ressources/ButtonImage/button1.png","Configuration du plateau : ");
        plateau.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.bgPlat = new ButtonGroup();
        this.standard = new JRadioButton("Plateau standard");
        this.melange = new JRadioButton("Plateau mélangé");
        standard.setSelected(true);
        bgPlat.add(standard);
        bgPlat.add(melange);
        panelPlato.add(plateau);
        JPanel flowPlato = new JPanel();
        flowPlato.setLayout(new FlowLayout());
        flowPlato.setOpaque(false);
        flowPlato.add(standard);
        flowPlato.add(melange);
        panelPlato.add(flowPlato);


        // Nom joueur
        Button circle1N = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2N = new Button("ressources/ButtonImage/circleR.png", "J2");

        JTextField nameField = new JTextField("Joueur1");
        JTextField nameField2 = new JTextField("Joueur2");
        nameField.setColumns(10);
        nameField2.setColumns(10);
        name = new Button("ressources/ButtonImage/button1.png","Nom des joueurs : ");
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.Y_AXIS));
        panelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelName.setOpaque(false);
        panelName.add(name);
        JPanel flowName1 = new JPanel();
        flowName1.setLayout(new FlowLayout());
        flowName1.setOpaque(false);
        flowName1.add(circle1N);
        flowName1.add(nameField);
        JPanel flowName2 = new JPanel();
        flowName2.setLayout(new FlowLayout());
        flowName2.setOpaque(false);
        flowName2.add(circle2N);
        flowName2.add(nameField2);
        panelName.add(flowName1);
        panelName.add(flowName2);


        // Choix avatar
        JLabel panda = new JLabel();
        panda.setIcon(new ImageIcon("ressources/Avatars/panda.png"));
        JLabel pirate = new JLabel();
        pirate.setIcon(new ImageIcon("ressources/Avatars/pirate.jpg"));
        JLabel armure = new JLabel();
        armure.setIcon(new ImageIcon("ressources/Avatars/armure.png"));

        JLabel panda2 = new JLabel();
        panda2.setIcon(new ImageIcon("ressources/Avatars/panda.png"));
        JLabel pirate2 = new JLabel();
        pirate2.setIcon(new ImageIcon("ressources/Avatars/pirate.jpg"));
        JLabel armure2 = new JLabel();
        armure2.setIcon(new ImageIcon("ressources/Avatars/armure.png"));

        Button circle1A = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2A = new Button("ressources/ButtonImage/circleR.png", "J2");
        //circle2A.setAlignmentX(circle2N.getX());

        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new BoxLayout(panelAvatar, BoxLayout.Y_AXIS));
        panelAvatar.setOpaque(false);
        avatar = new Button("ressources/ButtonImage/button1.png","Avatar des joueurs : ");
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.bgAvatar1 = new ButtonGroup();
        this.a1j1 = new JRadioButton("");
        this.a2j1 = new JRadioButton("");
        this.a3j1 = new JRadioButton("");
        this.bgAvatar2 = new ButtonGroup();
        this.a1j2 = new JRadioButton("");
        this.a2j2 = new JRadioButton("");
        this.a3j2 = new JRadioButton("");
        a1j1.setSelected(true);
        bgAvatar1.add(a1j1);
        bgAvatar1.add(a2j1);
        bgAvatar1.add(a3j1);
        panelAvatar.add(avatar);
        JPanel flowAv = new JPanel();
        flowAv.setLayout(new FlowLayout());
        flowAv.setOpaque(false);
        flowAv.add(circle1A);
        flowAv.add(a1j1);
        flowAv.add(panda);
        flowAv.add(a2j1);
        flowAv.add(pirate);
        flowAv.add(a3j1);
        flowAv.add(armure);
        bgAvatar2.add(a1j2);
        bgAvatar2.add(a2j2);
        bgAvatar2.add(a3j2);
        a1j2.setSelected(true);
        JPanel flowAv2 = new JPanel();
        flowAv2.setLayout(new FlowLayout());
        flowAv2.setOpaque(false);
        flowAv2.add(circle2A);
        flowAv2.add(a1j2);
        flowAv2.add(panda2);
        flowAv2.add(a2j2);
        flowAv2.add(pirate2);
        flowAv2.add(a3j2);
        flowAv2.add(armure2);
        panelAvatar.add(flowAv);
        panelAvatar.add(flowAv2);

        
        // Choix couleur pions
        JLabel whiteS = new JLabel();
        whiteS.setIcon(new ImageIcon("ressources/Avatars/whiteSquare.png"));
        JLabel blackS = new JLabel();
        blackS.setIcon(new ImageIcon("ressources/Avatars/blackSquare.png"));
        JLabel whiteS2 = new JLabel();
        whiteS2.setIcon(new ImageIcon("ressources/Avatars/whiteSquare.png"));
        JLabel blackS2 = new JLabel();
        blackS2.setIcon(new ImageIcon("ressources/Avatars/blackSquare.png"));

        Button circle1C = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2C = new Button("ressources/ButtonImage/circleR.png", "J2");

        JPanel panelColor = new JPanel();
        panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.Y_AXIS));
        panelColor.setOpaque(false);
        color = new Button("ressources/ButtonImage/button1.png","Couleur des pions : ");
        color.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("");
        this.black = new JRadioButton("");
        this.bgColor2 = new ButtonGroup();
        this.white2 = new JRadioButton("");
        this.black2 = new JRadioButton("");
        this.bgColorB = new ButtonGroup();
        this.bgColorW = new ButtonGroup();
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        JPanel flowCol = new JPanel();
        flowCol.setLayout(new FlowLayout());
        flowCol.setOpaque(false);
        flowCol.add(circle1C);
        flowCol.add(white);
        flowCol.add(whiteS);
        flowCol.add(black);
        flowCol.add(blackS);
        black2.setSelected(true);
        bgColor2.add(white2);
        bgColor2.add(black2);
        JPanel flowCol2 = new JPanel();
        flowCol2.setLayout(new FlowLayout());
        flowCol2.setOpaque(false);
        flowCol2.add(circle2C);
        flowCol2.add(white2);
        flowCol2.add(whiteS2);
        flowCol2.add(black2);
        flowCol2.add(blackS2);
        panelColor.add(flowCol);
        panelColor.add(flowCol2);


        // Box principale
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);
        box.add(panelPlato);
        box.add(panelAvatar);
        box.add(panelName);
        box.add(panelColor);

        JPanel bigBox = new JPanel();
        bigBox.setLayout(new BorderLayout());
        bigBox.add(box, BorderLayout.CENTER);
        bigBox.setOpaque(false);

        // Boutons
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new FlowLayout());
        panelBut.setOpaque(false);
        start = new Button("ressources/ButtonImage/startSR.png");
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBut.add(start);

        
        // Panel principal        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(bigBox, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);
        

        // Clicks
        start.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                FenetrePartie fenetrePartie = new FenetrePartie();
                fenetrePartie.run();
                frame.dispose();
            }
        });

        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                InterfaceGraphique mainMenu = new InterfaceGraphique();
                mainMenu.run();
                frame.dispose();
            }
        });
        
        
        // Gestion entrées joueurs
        Joueur j1 = new Joueur(1, nameField.getText());
        Joueur j2 = new Joueur(2, nameField2.getText());


        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }    
}
