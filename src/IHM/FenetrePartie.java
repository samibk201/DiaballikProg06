package IHM;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import Moteur.*;

@SuppressWarnings("serial")
public class FenetrePartie extends JComponent implements Runnable {
	
	Joueur j1, j2;
	int disposition;
	private int largeurFenetre = 1200;
	private int hauteurFenetre = 1000;
	
	
	PlateauGraphique plateauGraphique;
	//ImagePion imgPion = null;
	private JToggleButton IA1;
	private JToggleButton IA2;
	private JToggleButton son;
	private JButton help;
	private JButton retour;
	private JFrame frame;
	

	public FenetrePartie() { // d = disposition
		// TODO Auto-generated constructor stub
		
		
	}
	

	public static void demarrer() {

		SwingUtilities.invokeLater(new FenetrePartie());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame = new JFrame("Partie de Jeu");
		

		// Titre Boite Nord
		Box boiteNord = Box.createHorizontalBox();
		// Bouton retour page arrière
		retour = new JButton("Retour");
		// Bouton d'aideframe.setTitle(titre);
		help = new JButton("?");
		// Bouton d'activation sonore
		son = new JToggleButton("Son");

		// Boite de mise en ensemble des boutons retour, help et son
		Box retourHelpSon = Box.createHorizontalBox();
		retourHelpSon.add(retour);
		retourHelpSon.add(help);
		retourHelpSon.add(son);
		retourHelpSon.setAlignmentX(Component.LEFT_ALIGNMENT);

		//Label titre du jeu
		JLabel titreJeu = new JLabel("Diaballik");
		titreJeu.setAlignmentX(Component.CENTER_ALIGNMENT);

		// regroupement dans la boite nord
		boiteNord.add(retourHelpSon, BorderLayout.WEST);
		boiteNord.add(Box.createHorizontalGlue());
		boiteNord.add(titreJeu, BorderLayout.CENTER);
		boiteNord.add(Box.createHorizontalGlue());

		// Boite milieu
		Box boiteMilieu = Box.createHorizontalBox();
		// Texte et controles Boite gauche
		Box boiteMilieuGauche = Box.createVerticalBox();

		JLabel nomJoueur1 = new JLabel("Joueur 1");
		nomJoueur1.setAlignmentX(Component.CENTER_ALIGNMENT);
		boiteMilieuGauche.add(nomJoueur1);

		// Remplissage de l'espace entre le titre et les boutons

		// Contrôles comportementaux
		IA1 = new JToggleButton("IA");
		IA1.setAlignmentX(Component.CENTER_ALIGNMENT);
		IA1.setFocusable(false);
		boiteMilieuGauche.add(IA1);

		// Remplissage de l'espace entre le titre et les boutons
		Box boiteMilieuCentre = Box.createVerticalBox();
		PlateauGraphique plateau = new PlateauGraphique();
		plateau.setAlignmentX(Component.CENTER_ALIGNMENT);

		boiteMilieuCentre.add(plateau);

		// Texte et controles Boite droite
		Box boiteMilieuDroite = Box.createVerticalBox();

		JLabel nomJoueur2 = new JLabel("Joueur 2");
		nomJoueur2.setAlignmentX(Component.CENTER_ALIGNMENT);
		nomJoueur2.setAlignmentY(Component.CENTER_ALIGNMENT);
		boiteMilieuDroite.add(nomJoueur2);

		// Remplissage de l'espace entre le titre et les boutons
		// boiteMilieuGauche.add(Box.createGlue());

		// Contrôles comportementaux
		IA2 = new JToggleButton("IA");
		IA2.setAlignmentX(Component.CENTER_ALIGNMENT);
		//IA2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		IA2.setFocusable(false);
		boiteMilieuDroite.add(IA2);

		// Remplissage de l'espace entre le titre et les boutons
		//boiteMilieuDroite.add(Box.createGlue());

		// regroupement boite milieu
		boiteMilieu.add(boiteMilieuGauche, BorderLayout.WEST);
		boiteMilieu.add(boiteMilieuCentre, BorderLayout.CENTER);
		boiteMilieu.add(boiteMilieuDroite, BorderLayout.EAST);

		frame.add(boiteNord, BorderLayout.NORTH);
		
		frame.add(boiteMilieu, BorderLayout.CENTER);
		
		//frame.setTitle("Diaballik");
		frame.setSize(largeurFenetre, hauteurFenetre);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	public static void main(String[] args) {
		FenetrePartie.demarrer();
	}

}
