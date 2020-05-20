package Moteur;

//Disposition gère le plateau initial
//0:Aucun joueur adverse dans un camp
//1:Un joueur adverse dans un camp adverse
//2:Deux joueurs adverses dans un camp adverse
public class Partie {
	private Joueur [] joueurs = new Joueur [2];
	private JeuPlateau jeu;
	private int disposition;
	
	public Partie (Joueur joueur1,Joueur joueur2,int disposition) {
		joueurs [0] = joueur1;
		joueurs [1] = joueur2;
		this.disposition = disposition;
		jeu = new JeuPlateau (joueur1,joueur2,disposition);
	}
	/**TO DO:il va falloir gérer ici lorsqu'il y a un gagnat pour arrêter le jeu
	 * On peut gérer cette fonction dans JeuPlateau
	 * -idée de solution de la fonction
	 *  A chaque coup jouer on vérifie :
	 * si sur la première ligne il y a une balle du joueur 2
	 *   Dans ce cas le joeur 2 à gagner
	 * de meme si sur la dernière ligne il y a la balle du joueur 1
	 *   Dansc ce cas le joueur 1 à gagner
	 * **/
	public void joue () {
		while (!jeu.joueurXGagne ()) {
			joueurs [0].joue (jeu);
			joueurs [1].joue (jeu);
		}
	}
}
