package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class InterfaceLevel extends JPanel{

    public Button easy;
    public Button mid;
    public Button diff;

    InterfaceLevel(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // acceuil.setLayout(new BoxLayout(acceuil, BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(53, 79, 82));
        this.setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);

        this.easy = new Button("ressources/ButtonImage/easySR.png");
        this.mid = new Button("ressources/ButtonImage/moySR.png");
        this.diff = new Button("ressources/ButtonImage/diffSR.png");

        this.add(easy);
        this.add(mid);
        this.add(diff);
    }
    
}
