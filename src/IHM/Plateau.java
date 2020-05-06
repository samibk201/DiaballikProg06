package IHM;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Moteur.JeuPlateau;
import Moteur.Joueur;

public class Plateau extends JComponent {
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int hauteur;
	private int largeur = hauteur = 7;
	private final int CASE_LARGEUR = 100;
	private Image imgPionJ1SurCase, imgPionJ2SurCase, imgPionJ1AvecBalle,
			imgPionJ2AvecBalle;
	JeuPlateau jeuPlateau ;
	Joueur j1, j2;
	/*private String[][] pions = { 
								{"B","B","B","L","B", "B", "B"},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{"N", "N", "N", "O", "N", "N", "N"},
								};*/

	public Plateau() {
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
		j1 = new Joueur(1, "Cisse");
		j2 = new Joueur(2, "Dan");
		
		
		jeuPlateau = new JeuPlateau(j1, j2, 0);
	
		
		jeuPlateau.init(7,7,0);
	}

	private Image lisImage(String nom) {
		Image img = null;
		try {
			img = ImageIO.read(new File("src/IHM/Images/" + nom));
		} catch (IOException io) {
			System.out.println("Chargment de l'image " + nom + " Impossible");
			System.exit(1);
		}
		return img;
	}

	private void tracer(Graphics2D g2D, Image i, int x, int y, int l, int h) {
		g2D.drawImage(i, x, y, l, h, this);
	}
	


	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		// ImageIcon img = null;
		boolean aUnPoint = true;
		int pair = 0;

		// les cases
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				g2D.setPaint(Color.LIGHT_GRAY);
				if (pair % 2 == 0) {

					g2D.setStroke(new BasicStroke(2));
					// Centre du cercle
					g2D.fillOval(((j + 1) * CASE_LARGEUR) + (CASE_LARGEUR / 2) - 10,
							((i + 1) * CASE_LARGEUR) + (CASE_LARGEUR / 2) - 10, 10, 10);
					// Cercle = Case
					g2D.drawOval((j + 1) * CASE_LARGEUR, (i + 1) * CASE_LARGEUR, CASE_LARGEUR - 10, CASE_LARGEUR - 10);
				} else {
					g2D.drawOval((j + 1) * CASE_LARGEUR, (i + 1) * CASE_LARGEUR, CASE_LARGEUR - 10, CASE_LARGEUR - 10);
				}
				pair++;
			}
		}

		// le cadre
		g2D.setPaint(Color.LIGHT_GRAY);
		g2D.setStroke(new BasicStroke(2)); // largeur 2 pixels

		g2D.draw(new RoundRectangle2D.Double(CASE_LARGEUR - 10, CASE_LARGEUR - 10, (CASE_LARGEUR * this.largeur) + 10,
				(CASE_LARGEUR * this.hauteur) + 10, 100, 100));
		
		// chargement image
		Image image = null;
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				if(jeuPlateau.getCase(i, j).getEtat() == 2)  {
					if(jeuPlateau.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc
						image = lisImage("pionBlanc.png");
					}else if(jeuPlateau.getCase(i, j).getJoueur().getNum() == 2) { // pion noir
						image = lisImage("pionNoir.png");		
					}
					tracer(g2D, image, (j+1)*CASE_LARGEUR, (i+1)*CASE_LARGEUR, CASE_LARGEUR-10, CASE_LARGEUR-10);
				}
				else if(jeuPlateau.getCase(i, j).getEtat() == 1)  {
					if(jeuPlateau.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc
						image = lisImage("pionBlancBall.png");
					}else if(jeuPlateau.getCase(i, j).getJoueur().getNum() == 2) { // pion noir
						image = lisImage("pionNoirBall.png");
					}
					tracer(g2D, image, (j+1)*CASE_LARGEUR, (i+1)*CASE_LARGEUR, CASE_LARGEUR-10, CASE_LARGEUR-10);
				}
			}
		}
	
		// Libère toutes les ressources d'écran natives utilisées par cette fenêtre, ses
		// sous-composants et tous ses enfants possédés.
		g2D.dispose();
	}

}
