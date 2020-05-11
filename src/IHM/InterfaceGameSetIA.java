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

    JLabel title;

    JPanel panelPlat;
    JPanel panelName;
    JPanel panelAvatar;
    JPanel panelColor;

    ButtonGroup bgPlat;
    public JRadioButton standard;
    public JRadioButton melange;
    
    ButtonGroup bgAvatar;
    public JRadioButton a1;
    public JRadioButton a2;
    public JRadioButton a3;

    ButtonGroup bgColor;
    public JRadioButton white;
    public JRadioButton black;

    Button plateau;
    Button name;
    Button avatar;
    Button color;

    public Button next;
	
    InterfaceGameSetIA(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53, 79, 82));
        this.setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);

        title = new JLabel("Paramètres de la partie");
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        JPanel flowTitle = new JPanel();
        flowTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowTitle.setBackground(new Color(53, 79, 82));
        flowTitle.add(title);

        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(10);

        JPanel boxy = new JPanel();
        boxy.setLayout(new BoxLayout(boxy, BoxLayout.Y_AXIS));
        boxy.setBackground(new Color(53, 79, 82));

        this.next = new Button("ressources/ButtonImage/nextSR.png");
        
        this.panelPlat = new JPanel();
        this.panelName = new JPanel();
        this.panelAvatar = new JPanel();
        this.panelColor = new JPanel();

        panelPlat.setLayout(new BoxLayout(panelPlat, BoxLayout.LINE_AXIS));
        panelPlat.setBackground(new Color(53, 79, 82));
        this.plateau = new Button("ressources/ButtonImage/button1.png","Configuration du plateau : ");
        this.bgPlat = new ButtonGroup();
        this.standard = new JRadioButton("Plateau standard");
        this.melange = new JRadioButton("Plateau mélangé");
        standard.setForeground(Color.white);
        melange.setForeground(Color.white);
        standard.setSelected(true);
        standard.setBackground(new Color(53, 79, 82));
        melange.setBackground(new Color(53, 79, 82));
        bgPlat.add(standard);
        bgPlat.add(melange);
        panelPlat.add(plateau);
        panelPlat.add(standard);
        panelPlat.add(melange);

        this.panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.LINE_AXIS));
        panelName.setBackground(new Color(53, 79, 82));
        this.name = new Button("ressources/ButtonImage/button1.png","Nom du joueur : ");
        panelName.add(name);
        panelName.add(nameField);

        panelAvatar.setLayout(new BoxLayout(panelAvatar, BoxLayout.LINE_AXIS));
        panelAvatar.setBackground(new Color(53, 79, 82));
        this.avatar = new Button("ressources/ButtonImage/button1.png","Avatar du joueur : ");
        this.bgAvatar = new ButtonGroup();
        this.a1 = new JRadioButton("Avatar 1");
        this.a2 = new JRadioButton("Avatar 2");
        this.a3 = new JRadioButton("Avatar 3");
        a1.setForeground(Color.white);
        a2.setForeground(Color.white);
        a3.setForeground(Color.white);
        a1.setSelected(true);
        a1.setBackground(new Color(53, 79, 82));
        a2.setBackground(new Color(53, 79, 82));
        a3.setBackground(new Color(53, 79, 82));
        bgAvatar.add(a1);
        bgAvatar.add(a2);
        bgAvatar.add(a3);
        panelAvatar.add(avatar);
        panelAvatar.add(a1);
        panelAvatar.add(a2);
        panelAvatar.add(a3);

        panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.LINE_AXIS));
        panelColor.setBackground(new Color(53, 79, 82));
        this.color = new Button("ressources/ButtonImage/button1.png","Couleur des pions : ");
        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("Blanc");
        this.black = new JRadioButton("Noir");
        white.setForeground(Color.white);
        black.setForeground(Color.white);
        white.setSelected(true);
        white.setBackground(new Color(53, 79, 82));
        black.setBackground(new Color(53, 79, 82));
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color);
        panelColor.add(white);
        panelColor.add(black);

        boxy.add(flowTitle);
        boxy.add(panelPlat);
        boxy.add(panelName);
        boxy.add(panelAvatar);
        boxy.add(panelColor);
        boxy.add(next);

        this.add(boxy);
    }
    
}
