package IHM;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private int largeurCase = 100;
	private ImageIcon imgCaseSansPoint, imgCaseAvecPoint, imgPionJ1SurCase, imgPionJ2SurCase, imgPionJ1AvecBalle,
			imgPionJ2AvecBalle;

	public Plateau() {
		imgCaseSansPoint = new ImageIcon(getClass().getResource("vide.png"));
		imgCaseAvecPoint = new ImageIcon(getClass().getResource("vide.png"));
		imgPionJ1SurCase = new ImageIcon(getClass().getResource("vide.png"));
		imgPionJ2SurCase = new ImageIcon(getClass().getResource("vide.png"));
		imgPionJ1AvecBalle = new ImageIcon(getClass().getResource("vide.png"));
		imgPionJ2AvecBalle = new ImageIcon(getClass().getResource("vide.png"));

	}
	

	private Image lisImage(String nom) {
		Image img = null;
		try {
			img = ImageIO.read(new File("IHM/Images/" + nom));
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
		ImageIcon img = null;
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				int x, y;
				y = j * largeurCase;
				x = i * largeurCase;
				
				img.paintIcon(null, g2D, x, y);
				
			}
		}
	}

}
