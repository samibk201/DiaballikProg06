package IHM;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;


public class InterfaceTuto5 extends JPanel{

    JPanel panelTitle;
    JPanel panelText;
    JPanel panelNext;
    JPanel panelPrev;
    JPanel box;

    JLabel title;

    JTextArea text;

    public Button next;
    public Button previous;

    InterfaceTuto5(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53, 79, 82));
        this.setBounds(0, 0, screen.width, screen.height);

        panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitle.setBackground(new Color(53, 79, 82));

        title = new JLabel("Règles du jeu");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitle.add(title);

        panelText = new JPanel();
        panelText.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelText.setBackground(new Color(53, 79, 82));

        text = new JTextArea(" 4. Un pion peut faire une passe à un autre pion à n'importe quelle "+
                            " distance \n uniquement si il n'y a pas de pions adverses entre les deux "+
                            " et si le pion à qui \n on veut faire la passe est accessible en ligne "+
                            " directe orthogonale ou diagonale. ");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        panelText.add(text);

        panelNext = new JPanel();
        panelNext.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelNext.setBackground(new Color(53, 79, 82));
        
        next = new Button("ressources/ButtonImage/btnquitSR.png");
        next.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panelNext.add(next);

        panelPrev = new JPanel();
        panelPrev.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelPrev.setBackground(new Color(53, 79, 82));

        previous = new Button("ressources/ButtonImage/previousSR.png");
        previous.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelPrev.add(previous);

        JPanel flowBut = new JPanel();
        flowBut.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowBut.setBackground(new Color(53, 79, 82));
        flowBut.add(panelPrev);
        flowBut.add(panelNext);

        box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBackground(new Color(53, 79, 82));
        box.add(panelTitle);
        box.add(panelText);
        box.add(flowBut);

        this.add(box);
    }
    
}