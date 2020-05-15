package Moteur;

/*-Cette classe gère les informations d'une case:
 * l'attribut joueur pour indiquer le N° du joueur
 * l'attribut etat donne des informations sur la case (Occupée,libre , pions avec une balle)
 *-Un constructeur pour initialiser les attributs
 *-Des getters et setters pour l'accès et la modification des attributs
 * */
public class Case {	
	private Joueur joueur;
	private int etat;
	static final int LIBRE = 0;
	static final int OC_BALLE = 1;
	static final int OCCUPE = 2;
	
	//Constructeur
	public Case (Joueur joueur,int etat) {
		this.joueur = joueur;
		this.etat = etat;
	}

	public Case (int etat) {
		this.etat = etat;
	}

	//récupère le numéro du joueur
	public Joueur getJoueur () {
		return this.joueur;
	}

	//modifie le joueur
	public void setJoueur (Joueur joueur) {
		this.joueur = joueur;
	}

	//renvoie l'état de la case
	public int getEtat () {
		return this.etat;
	}
	
	//modifie l'état d'une case
	public void setEtat (int etat) {
		this.etat = etat;
	}
	
	public boolean estLibre(int i, int j) {
		return this.etat == LIBRE;
	}
	
	public boolean estOccupe(int i, int j) {
		// TODO Auto-generated method stub
		return this.etat == OCCUPE;
	}

	public boolean estOccupeAvecBalle(int i, int j) {
		// TODO Auto-generated method stub
		return this.etat == OC_BALLE;
	}
}
