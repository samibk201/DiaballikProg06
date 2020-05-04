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
	
	
	void init (int l,int h,int disposition) {
		//Au début seule la première et la dernière ligne sont occupées les autres sont vides
		//on commence donct mettre à vide les cases libres
		for (int i = 1; i < l - 1; i ++) {
			for (int j = 0; j < h ; j ++) {
				cases [i][j] = new Case (new Joueur (0,"Aucun"),LIBRE);
			}
		}
		Random r = new Random ();
		int val;
		switch (disposition) {
			case 0://aucun adverse pion dans un camps adverse
				//joueur 1
				for (int j = 0; j < h ; j ++)
					if (j == h / 2) cases [0][j] = new Case (joueurs [0],OC_BALLE);
					else cases [0][j] = new Case (joueurs [0],OCCUPE);
				//joueur 2
				for (int j = 0; j < h ; j ++) {
					if (j == h / 2) cases [l-1][j] = new Case (joueurs [1],OC_BALLE);
					else cases [l-1][j] = new Case (joueurs [1],OCCUPE);
				}
				break;
			case 1://un pion adverse dans un camps adverse
				//on considère toujours que le ballon est au millieu dans les deux camps
				for (int j = 0; j < h ; j ++)
					if (j == h / 2) cases [0][j] = new Case (joueurs [0],OC_BALLE);
					else cases [0][j] = new Case (joueurs [0],OCCUPE);
				//joueur 2
				for (int j = 0; j < h ; j ++) {
					if (j == h / 2) cases [l-1][j] = new Case (joueurs [1],OC_BALLE);
					else cases [l-1][j] = new Case (joueurs [1],OCCUPE);
				}
				//camps du joueur1
				while ((val = r.nextInt (h))  == h/2);
				cases [0][val] = new Case (joueurs [1],OCCUPE);
				//camps du joueur2
				while ((val = r.nextInt (h)) == h/2);
				cases [l-1][val] = new Case (joueurs [0],OCCUPE);
				break;
			case 2://deux pions étrangers dans chaque camps adverse
				break;
		}
	}
	void afficherPlateau () {
		for (int i = 0; i < this.largeur ; i ++) {
			for (int j = 0; j < this.hauteur ; j ++) {
				switch (getCase (i,j).getJoueur().getNum ()){
					case 1:
						if (getCase (i,j).getEtat () == OCCUPE) {
							System.out.print ("XX ");
						} else if (getCase (i,j).getEtat () == OC_BALLE) {
							System.out.print ("XB ");
						} else {
							System.out.print (".. ");
						}
						break;
					case 2:
						if (getCase (i,j).getEtat () == OCCUPE) {
							System.out.print ("YY ");
						} else if (getCase (i,j).getEtat () == OC_BALLE) {
							System.out.print ("YB ");
						} else {
							System.out.print (".. ");
						}
						break;
					default:System.out.print(".. ");
				}
			} System.out.println ();
		}
	}
	/**TO DO: Il Faut gérer le lancement de la balle
	 * Mdofier la fonction pour qu'elle renvoie un boolean en fonction que le coup soit valide
	 * ou pas**/
	boolean joueCoup (Joueur joueur,int action,int x,int y) {
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
				destX = scan.nextInt (); destY = scan.nextInt ();
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
	//vérifie si on peut lancer la balle à cette destination
	boolean verifieDest (int x,int y,int destX,int destY,Joueur joueur) {
		if ((joueur.getNum () != getCase (destX,destY).getJoueur ().getNum ())) return false;
		else if (y == destY) {
			//cas descente
			if (x < destX) {
				int i = x + 1,j = y;
				while (i < destX && (testENJr (i,j,joueur))) i ++;
				if (i != destX) return false;
			}
			//cas montée
			if (x > destX) {
				int i = x - 1,j = y;
				while (i > destX && (testENJr (i,j,joueur))) i --;
				if (i != destX) return false;
			}
		} else if (x == destX) {
			//à l'horizontal
			//cas gauche
			if (destY < y) {
				int i = y - 1,j = x;
				while (i > destY && (testENJr (i,j,joueur))) i --;
				if (i != destY) return false;
			}
			//cas droite
			if (destY > y) {
				int i = y + 1,j = x;
				while (i < destY && (testENJr (i,j,joueur))) i ++;
				if (i != destY) return false;
			}
		} else {
			//diagonale
			if (destX < x && destY < y) {//cas montée vers la gauche
				int i = x - 1,j = y - 1;
				while ((i > destX && j > destY) && (testENJr (i,j,joueur))) {i --;j --;}
				if (i != destX || j != destY) return false;
			} else if (destX < x && destY > y) {//cas montée vers la droite
				int i = x -1,j = y + 1;
				while ((i > destX && j < destY) && (testENJr (i,j,joueur))) {i --;j ++;}
				 if (i != destX || j != destY) return false;
			} else if (x < destX && y > destY) {//cas descente vers la gauche
				int i = x + 1,j = y - 1;
				while ((i < destX && j > destY) && (testENJr (i,j,joueur))) {i ++; j --;}
				 if (i != destX || j != destY ) return false;
			} else if (x < destX && y < destY) {//cas descente vers la droite
				int i = x + 1,j = y + 1;
				while ((i < destX && j < destY) && (testENJr (i,j,joueur))) {i ++; j ++;}
				if (i != destX || j != destY ) return false;
			}
		}
		return true;
	}
	boolean lancerBalleVers (int x,int y,int destX,int destY,Joueur joueur) {
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
	//cette fonction permet de déplacer un pion d'un joueur une fois
	//soit devant ,gauche,droite,arrière si possible
	boolean deplacerVers (int action,Joueur joueur,int x,int y) {
		int dX = 0,dY = 0;
		switch (action) {
					case 0://Avancer
					//on prend en considération le joueur
					//1-le joueur 1 est celui qui occupe le camps de la ligne 0 dans ce cas
					// pour avancer on augmente x de 1
					//2 - le joueur 2 occupe le camps de la dernière ligne l - 1 dans ce cas
					// pour avancer on diminue x de 1
					
						if (joueur.getNum () == 1) {
							//là on augmente la ligne et la colonne
							//et si la case de destination est libre on déplace le pion
							if (x+1 < hauteur && getCase (x+1,y).getEtat () == LIBRE) {
								modifeCase (x,y,x+1,y,joueur);
							} else {
								System.out.println ("Impossible d'avancer");
								return false;
							}
						} else if (joueur.getNum () == 2) {
							//la colonne reste la meme on diminue la ligne
							//on avance que si la case de destination est libre
							if (0 <= (x - 1) && (x - 1) < hauteur &&
								getCase (x - 1,y).getEtat () == LIBRE) {
								modifeCase (x,y,x-1,y,joueur);
							} else {
								System.out.println ("Impossible d'avancer");
								return false;
							}
						}
					break;
					case 1://Gauche
						//s'il s'agit du joeur 1
						if ((joueur.getNum () == 1) && y < largeur
							&& getCase (x,y+1).getEtat () == LIBRE) {
								//on diminue y de 1
								modifeCase (x,y,x,y+1,joueur);
						} else if ((joueur.getNum () == 2) && y > 0
							&& getCase (x,y-1).getEtat () == LIBRE) {
								modifeCase (x,y,x,y-1,joueur);
						} else {
							System.out.println ("Impossible d'aller à gauche");
							return false;
						}
						
					break;
					case 2://Droite
						//joueur1
						if ((joueur.getNum () == 1) && y - 1 > 0
							&& getCase (x,y-1).getEtat () == LIBRE) {
								//on diminue y de 1
								modifeCase (x,y,x,y-1,joueur);
						} else if ((joueur.getNum () == 2) && y > 0
							&& getCase (x,y+1).getEtat () == LIBRE) {
							modifeCase (x,y,x,y+1,joueur);
						} else {
							System.out.println ("Impossible d'aller à gauche");
							return false;
						}
					break;
					case 3://Arrière
						//joueur1
						if (joueur.getNum () == 1) {
							if (x == 0) {
								System.out.println ("Impossible de Reculer");
								return false;
							} else {
								dX = x -1; dY = y;
								if (getCase (dX,dY).getEtat () == LIBRE) {
									modifeCase (x,y,dX,dY,joueur);
								} else {
									System.out.println ("Impossible de Reculer");
									return false;
								}
							}
						} else if (joueur.getNum () == 2) {
							if (x == 6) {
								System.out.println ("Impossible de Reculer");
								return false;
							} else {
								dX = x + 1; dY = y;
								if (getCase (dX,dY).getEtat () == LIBRE) {
									modifeCase (x,y,dX,dY,joueur);
								} else {
									System.out.println ("Impossible de Reculer");
									return false;
								}
							}
						} else {
							System.out.println ("Impossible de Reculer");
							return false;
						}
					break;
				}
			return true;
	}	
	//S'il y a un gagnant
	boolean joueurXGagne () {
		int j = 0;
		while (j < this.hauteur && cases [0][j].getEtat () != OC_BALLE) j ++;
		if (j < this.hauteur && cases [0][j].getJoueur ().getNum () == 2) {
			System.out.println ("Bravo "+cases [0][j].getJoueur ().getNom ()+":"+
			cases [0][j].getJoueur ().getNum ()+" vous avez gagné ");	
			return true;
		}
		j = 0;
		while (j < this.hauteur && cases [this.largeur - 1][j].getEtat () != OC_BALLE) j ++;
		if (j < this.hauteur && cases [this.largeur -1][j].getJoueur ().getNum () == 1) {
			System.out.println ("Bravo "+cases [this.largeur - 1][j].getJoueur ().getNom ()+":"+
			cases [this.largeur - 1][j].getJoueur ().getNum ()+" vous avez gagné ");
			return true;
		}
		return false;
	}
}
