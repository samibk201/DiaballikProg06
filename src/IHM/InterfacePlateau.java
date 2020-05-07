package Vue;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;

public class InterfacePlateau extends JPanel {

    // props

    // constructeur
    public InterfacePlateau() {
        super();
    }

    public void init() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);

        this.setBackground(new Color(53, 79, 82));

    }

    @Override
	public void paintComponent(Graphics g) {
        // TODO
        Boolean color = true;
        Graphics2D drawable = (Graphics2D) g;
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        int l = getWidth()/9;
        int h = getHeight()/9;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(color)
                    g.setColor(new Color(53, 79, 82));
                else
                    g.setColor(Color.WHITE);
                color = !color;
                
                    g.fillRect(l+l*i, h+h*j, l, h);

                
            }
        }
    }





}
