package IHM;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FenetrePartie extends JFrame {

	private int largeur = 1200;
	private int hauteur = 1000;
	private String titre = "Diaballik";
	JPanel conteneurPrincipal = new JPanel();
	JPanel panelNomJeu = new JPanel();
	JPanel panelBoutonsMenu = new JPanel();

	public FenetrePartie() {
		// TODO Auto-generated constructor stub
		this.setTitle(titre);
		this.setSize(largeur, hauteur);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		conteneurPrincipal.setLayout(new BorderLayout());
		JLabel labelTitre = new JLabel("Partie");
		panelNomJeu.add(labelTitre);

		conteneurPrincipal.add(panelNomJeu, BorderLayout.NORTH);
		Plateau plateau = new Plateau();
		plateau.setBounds(10, 10, 452, 465);
		conteneurPrincipal.add(plateau, BorderLayout.CENTER);

		this.setContentPane(conteneurPrincipal);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				FenetrePartie fPartie = new FenetrePartie();

			}
		});

	}

}
