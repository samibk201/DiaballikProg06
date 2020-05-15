package IHM;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Moteur.JeuPlateau;
import Moteur.Joueur;
import Moteur.JoueurHumain;
import Moteur.Partie;
import Pattern.Observable;
import Pattern.Observateur;;

@SuppressWarnings("serial")
public class PlateauGraphique extends JComponent implements MouseListener, Observable {
	private int nbColonnes;
	private int nbLignes = nbColonnes = 7;
	private int caseLargeur;
	private int caseHauteur = caseLargeur = 100;
	private int marge = caseLargeur / 10;
	private Image imgPionJ1, imgPionJ2, imgPionJ1AvecBalle, imgPionJ2AvecBalle;
	Partie partie;

	JeuPlateau jeu;
	private ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
	private int dx;
	private int dy;
	private boolean aFaitAction;
	public boolean aucunPionSelectionne;
	Image image = null;
	/*
	 * private String[][] pions = { {"B","B","B","L","B", "B", "B"}, {null, null,
	 * null, null, null, null, null}, {null, null, null, null, null, null, null},
	 * {null, null, null, null, null, null, null}, {null, null, null, null, null,
	 * null, null}, {null, null, null, null, null, null, null}, {"N", "N", "N", "O",
	 * "N", "N", "N"}, };
	 */

	public PlateauGraphique(JeuPlateau j) {
		// Joueur j1 = new Joueur(0, "Dan");
		// Joueur j2 = new Joueur(1, "Cissé");
		// int disposition = 0;
		// partie = Partie.getInstance();
		// partie.init(j1, j2, disposition);

		// this.jeu = partie.getJeu();
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
		this.jeu = j;
		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(caseLargeur*nbColonnes, caseHauteur*nbLignes));
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

	public int marge() {
		return this.marge;
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
		for (int i = 0; i < this.nbColonnes; i++) {
			for (int j = 0; j < this.nbLignes; j++) {
				g2D.setPaint(Color.LIGHT_GRAY);
				if (pair % 2 == 0) {

					g2D.setStroke(new BasicStroke(2));
					// Centre du cercle
					g2D.fillOval(((j) * caseLargeur) + (caseLargeur / 2) - marge,
							((i) * caseLargeur) + (caseLargeur / 2) - marge, marge, marge);
					// Cercle = Case
					g2D.drawOval((j ) * caseLargeur, (i ) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				} else {
					g2D.drawOval((j) * caseLargeur, (i) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);
				}
				pair++;
			}
		}
		// le cadre
		g2D.setPaint(Color.LIGHT_GRAY);
		g2D.setStroke(new BasicStroke(2)); // largeur 2 pixels

		g2D.draw(new RoundRectangle2D.Double(0, 0,
				(caseLargeur * this.nbColonnes) + marge, (caseLargeur * this.nbLignes) + marge, caseLargeur,
				caseLargeur));

	}

	public void remplirPlateau(Graphics2D g2D) {
		// chargement image
		
		for (int i =0; i < this.nbColonnes; i++) {
			for (int j = 0; j < this.nbLignes; j++) {
				if (jeu.getCase(i, j).estOccupe(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc
						image = lisImage("pionBlanc.png");
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion noir
						image = lisImage("pionNoir.png");
					}
					tracer(g2D, image, (j) * caseLargeur, (i) * caseLargeur, caseLargeur - marge,
							caseLargeur - marge);

				} else if (jeu.getCase(i, j).estOccupeAvecBalle(i, j)) {
					if (jeu.getCase(i, j).getJoueur().getNum() == 1) { // pion blanc avec balle
						image = lisImage("pionBlancBall.png");
					} else if (jeu.getCase(i, j).getJoueur().getNum() == 2) { // pion noir avec balle
						image = lisImage("pionNoirBall.png");
					}
					tracer(g2D, image, (j) * caseLargeur, (i) * caseLargeur, caseLargeur - marge,
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
		this.observateurs.add(o);
	}

	@Override
	public void metAJour(int x, int y, int action) {
		// TODO Auto-generated method stub
		Iterator<Observateur> it;
		it = observateurs.iterator();
		while (it.hasNext()) {
			Observateur o = it.next();
			o.miseAJour(x, y, action);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if ((arg0.getX() > 0) && (arg0.getX() < this.largeurPlateau()) && (arg0.getY() > 0)
				&& (arg0.getY() < this.hauteurPlateau())) {
			int j = (arg0.getX() - this.marge()) / this.getCaseLargeur();
			int i = (arg0.getY() - this.marge()) / this.getCaseLargeur();
			if(jeu.getCase(i, j).estOccupe(i, j)) {
				aucunPionSelectionne = false;
				int action = 0;
				//this.metAJour(i, j, action);
				System.out.println("Pion select " + i + "  " + j);
				image = lisImage("pionClic.png");
				this.repaint();
				if(!aFaitAction) {
					
				}
			}else {
				System.out.println("case libre");
			}
			
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
