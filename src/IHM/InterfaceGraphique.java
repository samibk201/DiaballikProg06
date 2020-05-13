package IHM;

import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;


public class InterfaceGraphique implements Runnable{

    public Button unJoueur;
    public Button deuxJoueur;
    public Button enCours;
    public Button tutoriel;
    public Button quit;
    public Button volum;
    int w = 1200;
    int h = 1000;

    JLabel title;

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new InterfaceGraphique());
    }
  
    @Override
    public void run() {
        
        JFrame frame = new JFrame();
        JLabel bg;

        frame.setSize(w, h);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);

        volum = new Button("volume.png");
        volum.setAlignmentX(Component.RIGHT_ALIGNMENT);


        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout());
        panelTitle.setOpaque(false);
        title = new JLabel();
        title.setIcon(new ImageIcon("ressources/ButtonImage/diaballik.png"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelTitle.add(title);

        this.deuxJoueur = new Button("ressources/ButtonImage/jVSjSR(1).png");
        deuxJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.unJoueur = new Button("ressources/ButtonImage/jVSiaSR.png");
        unJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.enCours = new Button("ressources/ButtonImage/encoursSR.png");
        enCours.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.tutoriel = new Button("ressources/ButtonImage/tutorielSR.png");
        tutoriel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quit = new Button("ressources/ButtonImage/btnquitSR.png");
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Cliks
        deuxJoueur.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                GameSetJ gameSetJ = new GameSetJ();
                gameSetJ.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        unJoueur.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                GameSetIA gameSetIA = new GameSetIA();
                gameSetIA.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        tutoriel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Tuto1 tuto1 = new Tuto1();
                tuto1.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });        

        quit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int quitClicked = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter le jeu ?", "Quitter", JOptionPane.YES_NO_OPTION);
                if (quitClicked == JOptionPane.YES_OPTION){
                    frame.dispose();
                    System.exit(0);
                }
            }
        });
        

        // Ajout des composants dans le panel
        box.add(deuxJoueur);
        box.add(unJoueur);
        box.add(enCours);
        box.add(tutoriel);
        box.add(quit);


        mainPanel.add(panelTitle, BorderLayout.NORTH);
        mainPanel.add(box, BorderLayout.CENTER);


        // Background
        Image img = new ImageIcon("ressources/ButtonImage/bg.png").getImage();
        BackgroundPanel panel = new BackgroundPanel(img);
        panel.add(mainPanel);


        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
	}
}

