package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.print.DocFlavor.STRING;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.event.*;
import java.awt.Dimension;

import Moteur.*;


public class InterfacePartie extends JFrame implements Runnable{


    public int IA = 0;
    public int colorJ1;
    public int colorJ2;
    public int avatarJ1;
    public int avatarJ2;
    public int configPlateau;
    public String nameJ1;
    public String nameJ2;

    String nameImg;

    PlateauGraphique plateau;

    Button home;
    Button son;
    Button help;
    Button cancel;
    Button redo;
    Button save;
    Button restart;
    JButton endT1;
    JButton endT2;
    JButton ia1;
    JButton ia2;

    Joueur j1 = new Joueur(1,"test");
	Joueur j2 = new Joueur(2, "toto");

    int pionSel = 0;
    int turn = 1;
    int x=0, y=0, newX=0, newY=0, move=0, passe = 0, check, nbPasse = 0;

    @Override
    public void run() {
        
        JFrame frame = new JFrame();
        frame.setSize(1200, 1000); 

        // Background
        Background background = new Background();
        background.Background(frame, "ButtonImage/bg.png");

        // Panel nord son + bouton help + bouton retour menu
        JPanel navig = new JPanel();
        navig.setLayout(new BorderLayout());
        navig.setOpaque(false);

        // Chargement du plateau
        plateau = new PlateauGraphique();

        // Chargement des bouttons
        home = new Button("ressources/ButtonImage/homeBSR.png");
        son = new Button("ressources/ButtonImage/volume.png");
        help = new Button("ressources/ButtonImage/help.png");
        cancel = new Button("ressources/ButtonImage/cancelCoup.png");
        redo = new Button("ressources/ButtonImage/RedoCoup.png");
        save = new Button("ressources/ButtonImage/SavePartie.png");
        restart = new Button("ressources/ButtonImage/Restart.png");
        endT1 = new JButton("Fin du tour");
        endT2 = new JButton("Fin du tour");
        ia1 = new JButton("IA");
        ia2 = new JButton("IA");

        // Remplissage panel nord
        navig.add(home, BorderLayout.WEST);
        navig.add(help, BorderLayout.EAST);
        navig.add(son);


        // Récupération données joueurs
        // Joueur contre IA
        GameSetIA gameIA = GameSetIA.getInstance();
        if (gameIA.IA == 1){
            // Récupération nom du joueur
            nameJ1 = gameIA.nameJ.getText();
            // Nom de l'IA par défaut
            nameJ2 = "Ordinateur";
            // Récuépration identifiant des avatars
            avatarJ1 = gameIA.avatarJ1;
            avatarJ2 = gameIA.avatarJ2;
            gameIA.IA = 0;
        }
        // Joueur contre joueur
        else{
            GameSetJ gameJ = GameSetJ.getInstance();
            // Récupération noms des joueurs
            nameJ1 = gameJ.nameJ1.getText();
            nameJ2 = gameJ.nameJ2.getText();
            if (nameJ1.equals(nameJ2)){
                nameJ2+="2";
            }
            // Récupération des identifiants des avatars
            avatarJ1 = gameJ.avatarJ1;
            avatarJ2 = gameJ.avatarJ2;
        }


        // Avatar j1 à partir de l'identifiant récupéré
        switch(avatarJ1){
            case 1 :
                nameImg = "vik.png";
                break;
            case 2:
                nameImg = "beaver.png";
                break;
            case 3:
                nameImg = "garfield.png";
                break;
        }

        // Affichage nom j1
        JLabel labJ1 = new JLabel(nameJ1);
        labJ1.setIcon(new ImageIcon("ressources/Avatars/"+nameImg));
        labJ1.setFont(new Font("Tahoma", Font.BOLD, 16));
        Border border = BorderFactory.createLineBorder(Color.black, 2);

        // Panel nom + avatar j1
        JPanel panelJ1 = new JPanel();
        panelJ1.setLayout(new FlowLayout());
        panelJ1.setBackground(Color.WHITE);
        panelJ1.add(labJ1);
        panelJ1.add(ia1);
        panelJ1.add(endT1);

        // Avatar j2 à partir de l'identifiant récupéré
        switch(avatarJ2){
            case 1 :
                nameImg = "vik.png";
                break;
            case 2:
                nameImg = "beaver.png";
                break;
            case 3:
                nameImg = "garfield.png";
                break;
        }

        // Affichage nom de j2
        JLabel labJ2 = new JLabel(nameJ2);
        labJ2.setIcon(new ImageIcon("ressources/Avatars/"+nameImg));
        labJ2.setFont(new Font("Tahoma", Font.BOLD, 16));
        labJ2.setBackground(Color.gray);


        // Panel nom + avatar de j2
        JPanel panelJ2 = new JPanel();
        panelJ2.setLayout(new FlowLayout());
        panelJ2.setBackground(Color.WHITE);
        panelJ2.add(labJ2);
        panelJ2.add(ia2);
        panelJ2.add(endT2);


        // Panel des données des deux joueurs
        JPanel panelJ = new JPanel();
        panelJ.setLayout(new BorderLayout());
        panelJ.setOpaque(false);
        panelJ.add(panelJ1, BorderLayout.NORTH);
        panelJ.add(panelJ2, BorderLayout.SOUTH);


        // Panels bouttons
        JPanel redoCan = new JPanel();
        redoCan.setLayout(new FlowLayout());
        redoCan.setOpaque(false);
        redoCan.add(cancel);
        redoCan.add(redo);


        JPanel boxBut = new JPanel();
        boxBut.setLayout(new BoxLayout(boxBut, BoxLayout.Y_AXIS));
        boxBut.setOpaque(false);
        boxBut.add(save);
        boxBut.add(restart);
        boxBut.add(redoCan);

        JPanel bordBut = new JPanel();
        bordBut.setLayout(new BorderLayout());
        bordBut.setOpaque(false);
        bordBut.add(boxBut, BorderLayout.SOUTH);


        JPanel panelBut = new JPanel();
        panelBut.setLayout(new BorderLayout());
        panelBut.setOpaque(false);
        panelBut.add(panelJ1, BorderLayout.NORTH);
        panelBut.add(bordBut, BorderLayout.WEST);
        panelBut.add(panelJ2, BorderLayout.SOUTH);



        JPanel panelPl = new JPanel();
        panelPl.setLayout(new BorderLayout());
        panelPl.setOpaque(false);
        panelPl.add(plateau, BorderLayout.CENTER);


        // Panel principal        
	    JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(navig, BorderLayout.NORTH);
        panel.add(panelBut, BorderLayout.EAST);
        panel.add(panelPl, BorderLayout.CENTER);
        //panel.add(panelBut, BorderLayout.SOUTH);


        // Clicks + gestion passage de la souris sur le bouton
        // Gestion des clicks dans le pleateau
        plateau.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                Point point = e.getPoint();
                
                // Click choix pion
                if (pionSel == 0) {
                    // Coordonnées pion séléctionné
                	y = (point.x/plateau.getCaseLargeur())-1;
                    x = (point.y/plateau.getCaseHauteur())-1;

                    pionSel = 1;
                    
                    // Envoie coordonnées du pion séléctionné 
                    // Surbrillance pion séléctionné
                    plateau.pionSelected = 1;
                    plateau.turn = turn;
                    plateau.xSelected = y;
                    plateau.ySelected = x;
                    plateau.repaint();

                    // Type de mouvement (passe ou déplacement)
                    if (turn == 1)
                        check = plateau.check(j1, x, y);
                    else 
                        check = plateau.check(j1, x, y);

                    if (check == 1 || check == 0)
                        passe  = 0;
                    else if (check == 2)
                        passe = 1;
                }
                // Click choix action
				else{
                    if (move > 2){
                        turn = turn%2+1;
                        move = 0;
                        nbPasse = 0;
                    }
                        
                    // Coordonnées nouvelle position
                	newY = (point.x/plateau.getCaseLargeur())-1;
                    newX = (point.y/plateau.getCaseHauteur())-1;

                    // Tour j1
                    if (x == newX && y == newY)
                        pionSel =0;
                    else{
                        if (turn == 1){
                            if (passe == 1){
                                if (nbPasse == 0){
                                    pionSel = plateau.passe(j1, x, y, newX, newY);
                                    if (pionSel == 0){
                                        move+=1;
                                        nbPasse = 1;
                                        passe = 0;
                                    }
                                    else
                                        pionSel = 0;
                                }
                                else
                                    pionSel = 0;
                            }
                            else{
                                pionSel = plateau.newPos(j1, x, y, newX, newY);
                                if (pionSel == 0){
                                    move+=1;
                                }
                                else
                                    pionSel = 0;
                            }
                        }
                        //Tour J2
                        else if (turn == 2){
                            if (passe == 1){
                                if (nbPasse == 0){
                                    pionSel = plateau.passe(j2, x, y, newX, newY);
                                    if (pionSel == 0){
                                        move+=1;
                                        nbPasse = 1;
                                        passe = 0;
                                    }
                                    else
                                        pionSel = 0;
                                }
                                else
                                    pionSel = 0;
                            }
                            else{
                                pionSel = plateau.newPos(j2, x, y, newX, newY);
                                if (pionSel == 0){
                                    move+=1;
                                }
                                else
                                    pionSel = 0;
                            }                    
                        }
                    }

                    plateau.repaint();
                    System.out.println(" NOMBRE DE MOUVEMENTS = "+move);
                    System.out.println(" NOMBRE DE PASSE = "+nbPasse);
                }
            }
            
        });

        endT1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (move > 0){
                    turn = 2;
                    move = 0;
                    nbPasse = 0;
                }
                else
                    turn = 1;
            }
        });

        endT2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (move > 0){
                    turn = 1;
                    move = 0;
                    nbPasse = 0;
                }
                else
                    turn = 2;
            }
        });

        home.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeClik.png"));
            }
            public void mouseExited(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeBSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                InterfaceGraphique mainMenu = new InterfaceGraphique();
                mainMenu.run();
                frame.dispose();
            }
        });

        save.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                save.setIcon(new ImageIcon("ressources/ButtonImage/saveClik.png"));
            }
            public void mouseExited(MouseEvent e){
                save.setIcon(new ImageIcon("ressources/ButtonImage/SavePartie.png"));
            }
        });

        redo.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                redo.setIcon(new ImageIcon("ressources/ButtonImage/redoClik.png"));
            }
            public void mouseExited(MouseEvent e){
                redo.setIcon(new ImageIcon("ressources/ButtonImage/RedoCoup.png"));
            }
        });

        cancel.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                cancel.setIcon(new ImageIcon("ressources/ButtonImage/cancelClik.png"));
            }
            public void mouseExited(MouseEvent e){
                cancel.setIcon(new ImageIcon("ressources/ButtonImage/cancelCoup.png"));
            }
        });

        restart.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                restart.setIcon(new ImageIcon("ressources/ButtonImage/restartClik.png"));
            }
            public void mouseExited(MouseEvent e){
                restart.setIcon(new ImageIcon("ressources/ButtonImage/Restart.png"));
            }
        });


        // Paramètrage fenêtre
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }
}
