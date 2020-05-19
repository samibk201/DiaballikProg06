package IHM;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


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
        background.Background(frame, "Theme/bg.png");


        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/sound.png");
        navig.add(back);
        navig.add(volum);


        // Panel boutons
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);

        // Chargement images des boutons
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
        panel.add(navig, BorderLayout.NORTH);
        panel.add(box, BorderLayout.CENTER);


        // Clicks + gestion du passage de la souris sur le bouton
        back.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backCLicked.png"));
            }
            public void mouseExited(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                GameSetIA gameSetIA = new GameSetIA();
                gameSetIA.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        easy.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                easy.setIcon(new ImageIcon("ressources/ButtonImage/easyClik.png"));
            }
            public void mouseExited(MouseEvent e){
                easy.setIcon(new ImageIcon("ressources/ButtonImage/easySR.png"));
            }
            public void mouseClicked(MouseEvent e){
                InterfacePartie interfacePartie = new InterfacePartie();
                interfacePartie.run();
                frame.dispose();
            }
        });

        mid.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                mid.setIcon(new ImageIcon("ressources/ButtonImage/moyClik.png"));
            }
            public void mouseExited(MouseEvent e){
                mid.setIcon(new ImageIcon("ressources/ButtonImage/moySR.png"));
            }
        });

        diff.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                diff.setIcon(new ImageIcon("ressources/ButtonImage/diffClik.png"));
            }
            public void mouseExited(MouseEvent e){
                diff.setIcon(new ImageIcon("ressources/ButtonImage/diffSR.png"));
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
