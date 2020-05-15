package IHM;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Component;
import java.awt.event.*;


public class LevelIA extends JFrame{

    JLabel title;

    public Button easy;
    public Button mid;
    public Button diff;
    public Button back;
    public Button volum;


    LevelIA(){
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


        // Titre
        title = new JLabel("Choix du niveau de l'IA");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.black);

        // Remplissage panel titre + navig
        JPanel boxNT = new JPanel();
        boxNT.setLayout(new BoxLayout(boxNT, BoxLayout.Y_AXIS));
        boxNT.setOpaque(false);
        boxNT.add(navig);
        boxNT.add(title);


        // Buttons
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);

        this.easy = new Button("ressources/ButtonImage/easySR.png");
        easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.mid = new Button("ressources/ButtonImage/moySR.png");
        mid.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.diff = new Button("ressources/ButtonImage/diffSR.png");
        diff.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Remplissage panel des boutons
        box.add(easy);
        box.add(mid);
        box.add(diff);
        
        // Remplissage panel principal        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(boxNT, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);


        // Clicks
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                GameSetIA gameSetIA = new GameSetIA();
                gameSetIA.init(frame.getWidth(), frame.getHeight());
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
