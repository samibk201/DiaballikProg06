package Ia;

import java.util.List;

public class JoueurMiniMax extends JoueurOffensif {
    
    private int profondeur;
    private Coup meilleurCoup;

    public JoueurMiniMax(Configuration conf, int profondeur) {
        super(conf);
        this.profondeur = profondeur;
        this.meilleurCoup = null;
    }

    @Override
    public Coup choisirCoup(int joueur) {
        // Coup meilleurCoup = null;

        miniMax(profondeur, Integer.MIN_VALUE, Integer.MAX_VALUE, true, joueur);

        return meilleurCoup;
    }

    public int miniMax(int profondeur, int alpha, int beta, boolean estMax, int joueur) {
        List<Coup> coups;
        int meilleurScore, scoreCoup;

        if(profondeur == 0 || estFin())
            return evaluation(joueur);

        coups = plateau.getCoupsPossible(joueur);


        if (estMax) {
            meilleurScore = Integer.MIN_VALUE;

            for (Coup coup : coups) {

                plateau.jouer(coup);
                scoreCoup = miniMax(profondeur-1, alpha, beta, !estMax, joueur%4+2);
                plateau.annuler(coup);

                if(scoreCoup > meilleurScore) {
                    meilleurScore = scoreCoup;
                    meilleurCoup = coup.copier();
                }
                alpha = Integer.max(alpha, meilleurScore);

                if(beta <= alpha) {
                    System.out.println("alpha cut in MAX turn");
                    break;
                }
            }

            return meilleurScore;
            

        } else {
            meilleurScore = Integer.MAX_VALUE;

            for (Coup coup : coups) {

                plateau.jouer(coup);
                scoreCoup = miniMax(profondeur-1, alpha, beta, !estMax, joueur%4+2);
                plateau.annuler(coup);

                if(scoreCoup < meilleurScore) {
                    meilleurScore = scoreCoup;
                    meilleurCoup = coup.copier();
                }

                alpha = Integer.min(alpha, meilleurScore);

                if(beta <= alpha) {
                    System.out.println("alpha cut in MIN turn");
                    break;
                }
            }

            return meilleurScore;



        }
        
    }

    public int evaluation(int joueur) {
        if(plateau.aBilleAuBut(joueur))
            return Integer.MAX_VALUE;
        if(plateau.aBilleAuBut(joueur%4+2))
            return Integer.MIN_VALUE;
        if(plateau.aGangeContreJeu(joueur))
            return Integer.MAX_VALUE;
        if(plateau.aGangeContreJeu(joueur%4+2))
            return Integer.MAX_VALUE;

        return evalPosition(joueur) - evalPosition(joueur%4+2);
    }

    public boolean estFin() {
        return (
            plateau.aBilleAuBut(Plateau.JOUEUR_A) || plateau.aBilleAuBut(Plateau.JOUEUR_B) ||
            plateau.aGangeContreJeu(Plateau.JOUEUR_A) || plateau.aGangeContreJeu(Plateau.JOUEUR_B)
        );
    }

}