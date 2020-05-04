import java.util.Scanner;
class JoueurHumain extends Joueur {
	protected Scanner scan = new Scanner (System.in);
	public JoueurHumain (int num,String nom) {
		super (num,nom);
	}
	/**TODO
	 * -Il faudra faire des modifs pour gérer le fait qu'il veuille faire 3 actions
	 * -La gestion des coups invalides pour redonner la commande au joueur et
	 * Pour cela il faut changer le type de la fonction joueCoup dans JeuPlateau**/
	@Override
	public void joue (JeuPlateau jeu) {
		int x,y,or = 0;
		boolean etat = false;
		System.out.println ("Joueur "+this.getNum () + ":"+this.getNom ());
		jeu.afficherPlateau ();
		System.out.println ("Seléctionner un pion ou la balle à lancer");
		x = scan.nextInt ();y = scan.nextInt ();
		while (etat == false) {
			System.out.println ("Entrez une direction");
			System.out.println ("0-Pour avancer");
			System.out.println ("1-Gauche");
			System.out.println ("2-Droite");
			System.out.println ("3-Arrière");
			System.out.println ("4-Déplacement en diagonale");
			or = scan.nextInt ();
			etat = jeu.joueCoup (this,or,x,y);
			if (etat == false) {
				System.out.println (" Coup!!!!!!!Raté");
				jeu.afficherPlateau ();
			}		
		}
		System.out.println ("Vous voulez déplacer le pion ("+x+","+y+") vers "+or);
	}
}
