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

public class Tuto5 extends JFrame{

    JTextArea text;

    JLabel title;

    Button prev;
    Button next;
    Button home;
    Button volum;
    
    Tuto5(){
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
        home = new Button("ressources/ButtonImage/homeBSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(home);
        navig.add(volum);

        title = new JLabel();
        title.setIcon(new ImageIcon("ressources/Titles/regleJeu.png"));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.setOpaque(false);
        boxNT.add(navig);
        boxNT.add(title);


        // Panel text
        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout());
        flowText.setOpaque(false);

        text = new JTextArea(" 4. Un pion peut faire une passe à un autre pion à n'importe quelle \n"+
                            " distance uniquement si : \n - il n'y a pas de pions adverses entre les deux \n"+
                            " - le pion à qui on veut faire la passe est accessible en ligne \n"+
                            "  directe orthogonale ou diagonale. ");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        flowText.add(text);


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
        panel.add(flowText, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
        next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Tuto6 tuto6 = new Tuto6();
                tuto6.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        prev.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Tuto4 tuto4 = new Tuto4();
                tuto4.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        home.addMouseListener(new MouseAdapter(){
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
