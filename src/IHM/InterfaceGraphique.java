package IHM;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Moteur.JeuPlateau;
import Moteur.Joueur;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;


public class InterfaceGraphique implements Runnable{

    public Button unJoueur;
    public Button deuxJoueur;
    public Button enCours;
    public Button tutoriel;
    public Button quit;
    public Button volum;
    int w = 1200;
    int h = 1000;
    int quitt = 0;

    JLabel title;

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new InterfaceGraphique());
    }
  
    /*public JeuPlateau LoadGame(){
        PlateauGraphique plateauGraphique = new PlateauGraphique();
        Joueur j1,j2;
        j1 = new Joueur(1,"TOTO");
        j2 = new Joueur(2,"TATA");
        JeuPlateau jeu = new JeuPlateau(j1, j2, 1);
        jeu.LoadGame();
        plateauGraphique.jeu.LoadGame();
        return jeu;
    }*/


    @Override
    public void run() {

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        
        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bg.png");

        //MusicPlayer musicPlayer = new MusicPlayer();
        //musicPlayer.play("sound.mp3");

        // Panel navig + box
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);


        // Panel boutons
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);


        // Panel son
        JPanel panelVo = new JPanel();
        panelVo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelVo.setOpaque(false);
        volum = new Button("ressources/ButtonImage/sound.png");
        panelVo.add(volum);


        // Panel titre du jeu
        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout());
        panelTitle.setOpaque(false);
        title = new JLabel();
        title.setIcon(new ImageIcon("ressources/Titles/Diaballik.png"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelTitle.add(title);


        // Panel nord son + titre
        JPanel navig = new JPanel();
        navig.setLayout(new BoxLayout(navig, BoxLayout.Y_AXIS));
        navig.setOpaque(false);
        navig.add(panelVo);
        navig.add(title);


        // Chargement des bouttons
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


        // Ajout des composants dans le panel
        box.add(deuxJoueur);
        box.add(unJoueur);
        box.add(enCours);
        box.add(tutoriel);
        box.add(quit);


        // Remplissage panel navig + box
        mainPanel.add(navig, BorderLayout.NORTH);
        mainPanel.add(box, BorderLayout.CENTER);


        // Panel principal        
	    JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(mainPanel);


        // Cliks
        // Click bouton 'joueur vs joueur'
        deuxJoueur.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                deuxJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSjClik.png"));
            }
            public void mouseExited(MouseEvent e){
                deuxJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSjSR(1).png"));
            }
            public void mouseClicked(MouseEvent e){
                GameSetJ gameSetJ = GameSetJ.getInstance();
                gameSetJ.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Click bouton 'joueur vs IA'
        unJoueur.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                unJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSiaClik.png"));
            }
            public void mouseExited(MouseEvent e){
                unJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSiaSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                GameSetIA gameSetIA = GameSetIA.getInstance();
                gameSetIA.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Click bouton 'partie en cours'
        enCours.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                enCours.setIcon(new ImageIcon("ressources/ButtonImage/enCoursClik.png"));
            }
            public void mouseExited(MouseEvent e){
                enCours.setIcon(new ImageIcon("ressources/ButtonImage/encoursSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                InterfacePartie interfacePartie = new InterfacePartie();
                interfacePartie.plateau = new PlateauGraphique();
                interfacePartie.run();
                interfacePartie.plateau.load();
                interfacePartie.turn = interfacePartie.plateau.loadedTurn;
                interfacePartie.move = interfacePartie.plateau.loadedMove;
                interfacePartie.loaded = true;
                frame.dispose();
            }
        });

        // Click bouton 'tutoriel'
        tutoriel.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                tutoriel.setIcon(new ImageIcon("ressources/ButtonImage/tutoClik.png"));
            }
            public void mouseExited(MouseEvent e){
                tutoriel.setIcon(new ImageIcon("ressources/ButtonImage/tutorielSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                Tuto1 tuto1 = new Tuto1();
                tuto1.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });        

        // Click bouton 'quitter'
        quit.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                quit.setIcon(new ImageIcon("ressources/ButtonImage/quitClik.png"));
            }
            public void mouseExited(MouseEvent e){
                quit.setIcon(new ImageIcon("ressources/ButtonImage/btnquitSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                int quitClicked = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter le jeu ?", "Quitter", JOptionPane.YES_NO_OPTION);
                if (quitClicked == JOptionPane.YES_OPTION){
                    frame.dispose();
                    System.exit(0);
                }
            }
        });

        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}

