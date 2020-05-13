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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;


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

        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(back);
        navig.add(volum);

        title = new JLabel("Paramètres de la partie");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.white);
        
        // Panel navig + titre
        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.add(navig);
        boxNT.add(title);


        // Choix plateau
        JPanel panelPlato = new JPanel();
        panelPlato.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPlato.setOpaque(false);
        plateau = new Button("ressources/ButtonImage/button1.png","Configuration du plateau : ");
        plateau.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.bgPlat = new ButtonGroup();
        this.standard = new JRadioButton("Plateau standard");
        this.melange = new JRadioButton("Plateau mélangé");
        standard.setSelected(true);
        bgPlat.add(standard);
        bgPlat.add(melange);
        panelPlato.add(plateau);
        panelPlato.add(standard);
        panelPlato.add(melange);


        // Nom joueur
        Button circle1N = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2N = new Button("ressources/ButtonImage/circleR.png", "J2");

        JTextField nameField = new JTextField("Joueur1");
        JTextField nameField2 = new JTextField("Joueur2");
        nameField.setColumns(10);
        nameField2.setColumns(10);
        name = new Button("ressources/ButtonImage/button1.png","Nom des joueurs : ");

        JPanel panelName = new JPanel();
        panelName.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelName.setOpaque(false);
        panelName.add(name);
        panelName.add(circle1N);
        panelName.add(nameField);
        panelName.add(circle2N);
        panelName.add(nameField2);


        // Choix avatar
        Button circle1A = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2A = new Button("ressources/ButtonImage/circleR.png", "J2");
        //circle2A.setAlignmentX(circle2N.getX());

        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelAvatar.setOpaque(false);
        avatar = new Button("ressources/ButtonImage/button1.png","Avatar des joueurs : ");

        this.bgAvatar1 = new ButtonGroup();
        this.a1j1 = new JRadioButton("Avatar 1");
        this.a2j1 = new JRadioButton("Avatar 2");
        this.a3j1 = new JRadioButton("Avatar 3");
        this.bgAvatar2 = new ButtonGroup();
        this.a1j2 = new JRadioButton("Avatar 1");
        this.a2j2 = new JRadioButton("Avatar 2");
        this.a3j2 = new JRadioButton("Avatar 3");
        a1j1.setSelected(true);
        bgAvatar1.add(a1j1);
        bgAvatar1.add(a2j1);
        bgAvatar1.add(a3j1);
        panelAvatar.add(avatar);
        panelAvatar.add(circle1A);
        panelAvatar.add(a1j1);
        panelAvatar.add(a2j1);
        panelAvatar.add(a3j1);
        panelAvatar.add(circle2A);
        bgAvatar2.add(a1j2);
        bgAvatar2.add(a2j2);
        bgAvatar2.add(a3j2);
        a1j2.setSelected(true);
        panelAvatar.add(a1j2);
        panelAvatar.add(a2j2);
        panelAvatar.add(a3j2);

        
        // Choix couleur pions
        Button circle1C = new Button("ressources/ButtonImage/circleR.png", "J1");
        Button circle2C = new Button("ressources/ButtonImage/circleR.png", "J2");

        JPanel panelColor = new JPanel();
        panelColor.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelColor.setOpaque(false);
        color = new Button("ressources/ButtonImage/button1.png","Couleur des pions : ");

        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("Blanc");
        this.black = new JRadioButton("Noir");
        this.bgColor2 = new ButtonGroup();
        this.white2 = new JRadioButton("Blanc");
        this.black2 = new JRadioButton("Noir");
        this.bgColorB = new ButtonGroup();
        this.bgColorW = new ButtonGroup();
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        panelColor.add(circle1C);
        panelColor.add(white);
        panelColor.add(black);
        black2.setSelected(true);
        bgColor2.add(white2);
        bgColor2.add(black2);
        panelColor.add(circle2C);
        panelColor.add(white2);
        panelColor.add(black2);


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
        bigBox.add(box, BorderLayout.NORTH);

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
        panel.setLayout(new BorderLayout());
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(bigBox, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
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
