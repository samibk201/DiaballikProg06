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
public class PlateauGraphique extends JComponent {
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int caseLargeur;
	private int caseHauteur = caseLargeur = 100;
	private int marge = caseLargeur / 10;
	private Image imgPionJ1, imgPionJ2, imgPionJ1AvecBalle, imgPionJ2AvecBalle;

	Partie partie;
	
	JeuPlateau jeu;

	GameSetIA gameIA = GameSetIA.getInstance();
	GameSetJ gameJ = GameSetJ.getInstance();

	public int pionSelected = 0;
	public int turn = 0;
	public int xSelected;
	public int ySelected;

	/*
	 * private String[][] pions = { {"B","B","B","L","B", "B", "B"}, {null, null,
	 * null, null, null, null, null}, {null, null, null, null, null, null, null},
	 * {null, null, null, null, null, null, null}, {null, null, null, null, null,
	 * null, null}, {null, null, null, null, null, null, null}, {"N", "N", "N", "O",
	 * "N", "N", "N"}, };
	 */

	public PlateauGraphique() {
		Joueur j1 = new Joueur(1, "Dan");
		Joueur j2 = new Joueur(2, "CissÃ©");
		int disposition = 1;
		
		if (gameIA.IA == 1)
			disposition = gameIA.configPlateau;
		else
			disposition = gameJ.configPlateau;

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

		/*g2D.draw(new RoundRectangle2D.Double(caseLargeur - marge, caseLargeur - marge,
				(caseLargeur * this.nbColonnes) + marge, (caseLargeur * this.nbLignes) + marge, caseLargeur,
				caseLargeur));*/

	}

	public void remplirPlateau(Graphics2D g2D) {
		// chargement image
		String nameImg;
		Image image = null;
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
		//&& jeu.estOccupe(ySelected, xSelected)
		if (pionSelected == 1){
			image = lisImage("ship.png");
			tracer(g2D, image, (xSelected + 1) * caseLargeur, (ySelected + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
			pionSelected = 0;
		}
	}

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
		boolean passeOK = jeu.lancerBalleVers(x, y, newX, newY, j);
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
