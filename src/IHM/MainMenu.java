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

	JPanel conteneurPrincipal = new JPanel();
	JPanel panelNomJeu = new JPanel();
	JPanel panelBoutonsMenu = new JPanel();
	JPanel panelJvsJ = new JPanel();
	JPanel panelJvsIA = new JPanel();
	JPanel panelEncours = new JPanel();
	JPanel panelTuto = new JPanel();
	JPanel panelQuit = new JPanel();

	JButton jvsJ = new JButton("Joueur vs joueur");
	JButton jvsIA = new JButton("Joueur vs IA");
	JButton enCours = new JButton("Partie en cours");
	JButton tutoriel = new JButton("Tutoriel");
	JButton quit = new JButton("Quitter");

	JFrame window = new JFrame();

	public MainMenu() {
		
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
		panelEncours.setLayout(new BoxLayout(panelEncours, BoxLayout.LINE_AXIS));
		panelEncours.add(enCours);
		panelJvsIA.setLayout(new BoxLayout(panelJvsIA, BoxLayout.LINE_AXIS));
		panelJvsIA.add(jvsIA);
		panelJvsJ.setLayout(new BoxLayout(panelJvsJ, BoxLayout.LINE_AXIS));
		panelJvsJ.add(jvsJ);
		panelTuto.setLayout(new BoxLayout(panelTuto, BoxLayout.LINE_AXIS));
		panelTuto.add(tutoriel);
		panelQuit.setLayout(new BoxLayout(panelQuit, BoxLayout.LINE_AXIS));
		panelQuit.add(quit);

		panelBoutonsMenu.setLayout(new BoxLayout(panelBoutonsMenu, BoxLayout.Y_AXIS));

		panelBoutonsMenu.add(panelJvsJ);
		panelBoutonsMenu.add(panelJvsIA);
		panelBoutonsMenu.add(panelEncours);
		panelBoutonsMenu.add(panelTuto);
		panelBoutonsMenu.add(panelQuit);

		
		//Clicks handler
		jvsIA.addActionListener(new clickJvsIA());
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
	
	private class clickJvsIA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			FenetreGameSetIA setIA = new FenetreGameSetIA();
	    }

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
