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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
import javax.swing.JOptionPane;
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
    RedacteurPlateau r;
    OutputStream fic;

    Button home;
    Button son;
    Button help;
    Button cancel;
    Button redo;
    Button save;
    Button restart;
    Button endT1;
    Button endT2;
    Button IA1;
    Button IA2;

    int IAon = 1;
    int IAon2 = 1;

    Joueur j1;
	Joueur j2 ;

    int pionSel = 0;
    public int turn = 1;
    public int move = 0;
    int x=0, y=0, newX=0, newY=0, passe = 0, check, nbPasse = 0, nbDepl = 0, undo = 0;
    
    public boolean loaded = false;

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
        endT1 = new Button("ressources/ButtonImage/fintourSel.png");
        endT2 = new Button("ressources/ButtonImage/fintourSel.png");
        IA1 = new Button("ressources/ButtonImage/IAoff.png");
        IA2 = new Button("ressources/ButtonImage/IAoff.png");

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
            //nameJ1 = "TOTO";
            //nameJ2 = "TATA";
            // Récupération identifiant des avatars
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
            //nameJ1 = "TOTO";
            //nameJ2 = "TATA";
            if (nameJ1.equals(nameJ2)){
                nameJ2+="2";
            }
            // Récupération des identifiants des avatars
            avatarJ1 = gameJ.avatarJ1;
            avatarJ2 = gameJ.avatarJ2;
        }

        j1 = new Joueur(1,nameJ1);
        j2 = new Joueur(2, nameJ2);

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

        // Affichage nom de j1
        JLabel nameLabJ1 = new JLabel();
        nameLabJ1.setIcon(new ImageIcon("ressources/ButtonImage/nameField.png"));
        nameLabJ1.setText(nameJ1);
        nameLabJ1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        // Affichage avatar de j1
        JLabel avatarLabJ1 = new JLabel();
        avatarLabJ1.setIcon(new ImageIcon("ressources/Avatars/"+nameImg));


        // Panel nom + avatar j1
        JPanel panelJ1 = new JPanel();
        panelJ1.setLayout(new FlowLayout());
        panelJ1.setBackground(Color.YELLOW);
        panelJ1.add(avatarLabJ1);
        panelJ1.add(nameLabJ1);

        // Panel boutons IA et fin tour de J1
        JPanel panelButJ1 = new JPanel();
        panelButJ1.setLayout(new FlowLayout());
        panelButJ1.setOpaque(false);
        panelButJ1.add(endT1);
        panelButJ1.add(IA1);

        // Box nom + avatar + boutons IA et fin tour J1
        JPanel boxJ1 = new JPanel();
        boxJ1.setLayout(new BoxLayout(boxJ1, BoxLayout.Y_AXIS));
        boxJ1.setOpaque(false);
        boxJ1.add(panelJ1);
        boxJ1.add(panelButJ1);

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
        JLabel nameLabJ2 = new JLabel();
        nameLabJ2.setIcon(new ImageIcon("ressources/ButtonImage/nameField.png"));
        nameLabJ2.setText(nameJ2);
        nameLabJ2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        // Affichage avatar de j2
        JLabel avatarLabJ2 = new JLabel();
        avatarLabJ2.setIcon(new ImageIcon("ressources/Avatars/"+nameImg));


        // Panel nom + avatar j2
        JPanel panelJ2 = new JPanel();
        panelJ2.setLayout(new FlowLayout());
        panelJ2.setBackground(Color.LIGHT_GRAY);
        panelJ2.add(avatarLabJ2);
        panelJ2.add(nameLabJ2);

        // Panel boutons IA et fin tour de J2
        JPanel panelButJ2 = new JPanel();
        panelButJ2.setLayout(new FlowLayout());
        panelButJ2.setOpaque(false);
        panelButJ2.add(endT2);
        panelButJ2.add(IA2);

        // Box nom + avatar + boutons IA et fin tour J2
        JPanel boxJ2 = new JPanel();
        boxJ2.setLayout(new BoxLayout(boxJ2, BoxLayout.Y_AXIS));
        boxJ2.setOpaque(false);
        boxJ2.add(panelJ2);
        boxJ2.add(panelButJ2);


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
        panelBut.add(boxJ1, BorderLayout.NORTH);
        panelBut.add(bordBut, BorderLayout.WEST);
        panelBut.add(boxJ2, BorderLayout.SOUTH);



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


        // Clicks + gestion passage de la souris sur le bouton
        // Gestion des clicks dans le pleateau
        plateau.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (plateau.win == 1){
                    plateau.xWinner = x;
                    plateau.yWinner = y;
                    int winner = JOptionPane.showConfirmDialog(frame, "Partie terminée ! Voulez-vous recommencer ?", "Partie terminée", JOptionPane.YES_NO_OPTION);
                    if (winner == JOptionPane.NO_OPTION){
                        InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
                        interfaceGraphique.run();
                        frame.dispose();
                    }
                    else if (winner == JOptionPane.YES_OPTION){
                        InterfacePartie interfacePartie = new InterfacePartie();
                        interfacePartie.run();
                        frame.dispose();
                    }
                }

                if (loaded){
                    loaded = false;
                    turn = plateau.loadedTurn;
                    move = plateau.loadedMove;
                    nbPasse = plateau.loadedPasse;
                    nbDepl = move-nbPasse;
                }

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
                        nbDepl = 0;
                        if (turn == 1){
                            panelJ1.setBackground(Color.YELLOW);
                            panelJ2.setBackground(Color.LIGHT_GRAY);
                        }
                        else{
                            panelJ2.setBackground(Color.YELLOW);
                            panelJ1.setBackground(Color.LIGHT_GRAY);
                        }
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
                                        undo = 0;
                                    }
                                    else
                                        pionSel = 0;
                                }
                                else
                                    pionSel = 0;
                            }
                            else{
                                if (nbDepl<2){
                                    pionSel = plateau.newPos(j1, x, y, newX, newY);
                                    if (pionSel == 0){
                                        nbDepl++;
                                        move+=1;
                                        undo = 0;
                                        plateau.last = 1;
                                        plateau.turn = turn;
                                    }
                                    else
                                        pionSel = 0;
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
                                        undo = 0;
                                    }
                                    else
                                        pionSel = 0;
                                }
                                else
                                    pionSel = 0;
                            }
                            else{
                                if (nbDepl<2){
                                    pionSel = plateau.newPos(j2, x, y, newX, newY);
                                    if (pionSel == 0){
                                        move+=1;
                                        nbDepl++;
                                        undo = 0;
                                        plateau.last = 1;
                                        plateau.turn = turn;
                                    }
                                    else
                                        pionSel = 0;
                                }
                                else
                                        pionSel = 0;
                            }                    
                        }
                    }
                    plateau.repaint();
                    System.out.println(" NOMBRE DE MOUVEMENTS = "+move);
                }
            }
            
        });

        IA1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (IAon == 1)
                    IA1.setIcon(new ImageIcon("ressources/ButtonImage/IAon.png"));
                else
                    IA1.setIcon(new ImageIcon("ressources/ButtonImage/IAoff.png"));
                IAon = IAon%2+1;
            }
        });
        
        IA2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (IAon2 == 1)
                    IA2.setIcon(new ImageIcon("ressources/ButtonImage/IAon.png"));
                else
                    IA2.setIcon(new ImageIcon("ressources/ButtonImage/IAoff.png"));
                IAon2 = IAon2%2+1;
            }
        });

        endT1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (move > 0 && turn == 1){
                    turn = 2;
                    move = 0;
                    nbPasse = 0;
                    nbDepl = 0;
                    panelJ2.setBackground(Color.YELLOW);
                    panelJ1.setBackground(Color.LIGHT_GRAY);
                }
                else
                    turn = 1;
            }
        });

        endT2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (move > 0 && turn == 2){
                    turn = 1;
                    move = 0;
                    nbPasse = 0;
                    nbDepl = 0;
                    panelJ1.setBackground(Color.YELLOW);
                    panelJ2.setBackground(Color.LIGHT_GRAY);
                }
                else
                    turn = 2;
            }
        });

        home.setToolTipText("Menu Principal");
        home.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeClik.png"));
            }
            public void mouseExited(MouseEvent e){
                home.setIcon(new ImageIcon("ressources/ButtonImage/homeBSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                int quitClicked = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter la partie ?", "Quitter", JOptionPane.YES_NO_OPTION);
                if (quitClicked == JOptionPane.YES_OPTION){
                    InterfaceGraphique mainMenu = new InterfaceGraphique();
                    mainMenu.run();
                    frame.dispose();
                }
            }
        });

        save.setToolTipText("Enregistrer");
        save.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                save.setIcon(new ImageIcon("ressources/ButtonImage/saveClik.png"));
            }
            public void mouseExited(MouseEvent e){
                save.setIcon(new ImageIcon("ressources/ButtonImage/SavePartie.png"));
            }
            public void mouseClicked(MouseEvent e){
                ImageIcon saveIcon = new ImageIcon("ressources/ButtonImage/SavePartie.png");
                String save = (String)JOptionPane.showInputDialog(frame, "Entrer un nom de partie", "SAUVEGARDE!", JOptionPane.INFORMATION_MESSAGE, saveIcon , null, "");
                if(save.length() > 0)
                {
                    save = save+".txt";
                    try {
                        fic = new FileOutputStream(save);    
                    } catch (IOException e1) {
                        //TODO: handle exception
                        System.err.println("Impossible d'ouvrir le fichier "+save);
                        e1.printStackTrace();
                        System.exit(1);
                    }
                    
                    r = new RedacteurPlateau(fic);
                    r.ecrisPlateau(plateau.jeu, j1, j2);
                    JOptionPane.showMessageDialog(frame, "Partie Sauvegarder dans "+save); 
                }
                    
            }
        });

        redo.setToolTipText("Restaurer");
        redo.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                redo.setIcon(new ImageIcon("ressources/ButtonImage/redoClik.png"));
            }
            public void mouseExited(MouseEvent e){
                redo.setIcon(new ImageIcon("ressources/ButtonImage/RedoCoup.png"));
            }
        });

        cancel.setToolTipText("Annuler");
        cancel.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                cancel.setIcon(new ImageIcon("ressources/ButtonImage/cancelClik.png"));
            }
            public void mouseExited(MouseEvent e){
                cancel.setIcon(new ImageIcon("ressources/ButtonImage/cancelCoup.png"));
            }
        });

        ImageIcon restartIcon = new ImageIcon("ressources/ButtonImage/Restart.png");
        restart.setToolTipText("Restart");
        restart.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                restart.setIcon(new ImageIcon("ressources/ButtonImage/restartClik.png"));
            }
            public void mouseExited(MouseEvent e){
                restart.setIcon(new ImageIcon("ressources/ButtonImage/Restart.png"));
            }
            public void mouseClicked(MouseEvent e){
                int restartClicked = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment recommencer la partie ?", "RECOMMENCER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, restartIcon);
                
                if (restartClicked == JOptionPane.YES_OPTION){
                    InterfacePartie i = new InterfacePartie();
                    i.run();
                    frame.dispose();
                }
               
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
