package IHM;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Moteur.JeuPlateau;
import Moteur.Joueur;
import Moteur.Partie;
import Pattern.Observable;
import Pattern.Observateur;;

@SuppressWarnings("serial")
public class PlateauGraphique extends JComponent{
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int caseLargeur;
	private int caseHauteur = caseLargeur = 100;
	private int marge = caseLargeur / 10;
	private Image imgPionJ1, imgPionJ2, imgPionJ1AvecBalle, imgPionJ2AvecBalle;

	Partie partie;
	
	public JeuPlateau jeu;

	GameSetIA gameIA = GameSetIA.getInstance();
	GameSetJ gameJ = GameSetJ.getInstance();

	public int pionSelected = 0;
	public int last = 0;
	public int turn = 0;
	public int xSelected;
	public int ySelected;
	public int win;
	public int xWinner;
	public int yWinner;

	Joueur j1;
	Joueur j2;


	public PlateauGraphique() {
		
		int disposition = 1;
		
		if (gameIA.IA == 1){
			disposition = gameIA.configPlateau;
			//j1 = new Joueur(1, gameIA.nameJ.getText());
			//j2 = new Joueur(2, "ordinateur");
			j1 = new Joueur(1, "toto");
			j2 = new Joueur(2, "lolo");

		}
		else{
			disposition = gameJ.configPlateau;
			//j1 = new Joueur(1, gameJ.nameJ1.getText());
			//j2 = new Joueur(2, gameJ.nameJ2.getText());
			j1 = new Joueur(1, "toto");
			j2 = new Joueur(2, "lolo");

		}

		jeu = new JeuPlateau(j1, j2, disposition);
		jeu.init(nbColonnes, nbLignes, disposition);
	}

	// Les cases doivent Ãªtre carrÃ©es
	public int getCaseLargeur() {
		return caseLargeur = Math.min(caseLargeur, caseHauteur);
	}

	public void setCaseLargeur(int caseLargeur) {
		this.caseLargeur = this.caseHauteur = caseLargeur;
	}

	public int getCaseHauteur() {
		return caseHauteur = Math.min(caseLargeur, caseHauteur);
	}

	public void setCaseHauteur(int caseHauteur) {
		this.caseLargeur = this.caseHauteur = caseHauteur;
	}

	public int hauteurPlateau() {
		return getHeight();
	}

	public int largeurPlateau() {
		return getWidth();
	}

	public void save(int p, int c, int passe) {
        jeu.SaveGame(p, c, passe);
        System.out.println("Game saved!");    
	}
	
	int loadedTurn=0, loadedMove=0, loadedPasse = 0;
    public void load() {
        int t[] = new int[2];
        t=jeu.LoadGame();
        loadedTurn=t[0];
		loadedMove=t[2];
		loadedPasse = t[1];
    }

	private Image lisImage(String nom) {
		Image img = null;
		try {
			img = ImageIO.read(new File("ressources/Pions/" + nom));
		} catch (IOException io) {
			System.out.println("Chargement de l'image " + nom + " Impossible");
			System.exit(1);
		}
		return img;
	}

	void tracer(Graphics2D g2D, Image i, int x, int y, int l, int h) {
		g2D.drawImage(i, x, y, l, h, this);
	}
	public void RemovePion() {
		
	}

	public void colorAccessibles(int i, int j, Graphics2D g2D) {
    	Image img=lisImage("accessible.png");
		if(i!=6) {
			if(!jeu.estOccupe(j,i+1) && !jeu.estOccupeAvecBalle(j,i+1)) {
				tracer(g2D, img, (i + 2) * caseLargeur,
						(j + 1) * caseLargeur,
						caseLargeur - marge, caseLargeur - marge);
			}
		}
		if(i!=0) {
			if(!jeu.estOccupe(j,i-1) && !jeu.estOccupeAvecBalle(j,i-1)) {
				tracer(g2D, img, (i) * caseLargeur,
						(j + 1) * caseLargeur,
						caseLargeur - marge, caseLargeur - marge);
			}
		}
		if(j!=6) {
			if(!jeu.estOccupe(j+1,i) && !jeu.estOccupeAvecBalle(j+1,i)) {
				tracer(g2D, img, (i + 1) * caseLargeur,
						(j + 2) * caseLargeur,
						caseLargeur - marge, caseLargeur - marge);
			}
		}
		if(j!=0) {
			if(!jeu.estOccupe(j-1,i) && !jeu.estOccupeAvecBalle(j-1,i)) {
				tracer(g2D, img, (i + 1) * caseLargeur,
						(j) * caseLargeur,
						caseLargeur - marge, caseLargeur - marge);
			}
		}
	}
	
