package Moteur;

/*-Cette classe modelise le plateau du jeu
 *-Elle contient essentiellement :
 *  - un tableau de cases qui une matrice largeur*hauteur
 * 	- une fonction d'acces à une case qui est un objet
 * 	- une fonction d'accès dimensions du plateau
 *-Le joueur 0 est juste fictif juste une façon de gérer la case libre
 * **/
import java.util.Random;
import java.util.Scanner;

public class JeuPlateau {
	static final int LIBRE = 0;
	static final int OC_BALLE = 1;
	static final int OCCUPE = 2;
	private Joueur [] joueurs = new Joueur [2];
	private int disposition;
	private int largeur;
	private int hauteur;
	Case [][] cases;
	
	public JeuPlateau (Joueur j1,Joueur j2,int disposition) {
		this.largeur = 7;
		this.hauteur = 7;
		this.cases = new Case [this.largeur][this.hauteur];
		this.joueurs [0] = j1;
		this.joueurs [1] = j2;
		this.disposition = disposition;
		init (this.largeur,this.hauteur,this.disposition);
	}

	//renvoie un objet de type case de la collections de cases en fonction
	//des indices fournies
	public Case getCase (int i,int j) {
		return this.cases [i][j];
	}

	//renvoie lar largeur du plateau
	private int getLargeur () {return this.largeur;}
	
	//renvoie la hauteur du plateau
	private int getHauteur () {return this.hauteur;}
	
	
	int place (int va) {
		Random r = new Random ();
		int val;
		while ((val = r.nextInt (hauteur)) == va);
		return val;
	}
	void placeJAverse (int disposition) {
        switch (disposition) {
            case 1:
				break;
			case 2:
				cases [0][1] = new Case (joueurs [1],OCCUPE);
                cases [0][5] = new Case (joueurs [1],OCCUPE);
                cases [largeur - 1][1] = new Case (joueurs [0],OCCUPE);
                cases [largeur - 1][5] = new Case (joueurs [0],OCCUPE);
                break;
        }
    }
	/**modifié**/
	public void init (int l,int h,int disposition) {
		int etat = LIBRE;
		Random r = new Random ();
		int val;
		boolean e1 = false,e2 = false;
		Joueur jr = new Joueur (0,"Aucun");
		for (int i = 0; i < l ; i ++) {
			for (int j = 0; j < h ; j ++) {
				etat = OCCUPE;
				if (j == h/2) etat = OC_BALLE;
				if (i == 0) jr = joueurs [0];
				else if (i == l - 1) jr = joueurs [1];
				else {
					jr = new Joueur (0,"Aucun"); etat = LIBRE;
				}
				cases [i][j] = new Case (jr,etat);
			}
		}
		placeJAverse (disposition);
	}
	/**modifié**/
	void afficherPlateau () {
		for (int i = 0; i < this.largeur ; i ++) {
			for (int j = 0; j < this.hauteur ; j ++) {
				if (getCase (i,j).getEtat () == OCCUPE && getCase (i,j).getJoueur().getNum () == 1)
					System.out.print ("XX ");
				else if (getCase (i,j).getEtat () == OC_BALLE && getCase (i,j).getJoueur().getNum () == 1)
					System.out.print ("XB ");
				else if (getCase (i,j).getEtat () == OCCUPE && getCase (i,j).getJoueur().getNum () == 2)
					System.out.print ("YY ");
				else if (getCase (i,j).getEtat () == OC_BALLE && getCase (i,j).getJoueur().getNum () == 2)
					System.out.print ("YB ");
				else System.out.print(".. ");
			}
			System.out.println ();
		}
	}

