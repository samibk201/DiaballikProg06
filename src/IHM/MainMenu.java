package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainMenu extends JFrame {
	private int largeur = 1200;
	private int hauteur = 1000;
	private String titre = "Diabllik";
	JPanel conteneurPrincipal = new JPanel();
	JPanel panelNomJeu = new JPanel();
	JPanel panelBoutonsMenu = new JPanel();
	
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
		this.setTitle(titre);
		this.setSize(largeur, hauteur);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		conteneurPrincipal.setLayout(new BorderLayout());
		JLabel labelTitre = new JLabel(titre);
		panelNomJeu.add(labelTitre);
		
		conteneurPrincipal.add(panelNomJeu, BorderLayout.NORTH);
		conteneurPrincipal.add(panelBoutonsMenu, BorderLayout.CENTER);
		
		this.setContentPane(conteneurPrincipal);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				  MainMenu mainMenu = new MainMenu();
				
			}
		});
	}
}
