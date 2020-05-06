package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FenetreGameSetIA extends JFrame {

    private int largeur = 1200;
    private int hauteur = 1000;

    JFrame window = new JFrame();

    JPanel container = new JPanel();
    JPanel panelStart = new JPanel();
    JPanel panelTitle = new JPanel();
    JPanel panelSettings = new JPanel();
    JPanel panelPlateau = new JPanel();
    JPanel panelName = new JPanel();
    JPanel panelAvatar = new JPanel();
    JPanel panelColor = new JPanel();
    JPanel panelBack = new JPanel();

    JButton start = new JButton("Commencer");
    JButton back = new JButton("Retour");

    ButtonGroup bg = new ButtonGroup();
	JRadioButton standard = new JRadioButton("Plateau standard");
    JRadioButton melange = new JRadioButton("Plateau mélangé");
    
    ButtonGroup bgAvatar = new ButtonGroup();
    JRadioButton a1 = new JRadioButton("Avatar 1");
    JRadioButton a2 = new JRadioButton("Avatar 2");
    JRadioButton a3 = new JRadioButton("Avatar 3");

    ButtonGroup bgColor = new ButtonGroup();
    JRadioButton white = new JRadioButton("Blanc");
    JRadioButton black = new JRadioButton("Noir");

    public FenetreGameSetIA() {
        
        // Window settings
        window.setSize(largeur, hauteur);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setUndecorated(true);

        container.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Paramètres partie");
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        panelTitle.add(title);
        

        // Settings
        JLabel plateau = new JLabel("Choix du plateau : ");
        JLabel name = new JLabel("Nom du joueur : ");
        JLabel avatar = new JLabel("Avatar : ");
        JLabel color = new JLabel("Couleur des pions : ");

        JTextField nameField = new JTextField("Joueur1");
        nameField.setColumns(20);


        panelPlateau.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPlateau.setSize(new Dimension(20, 20));
        panelPlateau.add(plateau);
        panelPlateau.add(standard);
        panelPlateau.add(melange);
        standard.setSelected(true);
        bg.add(standard);
        bg.add(melange);

        panelName.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelName.setSize(new Dimension(20, 20));
        panelName.add(name);
        panelName.add(nameField);

        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelAvatar.setSize(new Dimension(20, 20));
        panelAvatar.add(avatar);
        panelAvatar.add(a1);
        panelAvatar.add(a2);
        panelAvatar.add(a3);
        a1.setSelected(true);
        bgAvatar.add(a1);
        bgAvatar.add(a2);
        bgAvatar.add(a3);

        panelColor.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelColor.setSize(new Dimension(20, 20));
        panelColor.add(color);
        panelColor.add(white);
        panelColor.add(black);
        white.setSelected(true);
        bgColor.add(white);
        bgColor.add(black);


        panelSettings.setLayout(new BoxLayout(panelSettings, BoxLayout.Y_AXIS));
        //panelSettings.add(Box.createRigidArea(new Dimension(0, 100)));
        panelSettings.add(panelPlateau);
        //panelSettings.add(Box.createRigidArea(new Dimension(0, 10)));
        panelSettings.add(panelName);
        //panelSettings.add(Box.createRigidArea(new Dimension(0, 10)));
        panelSettings.add(panelAvatar);
        //panelSettings.add(Box.createRigidArea(new Dimension(0, 10)));
        panelSettings.add(panelColor);

        
        // Buttons
        panelStart.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelStart.add(start);
        panelBack.add(back);


        // Main container
        container.add(panelTitle, BorderLayout.NORTH);
        container.add(panelSettings, BorderLayout.CENTER);
        container.add(panelBack, BorderLayout.WEST);
        container.add(panelStart, BorderLayout.SOUTH);


        // Clicks
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreLevelIA levelIA = new FenetreLevelIA();
            }
        });
        
        
		window.setContentPane(container);
		window.setVisible(true);
    }
    
}