	/**TO DO: Il Faut gérer le lancement de la balle
	 * Mdofier la fonction pour qu'elle renvoie un boolean en fonction que le coup soit valide
	 * ou pas**/
	public boolean joueCoup (Joueur joueur,int action,int x,int y) {
		boolean etat = false;
		System.out.println ("nom et num:"+joueur.getNom ()+"et "+joueur.getNum ());
		System.out.println ("occupant de la case ="+getCase (x,y).getJoueur ().getNum ());
		if (joueur.getNum () != getCase (x,y).getJoueur ().getNum ()) {
			System.out.println ("!!!!Vous ne pouvez pas déplacer un pion adverse ou case sélectionner vide");
			etat = false;
		} else {
			if (getCase (x,y).getEtat () == OC_BALLE) {//si c'est la balle
				System.out.println ("Lancement de la balle");
				System.out.println ("Entrez les coordonnées de destinations");
				Scanner scan = new Scanner (System.in);
				int destX,destY;
				destX = scan.nextInt (); 
				destY = scan.nextInt ();
				etat = lancerBalleVers (x,y,destX,destY,joueur);
			} else if (getCase (x,y).getEtat () == OCCUPE) {//Déplacement d'un pion
				etat = deplacerVers (action,joueur,x,y);
			}
		}
		return etat;
	}
	
	boolean testENJr (int i,int j,Joueur joueur) {
		if (cases [i][j].getEtat () == LIBRE ||	(cases [i][j].getEtat () == OCCUPE 
			&& joueur == cases [i][j].getJoueur ()))
			return true;
		return false;
	}
	boolean verifVertical (int x,int y,int destX,Joueur joueur) {
		int i = x,j = y;
		if (x < destX) {//descente
			i += 1;
			while (i < destX && (testENJr (i,j,joueur))) i ++;
		} else if (x > destX) {//montée
			i -= 1;
			while (i > destX && (testENJr (i,j,joueur))) i --;
		}
		return i == destX;
	}
	boolean verifHorizontal (int x,int y,int destY,Joueur joueur) {
		int i = y,j = x;
		//à l'horizontal
		if (destY < y) {//gauche
			i -= 1;
			while (i > destY && (testENJr (i,j,joueur))) i --;
		} else if (destY > y) {//droite
			i += 1;
			while (i < destY && (testENJr (i,j,joueur))) i ++;
		}
		return i == destY;
	}
	boolean verifDiagonal (int x,int y,int destX,int destY,Joueur joueur) {
		int i =  x,j = y;
		if (destX < x && destY < y) {//cas montée vers la gauche
			i -= 1;j -=1;
			while ((i > destX && j > destY) && (testENJr (i,j,joueur))) {i --;j --;}
		} else if (destX < x && destY > y) {//cas montée vers la droite
			i -= 1;j += 1;
			while ((i > destX && j < destY) && (testENJr (i,j,joueur))) {i --;j ++;}
		} else if (x < destX && y > destY) {//cas descente vers la gauche
			i += 1; j -= 1;
			while ((i < destX && j > destY) && (testENJr (i,j,joueur))) {i ++; j --;}
		} else if (x < destX && y < destY) {//cas descente vers la droite
			i += 1; j += 1;
			while ((i < destX && j < destY) && (testENJr (i,j,joueur))) {i ++; j ++;}
		}
		return i ==  destX || j == destY;
	}
	//Cette fonction vérie si on peut lancer ou pas la balle à (destX,destY)
	//elle utilise les fonctions verifVer....
	boolean verifieDest (int x,int y,int destX,int destY , Joueur joueur) {
		if ((joueur.getNum() != getCase(destX,destY).getJoueur().getNum())) return false;
		if (y == destY) {
			//Déplacement vértical
			return verifVertical (x,y,destX,joueur);
		} else if (x == destX) {
			//horizontal
			return verifHorizontal (x,y,destY,joueur);
		} else {
			//déplacement diagonal
			return verifDiagonal (x,y,destX,destY,joueur);
		}
	}
	//lance la balle du même x,y vers (destX,destY)
	public boolean lancerBalleVers (int x,int y,int destX,int destY,Joueur joueur) {
		 if (!verifieDest (x,y,destX,destY,joueur)) {
			 System.out.println ("pas possible de joueur là");
			 return false;
		 } else {
			System.out.println ("Vous avez joueur");
			getCase (destX,destY).setEtat (OC_BALLE);
			getCase (x,y).setEtat (OCCUPE);
			return true;
		 }
	}
	void modifeCase (int x,int y,int dX,int dY,Joueur joueur) {
		getCase (dX,dY).setJoueur (joueur);
		getCase (dX,dY).setEtat (OCCUPE);
		getCase (x,y).setJoueur (new Joueur (0,"Aucun"));
		getCase (x,y).setEtat (LIBRE);
	}

