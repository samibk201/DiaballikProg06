package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

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


public class GameSetIA extends JFrame{

    JLabel title;
    Button name;
    Button avatar;
    Button color; 
    Button plateau;

    ButtonGroup bgPlat;
	public JRadioButton standard;
    public JRadioButton melange;

    ButtonGroup bgAvatar;
    public JRadioButton a1;
    public JRadioButton a2;
    public JRadioButton a3;

    ButtonGroup bgColor;
    ButtonGroup bgColorW;
    ButtonGroup bgColorB;
    public JRadioButton white;
    public JRadioButton black;


    public Button next; 
    public Button back;
    public Button volum;

    GameSetIA(){
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
        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(10);
        name = new Button("ressources/ButtonImage/button1.png","Nom du joueur : ");
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.Y_AXIS));
        panelName.setOpaque(false);
        panelName.setAlignmentX(panelPlato.getAlignmentX());
        panelName.setOpaque(false);
        panelName.add(name);
        JPanel flowName = new JPanel();
        flowName.setLayout(new FlowLayout());
        flowName.setOpaque(false);
        flowName.add(nameField);
        panelName.add(flowName);


        // Choix avatar
        JLabel panda = new JLabel();
        panda.setIcon(new ImageIcon("ressources/Avatars/panda.png"));
        JLabel pirate = new JLabel();
        pirate.setIcon(new ImageIcon("ressources/Avatars/pirate.jpg"));
        JLabel armure = new JLabel();
        armure.setIcon(new ImageIcon("ressources/Avatars/armure.png"));

        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new BoxLayout(panelAvatar, BoxLayout.Y_AXIS));
        panelAvatar.setAlignmentX(panelPlato.getAlignmentX());
        panelAvatar.setOpaque(false);
        avatar = new Button("ressources/ButtonImage/button1.png","Avatar du joueur : ");
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.bgAvatar = new ButtonGroup();
        this.a1 = new JRadioButton("");
        this.a2 = new JRadioButton("");
        this.a3 = new JRadioButton("");
        a1.setSelected(true);
        bgAvatar.add(a1);
        bgAvatar.add(a2);
        bgAvatar.add(a3);
        panelAvatar.add(avatar);
        JPanel flowAv = new JPanel();
        flowAv.setLayout(new FlowLayout());
        flowAv.setOpaque(false);
        flowAv.add(a1);
        flowAv.add(panda);
        flowAv.add(a2);
        flowAv.add(pirate);
        flowAv.add(a3);
        flowAv.add(armure);
        panelAvatar.add(flowAv);

        
        // Choix couleur pions
        JLabel whiteS = new JLabel();
        whiteS.setIcon(new ImageIcon("ressources/Avatars/whiteSquare.png"));
        JLabel blackS = new JLabel();
        blackS.setIcon(new ImageIcon("ressources/Avatars/blackSquare.png"));

        JPanel panelColor = new JPanel();
        panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.Y_AXIS));
        panelColor.setOpaque(false);
        color = new Button("ressources/ButtonImage/button1.png","Couleur des pions : ");
        color.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("");
        this.black = new JRadioButton("");
        this.bgColorB = new ButtonGroup();
        this.bgColorW = new ButtonGroup();
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        JPanel flowCol = new JPanel();
        flowCol.setLayout(new FlowLayout());
        flowCol.setOpaque(false);
        flowCol.add(white);
        flowCol.add(whiteS);
        flowCol.add(black);
        flowCol.add(blackS);
        panelColor.add(flowCol);


        // Box principale
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);
        box.add(panelPlato);
        box.add(panelName);
        box.add(panelAvatar);
        box.add(panelColor);

        JPanel bigBox = new JPanel();
        bigBox.setLayout(new BorderLayout());
        bigBox.add(box, BorderLayout.CENTER);
        bigBox.setOpaque(false);


        // Boutons
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new FlowLayout());
        panelBut.setOpaque(false);
        next = new Button("ressources/ButtonImage/nextSR.png");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBut.add(next);

        
        // Panel principal
	    JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(bigBox, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
        next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                LevelIA levelIA = new LevelIA();
                levelIA.init(frame.getWidth(), frame.getHeight());
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
        Joueur j2 = new Joueur(2, "Ordinateur");

        
        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }    
}
