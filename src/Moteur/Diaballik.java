package Moteur;
import java.util.Scanner;

public class Diaballik {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println ("Entrez nom1:");
		String nom1 = scan.nextLine ();
		System.out.println ("Entrez nom2:");
		String nom2 = scan.nextLine ();
		Partie partie = Partie.getInstance();
		partie.init(new JoueurHumain (1,nom1),new JoueurHumain (2,nom2),0);
		partie.joue ();
	}
}
