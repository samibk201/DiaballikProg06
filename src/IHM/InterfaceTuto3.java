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


public class InterfaceTuto3 extends JPanel{

    JPanel panelTitle;
    JPanel panelText;
    JPanel panelText2;
    JPanel panelText3;
    JPanel panelNext;
    JPanel panelPrev;
    JPanel box;

    JLabel title;

    JTextArea text;
    JTextArea text2;
    JTextArea text3;

    public Button next;
    public Button previous;

    InterfaceTuto3(){
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

        text = new JTextArea(" 2. Pendant son tour le joueur peut jouer jusqu'à 3 coups : ");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        panelText.add(text);

        panelText2 = new JPanel();
        panelText2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelText2.setBackground(new Color(53, 79, 82));

        text2 = new JTextArea(" Deux coups pour avancer : \n  - soit deux fois un pion, \n  - soit deux pions une fois chacun. ");
        text2.setFont(new Font("Tahoma", Font.ITALIC, 26));
        text2.setBorder(border);
        text2.setEditable(false);
        text2.setAlignmentY(Component.LEFT_ALIGNMENT);

        panelText2.add(text2);

        panelText3 = new JPanel();
        panelText3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelText3.setBackground(new Color(53, 79, 82));

        text3 = new JTextArea(" Faire une passe à un autre de ses pions. ");
        text3.setFont(new Font("Tahoma", Font.ITALIC, 26));
        text3.setBorder(border);
        text3.setEditable(false);
        text3.setAlignmentY(Component.RIGHT_ALIGNMENT);

        panelText2.add(text3);

        panelNext = new JPanel();
        panelNext.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelNext.setBackground(new Color(53, 79, 82));
        
        next = new Button("ressources/ButtonImage/nextSR.png");
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
        box.add(panelText2);
        box.add(panelText3);
        box.add(flowBut);

        this.add(box);
    }
    
}