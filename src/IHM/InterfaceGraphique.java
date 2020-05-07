package IHM;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;



public class InterfaceGraphique implements Runnable {

    public Button back;
    public Button volum;

	InterfaceGraphique() {
		// TODO
	}   

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new InterfaceGraphique());
	}

	@Override
	public void run() {
        JFrame frame = new JFrame("Diaballik PROG6");

        frame.getContentPane().setBackground(new Color(53, 79, 82));
        frame.setLayout(new BorderLayout());
        InterfaceJeu  jeu = new InterfaceJeu();
        jeu.init();

        JPanel navigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");

        navigation.add(back);
        navigation.add(volum);

        
        frame.add(jeu, BorderLayout.CENTER);
        frame.add(navigation, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
