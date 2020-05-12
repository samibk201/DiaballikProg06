package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;


public class InterfaceTuto extends JPanel{


    JLabel title;
    JTextArea text;
    
    public Button next;
    public Button back;
    public Button volum;

    InterfaceTuto(){
        super();
    }

    public void init(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(new Color(53, 79, 82));
        this.setBounds(0, 0, screen.width, screen.height);

        this.setLayout(new BorderLayout());

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new Button("ressources/ButtonImage/backSR.png");
        volum = new Button("ressources/ButtonImage/volume.png");
        flow.add(back);
        flow.add(volum);

        JPanel flowTitle = new JPanel();
        flowTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowTitle.setBackground(new Color(53, 79, 82));

        title = new JLabel("Comment joueur pendant la partie");
        title.setFont(new Font("Tahoma", Font.BOLD, 56));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        flowTitle.add(title);

        JPanel flowText = new JPanel();
        flowText.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowText.setBackground(new Color(53, 79, 82));

        this.text = new JTextArea("Pour avancer il suffit de cliquer sur le pion puis sur la case "+
                                    "où on veut le déplacer. \n Pour faire une passe on clique sur le "+
                                    "pion qui a la balle, puis sur celui à qui on veut donner la balle.");
        text.setFont(new Font("Tahoma", Font.ITALIC, 26));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        text.setBorder(border);
        text.setEditable(false);
        text.setAlignmentY(Component.CENTER_ALIGNMENT);

        flowText.add(text);

        JPanel flowNext = new JPanel();
        flowNext.setLayout(new FlowLayout(FlowLayout.RIGHT));
        flowNext.setBackground(new Color(53, 79, 82));

        this.next = new Button("ressources/ButtonImage/nextSR.png");
        this.setAlignmentX(Component.RIGHT_ALIGNMENT);

        flowNext.add(next);

        JPanel boxFlow = new JPanel();
        boxFlow.setLayout(new BoxLayout(boxFlow, BoxLayout.Y_AXIS));
        boxFlow.add(flow);
        boxFlow.add(flowTitle);

        this.add(boxFlow, BorderLayout.NORTH);
        this.add(flowText, BorderLayout.CENTER);
        this.add(flowNext, BorderLayout.SOUTH);
    }
    
}