	public String choixImage(int typeImg, int numJ){
		String nameImg = "";

		if (gameIA.IA == 1){
			if (typeImg == 1){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "vikHachGreen.png";
							break;
						case 2:
							nameImg = "vikHachYello.png";
							break;
						case 3:
							nameImg = "vikHachGrey.png";
							break;
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "vikHachGreen.png";
							break;
						case 2:
							nameImg = "vikHachYello.png";
							break;
						case 3:
							nameImg = "vikHachGrey.png";
							break;
					}
				}
			}
			else if (typeImg == 2){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "vikCoffreGreen.png";
							break;
						case 2:
							nameImg = "vikCoffreYello.png";
							break;
						case 3:
							nameImg = "vikCoffreGrey.png";
							break;
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "vikCoffreGreen.png";
							break;
						case 2:
							nameImg = "vikCoffreYello.png";
							break;
						case 3:
							nameImg = "vikCoffreGrey.png";
							break;
					}
				}
			}
			else if (typeImg == 3){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "vikHachGreenHandsUp.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUp.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "vikHachGreenHandsUp.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUp.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 4){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "LastStep.png";
							break;
						case 2:
							nameImg = "LastStepYellow.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "LastStep.png";
							break;
						case 2:
							nameImg = "LastStepYellow.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 5){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "vikVictGreen.png";
							break;
						case 2:
							nameImg = "vikVictYello.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "vikVictGreen.png";
							break;
						case 2:
							nameImg = "vikVictYello.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 6){
				if (numJ == 1){
					switch(gameIA.colorJ1){
						case 1 :
							nameImg = "vikHachGreenHandsUpCoffre.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUpCoffre.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameIA.colorJ2){
						case 1 :
							nameImg = "vikHachGreenHandsUpCoffre.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUpCoffre.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
		}
		else{
			if (typeImg == 1){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "vikHachGreen.png";
							break;
						case 2:
							nameImg = "vikHachYello.png";
							break;
						case 3:
							nameImg = "vikHachGrey.png";
							break;
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "vikHachGreen.png";
							break;
						case 2:
							nameImg = "vikHachYello.png";
							break;
						case 3:
							nameImg = "vikHachGrey.png";
							break;
					}
				}
			}
			else if (typeImg == 2){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "vikCoffreGreen.png";
							break;
						case 2:
							nameImg = "vikCoffreYello.png";
							break;
						case 3:
							nameImg = "vikCoffreGrey.png";
							break;
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "vikCoffreGreen.png";
							break;
						case 2:
							nameImg = "vikCoffreYello.png";
							break;
						case 3:
							nameImg = "vikCoffreGrey.png";
							break;
					}
				}
			}
			else if (typeImg == 3){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "vikHachGreenHandsUp.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUp.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "vikHachGreenHandsUp.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUp.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 4){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "LastStep.png";
							break;
						case 2:
							nameImg = "LastStepYellow.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "LastStep.png";
							break;
						case 2:
							nameImg = "LastStepYellow.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 5){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "vikVictGreen.png";
							break;
						case 2:
							nameImg = "vikVictYello.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "vikVictGreen.png";
							break;
						case 2:
							nameImg = "vikVictYello.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
			else if (typeImg == 6){
				if (numJ == 1){
					switch(gameJ.colorJ1){
						case 1 :
							nameImg = "vikHachGreenHandsUpcoffre.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUpCoffre.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
				else if (numJ == 2){
					switch(gameJ.colorJ2){
						case 1 :
							nameImg = "vikHachGreenHandsUpcoffre.png";
							break;
						case 2:
							nameImg = "vikHachYelloHandsUpCoffre.png";
							break;
						/*case 3:
							nameImg = "vikCoffreGrey.png";
							break;*/
					}
				}
			}
		}

		

		return nameImg;
	}

	public void dessinerPlateau(Graphics2D g2D) {
		// dessiner les cases
		Image image = null;
		int pair = 0;
		image = lisImage("oceanBoard.png");
		tracer(g2D, image, caseLargeur-marge, caseLargeur-marge, (caseLargeur * this.nbColonnes) + marge, (caseLargeur * this.nbLignes) + marge);
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				g2D.setPaint(Color.LIGHT_GRAY);
				if (pair % 2 == 0) {
					g2D.setStroke(new BasicStroke(2));
					// Cercle = Case
					/*g2D.fillOval((j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);*/
					image = lisImage("bouee.png");
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
							
				} 
				else {
					/*g2D.fillOval((j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);*/
					image = lisImage("bouee.png");
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				}
				pair++;
			}
		}
		// le cadre
		g2D.setPaint(Color.BLACK);
		g2D.setStroke(new BasicStroke(2)); // largeur 2 pixels

	}

	public void remplirPlateau(Graphics2D g2D) {
		// chargement image
		String nameImg;
		Image image = null;
		if(last==1) {
			if (turn == 1){
				nameImg = choixImage(4, 1);
				image = lisImage(nameImg);
			}
			else{
				nameImg = choixImage(4, 2);
				image = lisImage(nameImg);
			}
            tracer(g2D, image, (xSelected + 1) * caseLargeur, (ySelected + 1) * caseLargeur, caseLargeur - marge, caseLargeur - marge);
        }
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				if (jeu.estOccupe(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion sans balle
						nameImg = choixImage(1,1);
						image = lisImage(nameImg);
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion sans balle
						nameImg = choixImage(1,2);
						image = lisImage(nameImg);
					}
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
					
				} else if (jeu.estOccupeAvecBalle(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion avec balle
						nameImg = choixImage(2,1);
						image = lisImage(nameImg);
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion avec balle
						nameImg = choixImage(2,2);
						image = lisImage(nameImg);
					}
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				}
			}
		}
		if (pionSelected == 1 && jeu.estOccupe(ySelected, xSelected)){
			if (jeu.getCase(ySelected, xSelected).getJoueur().getNum() == 1){
				nameImg = choixImage(3, 1);
				image = lisImage(nameImg);
				if(turn==1)
					colorAccessibles(xSelected, ySelected, g2D);
			}
			else if(jeu.getCase(ySelected, xSelected).getJoueur().getNum() == 2){
				nameImg = choixImage(3, 2);
				image = lisImage(nameImg);
				if(turn==2)
					colorAccessibles(xSelected, ySelected, g2D);
			}
			
			tracer(g2D, image, (xSelected + 1) * caseLargeur, (ySelected + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
			pionSelected = 0;
		}
		if (pionSelected == 1 && jeu.estOccupeAvecBalle(ySelected, xSelected)){
			if(jeu.getCase(ySelected, xSelected).getJoueur().getNum()==1){
				nameImg = choixImage(6, 1);
				image = lisImage(nameImg);
			}
			else{
				nameImg = choixImage(6, 2);
				image = lisImage(nameImg);
			}
			tracer(g2D, image, (xSelected + 1) * caseLargeur, (ySelected + 1) * caseLargeur, caseLargeur - marge,
					caseLargeur - marge);
			pionSelected = 0;
		}
		
		// Coup gagnant
		if (jeu.joueurXGagne()){
			win = 1;
		}
		if (win == 1){
			if (jeu.getCase(ySelected, xSelected).getJoueur().getNum() == 1){
				nameImg = choixImage(5, 1);
				image = lisImage(nameImg);
			}
			else if(jeu.getCase(ySelected, xSelected).getJoueur().getNum() == 2){
				nameImg = choixImage(5, 2);
				image = lisImage(nameImg);
			}
			tracer(g2D, image, 5, 5, caseLargeur*8, caseHauteur*8);
		}
	}


	// 1 si la case est occupée, 2 si il y a un joueur avec une balle, 0 si elle est vide
	public int check(Joueur j, int x, int y){
		if (jeu.estOccupe(x, y))
			return 1;
		if (jeu.estOccupeAvecBalle(x, y))
			return 2;
		return 0;
	}
	
	public int newPos(Joueur j, int x, int y, int newX, int newY) {
		int c = 0;
		if(j.getNum()==1) {
			if(newX==x+1) {
				if(newY==y)
					c=0;
				else
					return 1;
			}else if(newX==x-1) {
				if(newY==y)
					c=3;
				else
					return 1;
			}else if(newY==y+1) {
				if(newX==x)
					c=1;
				else
					return 1;
			}else if(newY==y-1) {
				if(newX==x)
					c=2;
				else
					return 1;
			}else
				return 1;
		}
		if(j.getNum()==2) {
			if(newX==x+1) {
				if(newY==y)
					c=3;
				else
					return 1;
			}else if(newX==x-1) {
				if(newY==y)
					c=0;
				else
					return 1;
			}else if(newY==y+1) {
				if(newX==x)
					c=2;
				else
					return 1;
			}else if(newY==y-1) {
				if(newX==x)
					c=1;
				else
					return 1;
			}else
				return 1;
		}
		boolean coupOK = jeu.joueCoup(j, c, x, y);
		if (coupOK == false)
			return 1;
		return 0;
	}

	public int passe(Joueur j, int x, int y, int newX, int newY){
		boolean passeOK = false;
		//if (((newY == newX) && newX<x) || ((newX-newY)%2==0 || (newY-newX)%2==0) || (x == newY) || (y == newX) || (newX>x && newY<y))
		int diffX = x-newX;
		int diffY = y-newY;
		if (diffX < 0)
			diffX = -diffX;
		if (diffY < 0)
			diffY = -diffY;
		if ((x == newX || y == newY) || (diffX == diffY))	
			passeOK = jeu.lancerBalleVers(x, y, newX, newY, j);
		else
			return 1;
		if (passeOK == false)
			return 1;
		return 0;
	}


	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		// On dessiner les cases du plateau
		this.dessinerPlateau(g2D);

		// On remplit le plateau avec des pions
		this.remplirPlateau(g2D);

		// Libère toutes les ressources d'écran natives utilisées par cette fenêtre, ses
		// sous-composants et tous ses enfants possédés.
		g2D.dispose();
	}

	public void metAJour() {
		// TODO Auto-generated method stub
		Graphics g = null;
		paintComponent(g);

	}

	
}
