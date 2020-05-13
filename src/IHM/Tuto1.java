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

public class Tuto1 extends JFrame{

    JTextArea text;

    JLabel title;

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

        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(back);
        navig.add(volum);

        title = new JLabel("Comment jouer");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.white);

        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.add(navig);
        boxNT.add(title);


        // Panel text
        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.text = new JTextArea("Pour avancer, il suffit de cliquer sur le pion \n puis sur la case "+
                                    "où on veut le déplacer. \n Pour faire une passe on clique \n sur le "+
                                    "pion qui a la balle, \n puis sur celui à qui on veut donner la balle.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        flowText.add(text);


        // Boutons
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBut.setOpaque(false);
        next = new Button("ressources/ButtonImage/nextSR.png");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBut.add(next);
        

        // Background
        Image img = new ImageIcon("ressources/ButtonImage/bg.png").getImage();
        BackgroundPanel panel = new BackgroundPanel(img);
        
        // Remplissage panel principal
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(flowText, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks
        next.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Tuto2 tuto2 = new Tuto2();
                tuto2.init(frame.getWidth(), frame.getHeight());
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


        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
