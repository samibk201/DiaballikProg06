package IHM;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainMenu extends JFrame {

	private int largeur = 1200;
	private int hauteur = 1000;
	private String titre = "Diaballik";

	JPanel conteneurPrincipal = new JPanel();
	JPanel panelNomJeu = new JPanel();
	JPanel panelBoutonsMenu = new JPanel();

	JButton jvsJ = new JButton("Joueur vs joueur");
	JButton jvsIA = new JButton("Joueur vs IA");
	JButton enCours = new JButton("Partie en cours");
	JButton tutoriel = new JButton("Tutoriel");
	JButton quit = new JButton("Quitter");

	JFrame window = new JFrame();

	public MainMenu() {

		// TODO Auto-generated constructor stub
		window.setTitle(titre);
		window.setSize(largeur, hauteur);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setUndecorated(true);

		conteneurPrincipal.setLayout(new BorderLayout());

		JLabel labelTitre = new JLabel(titre);
		labelTitre.setFont(new Font("Tahoma", Font.BOLD, 56));;
		panelNomJeu.add(labelTitre);

		// Buttons
		panelBoutonsMenu.setLayout(new BoxLayout(panelBoutonsMenu, BoxLayout.PAGE_AXIS));

		panelBoutonsMenu.add(Box.createRigidArea(new Dimension(240,200)));
		panelBoutonsMenu.add(jvsJ);
		panelBoutonsMenu.add(Box.createRigidArea(new Dimension(0,40)));
		panelBoutonsMenu.add(jvsIA);
		panelBoutonsMenu.add(Box.createRigidArea(new Dimension(0,40)));
		panelBoutonsMenu.add(enCours);
		panelBoutonsMenu.add(Box.createRigidArea(new Dimension(0,40)));
		panelBoutonsMenu.add(tutoriel);
		panelBoutonsMenu.add(Box.createRigidArea(new Dimension(0,40)));
		panelBoutonsMenu.add(quit);
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Alert message quit game
				String message = "Voulez-vous vraiment quitter le jeu ?";
				int clickedButton = JOptionPane.showConfirmDialog(window, message, "Quit", JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION){
					window.dispose();
				}
			}
		});

		conteneurPrincipal.add(panelNomJeu, BorderLayout.NORTH);
		conteneurPrincipal.add(panelBoutonsMenu, BorderLayout.CENTER);

		
		window.setContentPane(conteneurPrincipal);
		window.setVisible(true);
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
