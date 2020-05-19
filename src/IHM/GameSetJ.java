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
import java.awt.Dimension;


public class GameSetJ extends JFrame{

    JLabel title;
    public JTextField nameField;
    public JTextField nameJ1;
    public JTextField nameJ2;

    Button boardNor;
    Button boardMel;

    Button vikingJ1;
    Button beaverJ1;
    Button garfieldJ1;
    Button vikingJ2;
    Button beaverJ2;
    Button garfieldJ2;

    Button greenJ1;
    Button yelloJ1;
    Button greyJ1;
    Button greenJ2;
    Button yelloJ2;
    Button greyJ2;

    Button sepNameJ1;
    Button sepAvJ1;
    Button sepColJ1;
    Button sepNameJ2;
    Button sepAvJ2;
    Button sepColJ2;

    public Button next; 
    public Button back;
    public Button volum;

    // 1 = vert, 2 = jaune, 3 = gris
    public int colorJ1 = 1;
    public int colorJ2 = 2;
    // 1 = viking, 2 = beaver, 3 = garfield
    public int avatarJ1 = 1;
    public int avatarJ2 = 2;
    // 1 = plateau simple, 2 = plateau mélangé
    public int configPlateau = 1;

    int greenSelectedJ1 = 1;
    int greySelectedJ1 = 0;
    int yelloSelectedJ1 = 0;
    int vikSelectedJ1 = 1;
    int beavSelectedJ1 = 0;
    int garfSelectedJ1 = 0;

    int greenSelectedJ2 = 0;
    int greySelectedJ2 = 0;
    int yelloSelectedJ2 = 1;
    int vikSelectedJ2 = 0;
    int beavSelectedJ2 = 0;
    int garfSelectedJ2 = 1;

    int boardMelSelected = 0;
    int boardNorSelected = 1;


    GameSetJ(){
        super();
    }

    static GameSetJ gameSetJ = null;

    public static GameSetJ getInstance(){
        if (gameSetJ == null){
            GameSetJ.gameSetJ = new GameSetJ();
        }
        return GameSetJ.gameSetJ;
    }

