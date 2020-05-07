package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class InterfaceGameSetIA extends JPanel{

    JPanel panelPlat;
    JPanel panelName;
    JPanel panelAvatar;
    JPanel panelColor;

    public ButtonGroup bgPlat;
	public JRadioButton standard;
    public JRadioButton melange;
    
    public ButtonGroup bgAvatar = new ButtonGroup();
    public JRadioButton a1 = new JRadioButton("Avatar 1");
    public JRadioButton a2 = new JRadioButton("Avatar 2");
    public JRadioButton a3 = new JRadioButton("Avatar 3");

    public ButtonGroup bgColor = new ButtonGroup();
    public JRadioButton white = new JRadioButton("Blanc");
    public JRadioButton black = new JRadioButton("Noir");

    public JLabel plateau;
    public JLabel name;
    public JLabel avatar;
    public JLabel color;

    public Button next;

    InterfaceGameSetIA(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53, 79, 82));
        this.setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);

        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(10);

        this.next = new Button("ressources/nextSR.png");
        
        this.panelPlat = new JPanel();
        this.panelName = new JPanel();
        this.panelAvatar = new JPanel();
        this.panelColor = new JPanel();

        panelPlat.setLayout(new BoxLayout(panelPlat, BoxLayout.LINE_AXIS));
        this.plateau = new JLabel("Choix du plateau : ");
        this.bgPlat = new ButtonGroup();
        this.standard = new JRadioButton("Plateau standard");
        this.melange = new JRadioButton("Plateau mélangé");
        standard.setSelected(true);
        bgPlat.add(standard);
        bgPlat.add(melange);
        panelPlat.add(plateau);
        panelPlat.add(standard);
        panelPlat.add(melange);

        this.panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.LINE_AXIS));
        this.name = new JLabel("Nom du joueur : ");
        panelName.add(name);
        panelName.add(nameField);

        panelAvatar.setLayout(new BoxLayout(panelAvatar, BoxLayout.LINE_AXIS));
        this.avatar = new JLabel("Choix de l'avatar : ");
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

        panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.LINE_AXIS));
        this.color = new JLabel("Couleur des pions : ");
        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("Blanc");
        this.black = new JRadioButton("Noir");
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        panelColor.add(white);
        panelColor.add(white);
        
        this.add(panelPlat);
        this.add(panelName);
        this.add(panelAvatar);
        this.add(panelColor);
        this.add(next);
    }
    
}
