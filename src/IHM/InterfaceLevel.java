package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;


public class InterfaceLevel extends JPanel{

    public Button easy;
    public Button mid;
    public Button diff;

    public Button back;
    public Button volum;

    JLabel title;

    InterfaceLevel(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53, 79, 82));
        this.setBounds(0, 0, screen.width, screen.height);

        this.setLayout(new BorderLayout());

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBackground(new Color(53, 79, 82));
        box.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel flow = new JPanel();
        flow.setLayout(new FlowLayout(FlowLayout.LEFT));
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        flow.add(back);
        flow.add(volum);

        title = new JLabel("Choix du niveau de l'IA");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setForeground(Color.white);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.easy = new Button("ressources/ButtonImage/easySR.png");
        easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.mid = new Button("ressources/ButtonImage/moySR.png");
        mid.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.diff = new Button("ressources/ButtonImage/diffSR.png");
        diff.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(title);
        box.add(easy);
        box.add(mid);
        box.add(diff);

        // Ajout des composants dans le panel
        this.add(flow, BorderLayout.NORTH);
        this.add(box, BorderLayout.CENTER);
    }
    
}
