package IHM;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;


public class Background {

    public void Background(JFrame frame, String imgPath){

        // Background
        try {
		    final Image backgroundImage = ImageIO.read(new File("ressources/"+imgPath));
			
		    frame.setContentPane(new JPanel(new BorderLayout()) {
				private static final long serialVersionUID = 422561129403137988L;

                @Override 
                public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, frame.getWidth(), frame.getHeight(), null);
		        }
		    });
		} catch (IOException e) {
		    throw new RuntimeException(e);
        }

    }
    
}
