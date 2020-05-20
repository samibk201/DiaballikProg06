package Moteur;
import java.util.Scanner;
class Diabalik {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println ("Entrez nom1:");
		String nom1 = scan.nextLine ();
		System.out.println ("Entrez nom2:");
		String nom2 = scan.nextLine ();
		Partie partie = new Partie (new JoueurHumain (1,nom1),new JoueurHumain (2,nom2),1);
		partie.joue ();
	}
}
