package Ia;

import java.util.Collections;
import java.util.Comparator;
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

        List<Coup> coups = getCoups(joueur);
        int score, scoreMeilleurCoup = Integer.MIN_VALUE;

        for (Coup coup : coups) {
            plateau.jouer(coup);
            score = miniMax(profondeur, Integer.MAX_VALUE, Integer.MIN_VALUE, true, joueur);
            plateau.annuler(coup);
            if(scoreMeilleurCoup < score) {
                scoreMeilleurCoup = score;
                meilleurCoup = coup.copier();
            }
        }

        return meilleurCoup;
    }

    public int miniMax(int profondeur, int alpha, int beta, boolean estMax, int joueur) {
        List<Coup> coups;
        int meilleurScore, scoreCoup;

        if(profondeur == 0 || estFin())
            return evaluation(joueur);

        // coups = plateau.getCoupsPossible(joueur);
        coups = getCoups(joueur);


        if (estMax) {
            meilleurScore = Integer.MIN_VALUE;

            for (Coup coup : coups) {

                plateau.jouer(coup);
                scoreCoup = miniMax(profondeur-1, alpha, beta, !estMax, joueur%4+2);
                plateau.annuler(coup);

                meilleurScore = Integer.max(meilleurScore, scoreCoup);
                alpha = Integer.max(alpha, meilleurScore);
                // if(alpha > meilleurScore) {
                //     meilleurCoup = coup.copier();
                // }

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

                meilleurScore = Integer.min(meilleurScore, scoreCoup);
                alpha = Integer.min(alpha, meilleurScore);
                // if(beta < meilleurScore) {
                //     meilleurCoup = coup.copier();
                // }

                // if(scoreCoup < meilleurScore) {
                //     meilleurScore = scoreCoup;
                //     meilleurCoup = coup.copier();
                // }


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

    private List<Coup> getCoups(int joueur) {
        List<Coup> coups = plateau.getCoupsPossible(joueur);
        Collections.sort(coups, new Comparator<Coup>() {
            @Override
            public int compare(Coup c1, Coup c2) {
                return evaluerCoup(joueur, c2) - evaluerCoup(joueur, c1);
            }
        });

        return coups;

    }

    private int evaluerCoup(int joueur, Coup coup) {
        int score = 0;
        int[] points = {5, 12, 21, 32, 45, 60, 77};
        for (Action action : coup.actions) {
            score += joueur==Plateau.JOUEUR_A ? points[action.posNouveau/7]-points[action.pos/7] : 
            points[6-action.posNouveau/7]-points[6-action.pos/7];
        }
        return score;
    }

}