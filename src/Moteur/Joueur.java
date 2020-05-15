package Moteur;

import java.util.ArrayList;

public class Joueur {
	private int num;
	private String nom;
	private ArrayList<Pion> pions;
	
	public Joueur (int num,String nom) {
		this.num = num;
		this.nom = nom;
		
	}
	public int getNum () {
		return this.num;
	}
	public String getNom () {
		return this.nom;
	}
	public ArrayList<Pion> getPions(){
		return this.pions;
	}
	// Sélectionner un pion à partir des ses coordonnées
	public Pion selectionnerPion(int i, int j) {
		for(Pion p : pions) {
			if(i == p.getX() && j == p.getY()) {
				p.setEstSelectionne(true);
				return p;
			}
		}
		return null;
	
	}
	
	public void deplacerPion(int xDepart, int yDepart, int xArrivee, int yArrivee) {
		Pion p = this.selectionnerPion(xDepart, yDepart);
		if(!p.estPionAvecBalle()) {
			p.setX(xArrivee);
			p.setY(yArrivee);
		}
	}
	
	public void joue (JeuPlateau jeu) {}
	public void joue2(JeuPlateau jeu, int x, int y, int or) {
		
	}
}
