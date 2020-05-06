package IHM;

import javax.swing.*;	

import org.w3c.dom.events.MouseEvent;

import static java.lang.System.exit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FenetreLevelIA extends JFrame{

	private int largeur = 1200;
	private int hauteur = 1000;

	JPanel container = new JPanel();
	JPanel panelTitle = new JPanel();
	JPanel panelButtons = new JPanel();
	JPanel panelBack = new JPanel();
	JPanel panelFacile = new JPanel();
	JPanel panelMoy = new JPanel();
	JPanel panelDiff = new JPanel();
	
	JButton btnFacile = new JButton("Facile");
	JButton btnMoy = new JButton("Moyen");
	JButton btnDiff = new JButton("Difficile");
	JButton btnBack = new JButton("Retour");

	JFrame window = new JFrame();

	public FenetreLevelIA() {
		
		// Window settings
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.setSize(largeur, hauteur);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setUndecorated(true);

		container.setLayout(new BorderLayout());

		
		// Title
		JLabel title = new JLabel("Choix du niveau de l'IA");
		title.setFont( new Font("Tahoma", Font.BOLD, 36));
		panelTitle.add(title);


		// Buttons
		panelFacile.setLayout(new BoxLayout(panelFacile, BoxLayout.LINE_AXIS));
		panelFacile.add(btnFacile);
		panelMoy.setLayout(new BoxLayout(panelMoy, BoxLayout.LINE_AXIS));
		panelMoy.add(btnMoy);
		panelDiff.setLayout(new BoxLayout(panelDiff, BoxLayout.LINE_AXIS));
		panelDiff.add(btnDiff);

		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));		
		panelButtons.add(panelFacile);		
		panelButtons.add(panelMoy);		
		panelButtons.add(panelDiff);
		panelBack.add(btnBack);
		
		panelBack.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();				
			}
		});

		
		container.add(panelBack, BorderLayout.WEST);
		container.add(panelTitle, BorderLayout.NORTH);
		container.add(panelButtons, BorderLayout.CENTER);
		
		window.setContentPane(container);
		window.setVisible(true);
	}
}
