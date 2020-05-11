package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceAccueil extends JPanel{

    public Button unJoueur;
    public Button deuxJoueur;
    public Button enCours;
    public Button tutoriel;
    public Button quit;

    JLabel title;

    InterfaceAccueil() {
        super();
    }

    public void init() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // acceuil.setLayout(new BoxLayout(acceuil, BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(53, 79, 82));
        this.setBounds(0, 0, screen.width, screen.height);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        title = new JLabel();
        title.setIcon(new ImageIcon("ressources/ButtonImage/diaballik.png"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.unJoueur = new Button("ressources/ButtonImage/jVSjSR(1).png");
        unJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.deuxJoueur = new Button("ressources/ButtonImage/jVSiaSR.png");
        deuxJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.enCours = new Button("ressources/ButtonImage/encoursSR.png");
        enCours.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.tutoriel = new Button("ressources/ButtonImage/tutorielSR.png");
        tutoriel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quit = new Button("ressources/ButtonImage/btnquitSR.png");
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(unJoueur);
        this.add(deuxJoueur);
        this.add(enCours);
        this.add(tutoriel);
        this.add(quit);
    }
}
