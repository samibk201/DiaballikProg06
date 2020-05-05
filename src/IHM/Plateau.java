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

public class Plateau extends JComponent {
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int hauteur;
	private int largeur = hauteur = 7;
	private final int CASE_LARGEUR = 100;
	private Image imgCaseSansPoint, imgCaseAvecPoint, imgPionJ1SurCase, imgPionJ2SurCase, imgPionJ1AvecBalle,
			imgPionJ2AvecBalle;
	private String[][] pions = { 
								{"B","B","B","L","B", "B", "B"},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null},
								{"N", "N", "N", "O", "N", "N", "N"},
								};

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
		imgCaseSansPoint = lisImage("vide.png");
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
	
	//private void cha

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

				// g2D.fill(new Rectangle2D.Double((j+1) * CASE_LARGEUR,(i+1) * CASE_LARGEUR,
				// CASE_LARGEUR, CASE_LARGEUR));
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
				if(pions[i][j] != null) {
					if(pions[i][j].charAt(0) == 'B') { // pion blanc
						image = lisImage("pionBlanc.png");
					}else if(pions[i][j].charAt(0) == 'L') { // pion blanc avec balle
						image = lisImage("pionBlancBall.png");
					}else if(pions[i][j].charAt(0) == 'N') { // pion noir
						image = lisImage("pionNoir.png");		
					}else if(pions[i][j].charAt(0) == 'O') { // pion noir avec une balle
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
