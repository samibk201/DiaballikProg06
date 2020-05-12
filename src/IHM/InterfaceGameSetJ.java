package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import IHM.Button;

public class InterfaceGameSetJ extends JPanel{

    JLabel title;
    Button name1;
    Button name2;
    Button avatar1;
    Button avatar2;
    Button color1; 
    Button color2;
    Button plateau;

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

    public Button start; 
    public Button back;
    public Button volum;

    InterfaceGameSetJ(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53 , 79, 82));
        this.setBounds(0, 0, screen.width, screen.height);

        this.setLayout(new BorderLayout());

        JPanel flowN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        flowN.add(back);
        flowN.add(volum);

        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(10);

        JPanel bigBox = new JPanel();
        bigBox.setLayout(new BoxLayout(bigBox, BoxLayout.Y_AXIS));
        bigBox.setBackground(new Color(53, 79, 82));

        JPanel flow = new JPanel();
        flow.setLayout(new FlowLayout(FlowLayout.CENTER));
        flow.setBackground(new Color(53, 79, 82));
        //flow.setBackground(new Color(53 , 79, 82));
        
        JPanel box = new JPanel();
        box.setBackground(new Color(53 , 79, 82));
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBackground(new Color(53, 79, 82));

        title = new JLabel("Paramètres de la partie");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setForeground(Color.white);

        plateau = new Button("ressources/ButtonImage/button1.png","Configuration du plateau : ");
        name1 = new Button("ressources/ButtonImage/button1.png","Nom joueur 1 : ");
        avatar1 = new Button("ressources/ButtonImage/button1.png","Avatar du joueur1 : ");
        color1 = new Button("ressources/ButtonImage/button1.png","Couleur des pions joueur1 : ");

        JPanel panelPlato = new JPanel();
        panelPlato.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPlato.setBackground(new Color(53, 79, 82));

        this.bgPlat = new ButtonGroup();
        this.standard = new JRadioButton("Plateau standard");
        this.melange = new JRadioButton("Plateau mélangé");
        standard.setSelected(true);
        standard.setBackground(new Color(53, 79, 82));
        melange.setBackground(new Color(53, 79, 82));
        bgPlat.add(standard);
        bgPlat.add(melange);
        panelPlato.add(plateau);
        panelPlato.add(standard);
        panelPlato.add(melange);

        JPanel panelName = new JPanel();
        panelName.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelName.setBackground(new Color(53, 79, 82));

        panelName.setLayout(new BoxLayout(panelName, BoxLayout.LINE_AXIS));
        panelName.add(name1);
        panelName.add(nameField);

        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelAvatar.setBackground(new Color(53, 79, 82));

        this.bgAvatar = new ButtonGroup();
        this.a1 = new JRadioButton("Avatar 1");
        this.a2 = new JRadioButton("Avatar 2");
        this.a3 = new JRadioButton("Avatar 3");
        a1.setSelected(true);
        a1.setBackground(new Color(53, 79, 82));
        a2.setBackground(new Color(53, 79, 82));
        a3.setBackground(new Color(53, 79, 82));
        bgAvatar.add(a1);
        bgAvatar.add(a2);
        bgAvatar.add(a3);
        panelAvatar.add(avatar1);
        panelAvatar.add(a1);
        panelAvatar.add(a2);
        panelAvatar.add(a3);

        JPanel panelColor = new JPanel();
        panelColor.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelColor.setBackground(new Color(53, 79, 82));

        panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.LINE_AXIS));
        this.bgColor = new ButtonGroup();
        this.white = new JRadioButton("Blanc");
        this.black = new JRadioButton("Noir");
        white.setSelected(true);
        white.setBackground(new Color(53, 79, 82));
        black.setBackground(new Color(53, 79, 82));
        bgColor.add(white);
        bgColor.add(black);
        panelColor.add(color1);
        panelColor.add(white);
        panelColor.add(black);

        box.add(panelName);
        box.add(panelAvatar);
        box.add(panelColor);
        flow.add(box);
        
        start = new Button("ressources/ButtonImage/startSR.png");
        JPanel flowBut = new JPanel();
        flowBut.setLayout(new FlowLayout());
        flowBut.setBackground(new Color(53, 79, 82));
        flowBut.add(start);

        JPanel flowTitle = new JPanel();
        flowTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowTitle.setBackground(new Color(53, 79, 82));
        flowTitle.add(title);

        bigBox.add(flow);

        JPanel boxT = new JPanel();
        boxT.setLayout(new BoxLayout(boxT, BoxLayout.Y_AXIS));
        boxT.add(flow);

        JPanel box1 = new JPanel();
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        box1.add(flowTitle);
        box1.add(panelPlato);
        
        // Ajout des composants dans le panel
        this.add(flowN, BorderLayout.NORTH);
        this.add(box1, BorderLayout.CENTER);
        this.add(bigBox, BorderLayout.EAST);
        this.add(boxT, BorderLayout.WEST);
        this.add(flowBut, BorderLayout.SOUTH);
    }    
}