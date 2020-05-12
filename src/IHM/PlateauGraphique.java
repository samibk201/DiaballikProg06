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
public class PlateauGraphique extends JComponent implements Observable {
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int caseLargeur;
	private int caseHauteur = caseLargeur = 100;
	private int marge = caseLargeur / 10;
	private Image imgPionJ1, imgPionJ2, imgPionJ1AvecBalle, imgPionJ2AvecBalle;
	Partie partie;
	
	JeuPlateau jeu;
	

	/*
	 * private String[][] pions = { {"B","B","B","L","B", "B", "B"}, {null, null,
	 * null, null, null, null, null}, {null, null, null, null, null, null, null},
	 * {null, null, null, null, null, null, null}, {null, null, null, null, null,
	 * null, null}, {null, null, null, null, null, null, null}, {"N", "N", "N", "O",
	 * "N", "N", "N"}, };
	 */

	public PlateauGraphique() {
		Joueur j1 = new Joueur(1, "Dan");
		Joueur j2 = new Joueur(2, "Cissé");
		int disposition = 0;
		//partie = Partie.getInstance();
		//partie.init(j1, j2, disposition);
		
		//this.jeu = partie.getJeu();
		/*
		 * imgCaseSansPoint = new
		 * ImageIcon(getClass().getResource("src/IHM/Images/vide.png"));
		 * imgCaseAvecPoint = new
		 * ImageIcon(getClass().getResource("/IHM/Images/vide.png")); imgPionJ1SurCase =
		 * new ImageIcon(getClass().getResource("/IHM/Images/vide.png"));
		 * imgPionJ2SurCase = new
		 * ImageIcon(getClass().getResource("/IHM/Images/vide.pgg")); imgPionJ1AvecBalle
		 * = new ImageIcon(getClass().getResource("/IHM/Images/vide.png"));
		 * imgPionJ2AvecBalle = new
		 * ImageIcon(getClass().getResource("/IHM/Images/vide.png"));
		 */
		jeu = new JeuPlateau(j1, j2, disposition);
		jeu.init(nbColonnes, nbLignes, disposition);
	}

	// Les cases doivent être carrées
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
			System.out.println("Chargment de l'image " + nom + " Impossible");
			System.exit(1);
		}
		return img;
	}

	private void tracer(Graphics2D g2D, Image i, int x, int y, int l, int h) {
		g2D.drawImage(i, x, y, l, h, this);
	}

	public void dessinerPlateau(Graphics2D g2D) {
		// dessiner les cases
		int pair = 0;
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				g2D.setPaint(Color.LIGHT_GRAY);
				if (pair % 2 == 0) {

					g2D.setStroke(new BasicStroke(2));
					// Centre du cercle
					g2D.fillOval(((j + 1) * caseLargeur) + (caseLargeur / 2) - marge,
							((i + 1) * caseLargeur) + (caseLargeur / 2) - marge, marge, marge);
					// Cercle = Case
					g2D.drawOval((j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				} else {
					g2D.drawOval((j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				}
				pair++;
			}
		}
		// le cadre
		g2D.setPaint(Color.LIGHT_GRAY);
		g2D.setStroke(new BasicStroke(2)); // largeur 2 pixels

		g2D.draw(new RoundRectangle2D.Double(caseLargeur - marge, caseLargeur - marge,
				(caseLargeur * this.nbColonnes) + marge, (caseLargeur * this.nbLignes) + marge, caseLargeur,
				caseLargeur));

	}

	public void remplirPlateau(Graphics2D g2D) {
		// chargement image
		Image image = null;
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				if (jeu.estOccupe(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc
						image = lisImage("pionBlanc.png");
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion noir
						image = lisImage("pionNoir.png");
					}
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
					
				} else if (jeu.estOccupeAvecBalle(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc avec balle
						image = lisImage("pionBlancBall.png");
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion noir avec balle
						image = lisImage("pionNoirBall.png");
					}
					tracer(g2D, image, (j + 1) * caseLargeur, (i + 1) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				}
			}
		}
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

	@Override
	public void ajouteObservateur(Observateur o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void metAJour() {
		// TODO Auto-generated method stub

	}

	
}
