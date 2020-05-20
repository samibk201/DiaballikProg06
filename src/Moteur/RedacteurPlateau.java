package Moteur;

import java.io.OutputStream;
import java.io.PrintStream;

public class RedacteurPlateau
{
    PrintStream sortie;

    public RedacteurPlateau(OutputStream out)
    {
        sortie = new PrintStream(out);
    }


    public void ecrisPlateau(JeuPlateau p, Joueur j1, Joueur j2)
    {
        sortie.println(j1.getNum()+" "+j1.getNom());
        sortie.println(j2.getNum()+" "+j2.getNom());
        for(int i=0; i<p.getLargeur(); i++)
        {
            for(int j=0; j<p.getHauteur(); j++)
            {
                if(!p.estOccupe(i, j) && !p.estOccupeAvecBalle(i, j))
                    sortie.print("..");
                else
                {
                    if(p.getCase(i, j).getJoueur().getNum() == 0 && p.estOccupeAvecBalle(i, j))
                        sortie.print("YB");
                    else if(p.getCase(i, j).getJoueur().getNum() == 1 && p.estOccupeAvecBalle(i, j))
                        sortie.print("XB");
                    else if(p.getCase(i, j).getJoueur().getNum() == 1)
                        sortie.print("XX");
                    else
                        sortie.print("YY");
                }
                sortie.print(' ');
            }
            sortie.println();
        }
        sortie.println();

    }
}
