package Moteur;

public class Joueur {
	private int num;
	private String nom;
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
	public void setNum (int num) {this.num = num;}
	public void setNom (String nom) {this.nom = nom;}
	public void joue (JeuPlateau jeu) {}
}
