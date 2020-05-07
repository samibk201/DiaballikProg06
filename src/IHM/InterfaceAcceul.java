package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InterfaceAcceul extends JPanel{

    public Button unJoueur;
    public Button deuxJoueur;
    public Button enCours;
    public Button tutoriel;
    public Button quit;

    InterfaceAcceul() {
        super();
    }

    public void init() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // acceuil.setLayout(new BoxLayout(acceuil, BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(53, 79, 82));
        this.setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);

        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.unJoueur = new Button("ressources/ButtonImage/jVSjSR(1).png");
        this.deuxJoueur = new Button("ressources/ButtonImage/jVSiaSR.png");
        this.enCours = new Button("ressources/ButtonImage/encoursSR.png");
        this.tutoriel = new Button("ressources/ButtonImage/tutorielSR.png");
        this.quit = new Button("ressources/ButtonImage/btnquitSR.png");

        this.add(unJoueur);
        this.add(deuxJoueur);
        this.add(enCours);
        this.add(tutoriel);
        this.add(quit);
    }
}