	/**TO DO:Cette fonction doit être modifier pour renvoyer un boolean en fonction que
	 * ça soit permis le déplacement ou pas**/
	 //cette fontion déplace le pion (x,y) vers la gauche,la droite,devant
	 boolean deplacerVers (int action,Joueur joueur,int x,int y) {
		int dX = 0,dY = 0;
		boolean etat = false;
		if (action == 0) {//Avancer
			if (joueur.getNum () == 1 && (x+1) <  hauteur && getCase (x+1,y).getEtat () == LIBRE) {
				etat = true;dX = x + 1; dY = y;
			} 
			else if (joueur.getNum () == 2 && 0 <= (x - 1) && (x - 1) < hauteur && getCase (x - 1,y).getEtat () == LIBRE) {
				etat = true;dX = x - 1;dY = y;
			} 
			else {
				System.out.println ("Impossible d'avancer"); etat = false;
			}
		} 
		else if (action == 1) {//Gauche
			if ((joueur.getNum () == 1) && y < largeur && getCase (x,y+1).getEtat () == LIBRE) {
				etat = true; 
				dX = x; 
				dY = y + 1;
			} 
			else if ((joueur.getNum () == 2) && y > 0	&& getCase (x,y-1).getEtat () == LIBRE) {
				etat = true; 
				dX = x; 
				dY = y - 1;
			} 
			else {
				System.out.println ("Impossible d'aller à gauche"); 
				etat = false;
			}
		} else if (action == 2) {//Droite
			if ((joueur.getNum () == 1) && y - 1 >= 0 && getCase (x,y-1).getEtat () == LIBRE) {
								//on diminue y de 1
				etat = true; 
				dX = x; 
				dY = y - 1;
			} 
			else if ((joueur.getNum () == 2)	&& getCase (x,y+1).getEtat () == LIBRE) {
				etat = true; 
				dX = x; 
				dY = y + 1;
			} 
			else {
				System.out.println ("Impossible d'aller à droite"); etat = false;
			}
		} 
		else if (action == 3) {//Arrière
		} 
		else if (action == 5) {
		}
		if (etat == true)
			modifeCase (x,y,dX,dY,joueur);
		return etat;
	 }	
	
	/****Gestion Vainqueur**/
	int jOCBALLE (int i) {
		int j = 0;
		while (j < this.hauteur && cases [i][j].getEtat () != OC_BALLE) j ++;
		return j;
	}
	void vainqueur (int i,int j) {
		System.out.println ("Bravo "+cases [i][j].getJoueur ().getNom ()+":"+
		cases [i][j].getJoueur ().getNum ()+" vous avez gagné ");
	}
	//Cette fonction vérifie s'il y a un vainqueur et affiche le vainqueur à chaque coup joué
	boolean joueurXGagne () {
		boolean etat;
		int j = jOCBALLE (0);
		//on vérifie sur la ligne 0 camps du joueur 1
		if (j < hauteur && cases [0][j].getJoueur ().getNum () == 2) {
			vainqueur (0,j);
			return true;
		}
		j = jOCBALLE (largeur - 1);
		if (j < hauteur && cases [largeur - 1][j].getJoueur ().getNum () == 1) {
			vainqueur (largeur - 1,j);
			return true;
		}
		return false;
	}

	public boolean estOccupe(int i, int j) {
		// TODO Auto-generated method stub
		return getCase(i, j).getEtat() == OCCUPE;
	}

	public boolean estOccupeAvecBalle(int i, int j) {
		// TODO Auto-generated method stub
		return getCase(i, j).getEtat() == OC_BALLE;
	}
}
