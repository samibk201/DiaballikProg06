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
        title.setForeground(Color.black);

        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.add(navig);
        boxNT.add(title);


        // Choix plateau
        JPanel panelPlato = new JPanel();
        panelPlato.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPlato.setOpaque(false);
        plateau = new Button("ressources/ButtonImage/button1.png","Configuration du plateau : ");
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
        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(10);
        name = new Button("ressources/ButtonImage/button1.png","Nom du joueur : ");

        JPanel panelName = new JPanel();
        panelName.setLayout(new FlowLayout());
        panelName.setAlignmentX(panelPlato.getAlignmentX());
        panelName.setOpaque(false);
        panelName.add(name);
        panelName.add(nameField);


        // Choix avatar
        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new FlowLayout());
        panelAvatar.setAlignmentX(panelPlato.getAlignmentX());
        panelAvatar.setOpaque(false);
        avatar = new Button("ressources/ButtonImage/button1.png","Avatar du joueur : ");

        this.bgAvatar = new ButtonGroup();
        this.a1 = new JRadioButton("Avatar 1");
        this.a2 = new JRadioButton("Avatar 2");
        this.a3 = new JRadioButton("Avatar 3");
        a1.setSelected(true);
        bgAvatar.add(a1);
        bgAvatar.add(a2);
        bgAvatar.add(a3);
        panelAvatar.add(avatar);
        panelAvatar.add(a1);
        panelAvatar.add(a2);
        panelAvatar.add(a3);

        
        // Choix couleur pions
        JPanel panelColor = new JPanel();
        panelColor.setLayout(new FlowLayout());
        panelColor.setAlignmentX(panelPlato.getAlignmentX());
        panelColor.setOpaque(false);
        color = new Button("ressources/ButtonImage/button1.png","Couleur des pions : ");

        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("Blanc");
        this.black = new JRadioButton("Noir");
        this.bgColorB = new ButtonGroup();
        this.bgColorW = new ButtonGroup();
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        panelColor.add(white);
        panelColor.add(black);


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
        next = new Button("ressources/ButtonImage/nextSR.png");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBut.add(next);

        
        // Panel principal
	JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
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
