package IHM;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;



public class InterfaceGraphique implements Runnable {

    /*public Button back;
    public Button volum;*/

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
        InterfaceJeu jeu = new InterfaceJeu();
        jeu.init(); 

        /*JPanel navigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");

        navigation.add(back);
        navigation.add(volum);*/

        // Quitter jeu
        jeu.acceuil.quit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int quitClicked = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter le jeu ?", "Quitter", JOptionPane.YES_NO_OPTION);
                if (quitClicked == JOptionPane.YES_OPTION){
                    frame.dispose();
                    System.exit(0);
                }
            }
        });

        
        frame.add(jeu, BorderLayout.CENTER);
        //frame.add(navigation, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
