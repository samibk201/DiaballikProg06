package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Moteur.Joueur;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import javax.imageio.ImageIO;
import java.awt.Dimension;

public class GameSetIA extends JFrame{

    JLabel title;
    
    public JTextField nameJ;

    Button boardNor;
    Button boardMel;

    Button viking;
    Button beaver;
    Button garfield;

    Button green;
    Button yello;
    Button grey;

    public Button next; 
    public Button back;
    public Button volum;

    int IA = 0;
    // 1 = vert, 2 = jaune, 3 = gris
    public int colorJ1 = 1;
    public int colorJ2 = 2;
    // 1 = viking, 2 = beaver, 3 = garfield
    public int avatarJ1 = 1;
    public int avatarJ2 = 2;
    // 1 = plateau simple, 2 = plateau mélangé
    public int configPlateau = 1;

    int greenSelected = 1;
    int greySelected = 0;
    int yelloSelected = 0;
    int vikSelected = 1;
    int beavSelected = 0;
    int garfSelected = 0;
    int boardMelSelected = 0;
    int boardNorSelected = 1;

    GameSetIA(){
        super();
    }

    static GameSetIA gameSetIA = null;

    public static GameSetIA getInstance(){
        if (gameSetIA == null){
            GameSetIA.gameSetIA = new GameSetIA();
        }
        return GameSetIA.gameSetIA;
    }


    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());

        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bgParam.png");


        // Panel nord
        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        navig.add(back);
        navig.add(volum);


        // Panel nom du joueur
        JPanel nom = new JPanel();
        nom.setLayout(new FlowLayout());
        nom.setOpaque(false);
        JLabel nameLab = new JLabel("Joueur : ");
        nameLab.setFont(new Font("Tahoma", Font.BOLD, 26));
        nameJ = new JTextField("Joueur1");
        nameJ.setColumns(20);

        // Remplissage panel du nom
        nom.add(nameLab);
        nom.add(nameJ);
        nom.add(Box.createRigidArea(new Dimension(20, 0)));



        // Panel du choix de l'avatar
        JPanel av = new JPanel();
        av.setLayout(new FlowLayout());
        av.setOpaque(false);

        // Titre
        JLabel avLab = new JLabel("Avatar : ");
        avLab.setFont(new Font("Tahoma", Font.BOLD, 26));

        // Chargement des images des avatars
        viking = new Button("ressources/Avatars/vikClik.png");
        garfield = new Button("ressources/Avatars/garfield.png");
        beaver = new Button("ressources/Avatars/beaver.png");

        // Remplissage panel du choix de l'avatar
        av.add(avLab);
        av.add(viking);
        av.add(garfield);
        av.add(beaver);
        av.add(Box.createRigidArea(new Dimension(20,0)));



        // Panel du choix de la couleur des pions
        JPanel col = new JPanel();
        col.setLayout(new FlowLayout());
        col.setOpaque(false);

        // Titre
        JLabel colLab = new JLabel("Pions : ");
        colLab.setFont(new Font("Tahoma", Font.BOLD, 26));

        // Chargement des images des couleurs
        green = new Button("ressources/ButtonImage/radioGreenClik.png");
        grey = new Button("ressources/ButtonImage/radioGrey.png");
        yello = new Button("ressources/ButtonImage/radioYello.png");


        
        // Panel du choix de la configuration du plateau de départ
        JPanel board = new JPanel();
        board.setLayout(new FlowLayout());
        board.setOpaque(false);

        // Titre
        JLabel lboard = new JLabel("Plateau : ");
        lboard.setFont(new Font("Tahoma", Font.BOLD, 26));

        // Chargement des images des plateaux
        boardNor = new Button("ressources/ButtonImage/plateauSimpleClik.png");
        boardMel = new Button("ressources/ButtonImage/plateauMel.png");

        // Remplissage panel de choix du plateau
        board.add(lboard);
        board.add(boardNor);
        board.add(boardMel);
        board.add(Box.createRigidArea(new Dimension(50, 0)));
        


        // Remplissage panel des choix de couleurs
        col.add(colLab);
        col.add(green);
        col.add(yello);
        col.add(grey);
        col.add(Box.createRigidArea(new Dimension(160, 0)));



        // Panel de tous les panels de choix
        JPanel vik = new JPanel();
        vik.setLayout(new BoxLayout(vik, BoxLayout.Y_AXIS));
        vik.setOpaque(false);
        vik.add(Box.createRigidArea(new Dimension(0,150)));
        vik.add(nom);
        vik.add(av);
        vik.add(col);
        vik.add(board);
        vik.add(Box.createRigidArea(new Dimension(0,120)));
        

        // Panel boderLayout contenant le panel vik
        JPanel bord = new JPanel();
        bord.setLayout(new BorderLayout());
        bord.setOpaque(false);
        bord.add(vik, BorderLayout.CENTER);



        // Panel des bouttons
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new FlowLayout());
        panelBut.setOpaque(false);
        next = new Button("ressources/ButtonImage/nextSR.png");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBut.add(next);



        // Clicks + gestion du passage de la souris sur le bouton
        // Bouton 'suivant'
        next.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextClik.png"));
            }
            public void mouseExited(MouseEvent e){
                next.setIcon(new ImageIcon("ressources/ButtonImage/nextSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                // Envoie des données
                IA = 1;
                if (colorJ1 == 2 || colorJ1 == 1){
                    colorJ2 = 3;
                }
                else if (colorJ1 == 3){
                    colorJ2 = 2;
                }
                if (avatarJ1 == 2 || avatarJ1 == 1){
                    avatarJ2 = 3;
                }
                else if (avatarJ1 == 3){
                    avatarJ2 = 2;
                }
                LevelIA levelIA = new LevelIA();
                levelIA.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Bouton 'retour'
        back.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backCLicked.png"));
            }
            public void mouseExited(MouseEvent e){
                back.setIcon(new ImageIcon("ressources/ButtonImage/backSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                InterfaceGraphique mainMenu = new InterfaceGraphique();
                mainMenu.run();
                frame.dispose();
            }
        });
        
        // Bouton vert des choix de couleurs
        green.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                green.setIcon(new ImageIcon("ressources/ButtonImage/radioGreenClik.png"));;
                greenSelected = 1;
                colorJ1 = 1;
                if (greySelected == 1){
                    grey.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    grey.repaint();
                }
                if (yelloSelected == 1){
                    yello.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yello.repaint();
                }
                green.repaint();
            }
        });

        // Bouton gris des choix de couleurs
        grey.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                grey.setIcon(new ImageIcon("ressources/ButtonImage/radioGreyClik.png"));;
                greySelected = 1;
                colorJ1 = 3;
                if (greenSelected == 1){
                    green.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    green.repaint();
                }
                if (yelloSelected == 1){
                    yello.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yello.repaint();
                }
                grey.repaint();
            }
        });

        // Bouton jaune des choix de couleurs
        yello.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                yello.setIcon(new ImageIcon("ressources/ButtonImage/radioYelloClik.png"));;
                yelloSelected = 1;
                colorJ1 = 2;
                if (greySelected == 1){
                    grey.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    grey.repaint();
                }
                if (greenSelected == 1){
                    green.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    green.repaint();
                }
                yello.repaint();
            }
        });

        // Bouton de l'avatar viking
        viking.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                viking.setIcon(new ImageIcon("ressources/Avatars/vikClik.png"));;
                vikSelected = 1;
                avatarJ1 = 1;
                if (garfSelected == 1){
                    garfield.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfield.repaint();
                }
                if (beavSelected == 1){
                    beaver.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beaver.repaint();

                }
                viking.repaint();
            }
        });

        // Bouton de l'avatar garfield
        garfield.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                garfield.setIcon(new ImageIcon("ressources/Avatars/garfieldClik.png"));;
                garfSelected = 1;
                avatarJ1 = 3;
                if (vikSelected == 1){
                    viking.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    viking.repaint();
                }
                if (beavSelected == 1){
                    beaver.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beaver.repaint();

                }
                garfield.repaint();
            }
        });

        // Bouton de l'avatar castor
        beaver.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                beaver.setIcon(new ImageIcon("ressources/Avatars/beaverClik.png"));;
                beavSelected = 1;
                avatarJ1 = 2;
                if (garfSelected == 1){
                    garfield.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfield.repaint();
                }
                if (vikSelected == 1){
                    viking.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    viking.repaint();

                }
                beaver.repaint();
            }
        });

        // Bouton plateau mélangé
        boardMel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                boardMel.setIcon(new ImageIcon("ressources/ButtonImage/plateauMelClik.png"));;
                boardMelSelected = 1;
                configPlateau = 2;
                if (boardNorSelected == 1){
                    boardNor.setIcon(new ImageIcon("ressources/ButtonImage/plateauSimple.png"));
                    boardNor.repaint();
                }
                boardMel.repaint();
            }
        });

        // Bouton plateau simple
        boardNor.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                boardNor.setIcon(new ImageIcon("ressources/ButtonImage/plateauSimpleClik.png"));;
                boardNorSelected = 1;
                configPlateau = 1;
                if (boardMelSelected == 1){
                    boardMel.setIcon(new ImageIcon("ressources/ButtonImage/plateauMel.png"));
                    boardMel.repaint();
                }
                boardNor.repaint();
            }
        });


        // Panel principal
	    JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(navig, BorderLayout.NORTH);
        panel.add(bord, BorderLayout.CENTER);
        panel.add(panelBut, BorderLayout.SOUTH);
        
        
        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }    
}