    public void init(int w, int h){

        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(new BorderLayout());

        // Background
        Background background = new Background();
        background.Background(frame, "Theme/bgParam.png");


        // Chargement des bouttons
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        
        
        // Panel nord
        JPanel navig = new JPanel();
        navig.setLayout(new FlowLayout(FlowLayout.LEFT));
        navig.setOpaque(false);
        navig.add(back);
        navig.add(volum);


        // Panel nom du joueur
        JPanel nom = new JPanel();
        nom.setLayout(new FlowLayout());
        nom.setOpaque(false);

        JLabel lnom = new JLabel("Joueur : ");
        lnom.setFont(new Font("Tahoma", Font.BOLD, 26));

        nameJ1 = new JTextField("Joueur1");
        nameJ1.setColumns(10);

        nameJ2 = new JTextField("Joueur2");
        nameJ2.setColumns(10);

        // Séparateurs des champs des joueurs
        sepNameJ1 = new Button("ressources/ButtonImage/circleR.png","J1");
        sepNameJ2 = new Button("ressources/ButtonImage/circleR.png","J2");
        
        nom.add(lnom);
        nom.add(sepNameJ1);
        nom.add(nameJ1);
        nom.add(sepNameJ2);
        nom.add(nameJ2);
        nom.add(Box.createRigidArea(new Dimension(20, 0)));



        // Panel du choix de l'avatar
        JPanel av = new JPanel();
        av.setLayout(new FlowLayout());
        av.setOpaque(false);

        // Titre du champs
        JLabel avLab = new JLabel("Avatar : ");
        avLab.setFont(new Font("Tahoma", Font.BOLD, 26));

        // Chargement des images des avatars
        vikingJ1 = new Button("ressources/Avatars/vikClik.png");
        garfieldJ1 = new Button("ressources/Avatars/garfield.png");
        beaverJ1 = new Button("ressources/Avatars/beaver.png");

        vikingJ2 = new Button("ressources/Avatars/vik.png");
        garfieldJ2 = new Button("ressources/Avatars/garfieldClik.png");
        beaverJ2 = new Button("ressources/Avatars/beaver.png");

        // Séparateur champs des deux joueurs
        sepAvJ1 = new Button("ressources/ButtonImage/circleR.png","J1");
        sepAvJ2 = new Button("ressources/ButtonImage/circleR.png","J2");

        // Remplissage panel du choix des avatars
        av.add(avLab);
        av.add(sepAvJ1);
        av.add(vikingJ1);
        av.add(garfieldJ1);
        av.add(beaverJ1);
        av.add(sepAvJ2);
        av.add(vikingJ2);
        av.add(garfieldJ2);
        av.add(beaverJ2);
        av.add(Box.createRigidArea(new Dimension(20,0)));



        // Panel du choix de la couleur des pions
        JPanel col = new JPanel();
        col.setLayout(new FlowLayout());
        col.setOpaque(false);

        // Titre du champs
        JLabel colLab = new JLabel("Pions : ");
        colLab.setFont(new Font("Tahoma", Font.BOLD, 26));

        // Chargement des images des couleurs
        greenJ1 = new Button("ressources/ButtonImage/radioGreenClik.png");
        greyJ1 = new Button("ressources/ButtonImage/radioGrey.png");
        yelloJ1 = new Button("ressources/ButtonImage/radioYello.png");

        greenJ2 = new Button("ressources/ButtonImage/radioGreen.png");
        greyJ2 = new Button("ressources/ButtonImage/radioGrey.png");
        yelloJ2 = new Button("ressources/ButtonImage/radioYelloClik.png");

        // Séparateur champs des deux joueurs
        sepColJ1 = new Button("ressources/ButtonImage/circleR.png","J1");
        sepColJ2 = new Button("ressources/ButtonImage/circleR.png","J2");

        // Remplissage panel des choix des couleurs
        col.add(colLab);
        col.add(sepColJ1);
        col.add(greenJ1);
        col.add(yelloJ1);
        col.add(greyJ1);
        col.add(sepColJ2);
        col.add(greenJ2);
        col.add(yelloJ2);
        col.add(greyJ2);
        col.add(Box.createRigidArea(new Dimension(160, 0)));


        
        // Panel du choix de la configuration du plateau de départ
        JPanel board = new JPanel();
        board.setLayout(new FlowLayout());
        board.setOpaque(false);

        // Titre du champs
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
        

        // Panel borderLayout contenant le panel vik
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
                InterfacePartie interfacePartie = new InterfacePartie();
                interfacePartie.run();
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


        // Bouton vert du choix de couleurs
        greenJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                greenJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreenClik.png"));
                greenSelectedJ1 = 1;
                colorJ1 = 1;
                if (greySelectedJ1 == 1){
                    greyJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ1 = 0;
                    greyJ1.repaint();
                }
                if (yelloSelectedJ1 == 1){
                    yelloJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ1 = 0;
                    yelloJ1.repaint();
                }
                if (greenSelectedJ2 == 1){
                    greenJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ2 = 0;
                    greyJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreyClik.png"));
                    greySelectedJ2 = 1;
                    colorJ2 = 3;
                    greyJ2.repaint();
                    greenJ2.repaint();
                }
                greenJ1.repaint();
            }
        });

        // Bouton gris du choix de couleurs
        greyJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                greyJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreyClik.png"));
                greySelectedJ1 = 1;
                colorJ1 = 3;
                if (greenSelectedJ1 == 1){
                    greenJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ1 = 0;
                    greenJ1.repaint();
                }
                if (yelloSelectedJ1 == 1){
                    yelloJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ1 = 0;
                    yelloJ1.repaint();
                }
                if (greySelectedJ2 == 1){
                    greyJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ2 = 0;
                    yelloJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioYelloClik.png"));
                    yelloSelectedJ2 = 1;
                    colorJ2 = 2;
                    yelloJ2.repaint();
                    greyJ2.repaint();
                }
                greyJ1.repaint();
            }
        });

        // Bouton jaune du choix de couleurs de J1
        yelloJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                yelloJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioYelloClik.png"));
                yelloSelectedJ1 = 1;
                colorJ1 = 2;
                if (greySelectedJ1 == 1){
                    greyJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ1 = 0;
                    greyJ1.repaint();
                }
                if (greenSelectedJ1 == 1){
                    greenJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ1 = 0;
                    greenJ1.repaint();
                }
                if (yelloSelectedJ2 == 1){
                    yelloJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ2 = 0;
                    greenJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreenClik.png"));
                    greenSelectedJ2 = 1;
                    colorJ2 = 1;
                    greenJ2.repaint();
                    yelloJ2.repaint();
                }
                yelloJ1.repaint();
            }
        });

        // Bouton vert du choix de couleurs de J1
        greenJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                greenJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreenClik.png"));
                greenSelectedJ2 = 1;
                colorJ2 = 1;
                if (greySelectedJ2 == 1){
                    greyJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ2 = 0;
                    greyJ2.repaint();
                }
                if (yelloSelectedJ2 == 1){
                    yelloJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ2 = 0;
                    yelloJ2.repaint();
                }
                if (greenSelectedJ1 == 1){
                    greenJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ1 = 0;
                    greyJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreyClik.png"));
                    greySelectedJ1 = 1;
                    colorJ1 = 3;
                    greyJ1.repaint();
                    greenJ1.repaint();
                }
                greenJ2.repaint();
            }
        });

        // Bouton gris du choix de couleurs de J1
        greyJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                greyJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreyClik.png"));
                greySelectedJ2 = 1;
                colorJ2 = 3;
                if (greenSelectedJ2 == 1){
                    greenJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ2 = 0;
                    greenJ2.repaint();
                }
                if (yelloSelectedJ2 == 1){
                    yelloJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ2 = 0;
                    yelloJ2.repaint();
                }
                if (greySelectedJ1 == 1){
                    greyJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ1 = 0;
                    yelloJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioYelloClik.png"));
                    yelloSelectedJ1 = 1;
                    colorJ1 = 2;
                    yelloJ1.repaint();
                    greyJ1.repaint();
                }
                greyJ2.repaint();
            }
        });

        // Bouton jaune du choix de couleurs de J2
        yelloJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                yelloJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioYelloClik.png"));
                yelloSelectedJ2 = 1;
                colorJ2 = 2;
                if (greySelectedJ2 == 1){
                    greyJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGrey.png"));
                    greySelectedJ2 = 0;
                    greyJ2.repaint();
                }
                if (greenSelectedJ2 == 1){
                    greenJ2.setIcon(new ImageIcon("ressources/ButtonImage/radioGreen.png"));
                    greenSelectedJ2 = 0;
                    greenJ2.repaint();
                }
                if (yelloSelectedJ1 == 1){
                    yelloJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioYello.png"));
                    yelloSelectedJ1 = 0;
                    greenJ1.setIcon(new ImageIcon("ressources/ButtonImage/radioGreenClik.png"));
                    greenSelectedJ1 = 1;
                    colorJ1 = 1;
                    greenJ1.repaint();
                    yelloJ1.repaint();
                }
                yelloJ2.repaint();
            }
        });
        
        // Bouton de l'avatar viking de J1
        vikingJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                vikingJ1.setIcon(new ImageIcon("ressources/Avatars/vikClik.png"));
                vikSelectedJ1 = 1;
                avatarJ1 = 1;
                if (garfSelectedJ1 == 1){
                    garfieldJ1.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ1 = 0;
                    garfieldJ1.repaint();
                }
                if (beavSelectedJ1 == 1){
                    beaverJ1.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ1 = 0;
                    beaverJ1.repaint();

                }
                if (vikSelectedJ2 == 1){
                    vikingJ2.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ2 = 0;
                    garfieldJ2.setIcon(new ImageIcon("ressources/Avatars/garfieldClik.png"));;
                    garfSelectedJ2 = 1;
                    avatarJ2 = 3;
                    garfieldJ2.repaint();
                    vikingJ2.repaint();
                }
                vikingJ1.repaint();
            }
        });

        // Bouton de l'avatar garfield de J1
        garfieldJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                garfieldJ1.setIcon(new ImageIcon("ressources/Avatars/garfieldClik.png"));
                garfSelectedJ1 = 1;
                avatarJ1 = 3;
                if (vikSelectedJ1 == 1){
                    vikingJ1.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ1 = 0;
                    vikingJ1.repaint();
                }
                if (beavSelectedJ1 == 1){
                    beaverJ1.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ1 = 0;
                    beaverJ1.repaint();

                }
                if (garfSelectedJ2 == 1){
                    garfieldJ2.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ2 = 0;
                    beaverJ2.setIcon(new ImageIcon("ressources/Avatars/beaverClik.png"));
                    beavSelectedJ2 = 1;
                    avatarJ2 = 2;
                    beaverJ2.repaint();
                    garfieldJ2.repaint();
                }
                garfieldJ1.repaint();
            }
        });

        // Bouton de l'avatar castor de J1
        beaverJ1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                beaverJ1.setIcon(new ImageIcon("ressources/Avatars/beaverClik.png"));
                beavSelectedJ1 = 1;
                avatarJ1 = 2;
                if (garfSelectedJ1 == 1){
                    garfieldJ1.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ1 = 0;
                    garfieldJ1.repaint();
                }
                if (vikSelectedJ1 == 1){
                    vikingJ1.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ1 = 0;
                    vikingJ1.repaint();

                }
                if (beavSelectedJ2 == 1){
                    beaverJ2.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ2 = 0;
                    vikingJ2.setIcon(new ImageIcon("ressources/Avatars/vikClik.png"));
                    vikSelectedJ2 = 1;
                    avatarJ2 = 1;
                    vikingJ2.repaint();
                    beaverJ2.repaint();

                }
                beaverJ1.repaint();
            }
        });

        // Bouton de l'avatar viking de J2
        vikingJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                vikingJ2.setIcon(new ImageIcon("ressources/Avatars/vikClik.png"));
                vikSelectedJ2 = 1;
                avatarJ2 = 1;
                if (garfSelectedJ2 == 1){
                    garfieldJ2.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ2 = 0;
                    garfieldJ2.repaint();
                }
                if (beavSelectedJ2 == 1){
                    beaverJ2.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ2 = 0;
                    beaverJ2.repaint();

                }
                if (vikSelectedJ1 == 1){
                    vikingJ1.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ1 = 0;
                    garfieldJ1.setIcon(new ImageIcon("ressources/Avatars/garfieldClik.png"));
                    garfSelectedJ1 = 1;
                    avatarJ1 = 3;
                    garfieldJ1.repaint();
                    vikingJ1.repaint();
                }
                vikingJ2.repaint();
            }
        });

        // Bouton de l'avatar garfield de J2
        garfieldJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                garfieldJ2.setIcon(new ImageIcon("ressources/Avatars/garfieldClik.png"));
                garfSelectedJ2 = 1;
                avatarJ2 = 3;
                if (vikSelectedJ2 == 1){
                    vikingJ2.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ2 = 0;
                    vikingJ2.repaint();
                }
                if (beavSelectedJ2 == 1){
                    beaverJ2.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ2 = 0;
                    beaverJ2.repaint();

                }
                if (garfSelectedJ1 == 1){
                    garfieldJ1.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ1 = 0;
                    beaverJ1.setIcon(new ImageIcon("ressources/Avatars/beaverClik.png"));
                    beavSelectedJ1 = 1;
                    avatarJ1 = 2;
                    beaverJ1.repaint();
                    garfieldJ1.repaint();
                }
                garfieldJ2.repaint();
            }
        });

        // Bouton de l'avatar castor de J2
        beaverJ2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                beaverJ2.setIcon(new ImageIcon("ressources/Avatars/beaverClik.png"));
                beavSelectedJ2 = 1;
                avatarJ2 = 2;
                if (garfSelectedJ2 == 1){
                    garfieldJ2.setIcon(new ImageIcon("ressources/Avatars/garfield.png"));
                    garfSelectedJ2 = 0;
                    garfieldJ2.repaint();
                }
                if (vikSelectedJ2 == 1){
                    vikingJ2.setIcon(new ImageIcon("ressources/Avatars/vik.png"));
                    vikSelectedJ2 = 0;
                    vikingJ2.repaint();
                }
                if (beavSelectedJ1 == 1){
                    beaverJ1.setIcon(new ImageIcon("ressources/Avatars/beaver.png"));
                    beavSelectedJ1 = 0;
                    vikingJ1.setIcon(new ImageIcon("ressources/Avatars/vikClik.png"));
                    vikSelectedJ1 = 1;
                    avatarJ1 = 1;
                    vikingJ1.repaint();
                    beaverJ1.repaint();
                }
                beaverJ2.repaint();
            }
        });

        // Bouton plateau mélangé
        boardMel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                boardMel.setIcon(new ImageIcon("ressources/ButtonImage/plateauMelClik.png"));
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
                boardNor.setIcon(new ImageIcon("ressources/ButtonImage/plateauSimpleClik.png"));
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
