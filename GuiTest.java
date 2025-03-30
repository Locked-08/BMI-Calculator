package week;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code
import java.awt.Dimension;
public class GuiTest {


public static void main(String[] args) {

    JFrame frame = new JFrame("A Simple GUI");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

    frame.add(panel);


    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(lbl);

    String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
                         "CHOICE 5", "CHOICE 6" };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize()); // added code
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
    panel.add(cb);
//button section
    JPanel buttonpanel = new JPanel();
    buttonpanel.setPreferredSize(new Dimension(500, 500));
    buttonpanel.setLayout(null);
    JButton btn = new JButton("OK");
    btn.setBounds(200, 40, 100, 100);
    buttonpanel.add(btn);
    btn.setVisible(true);

    JButton ibtn = new JButton("i");
    ibtn.setBounds(440, 0, 50, 50);
    buttonpanel.add(ibtn);
    ibtn.setVisible(true);

    panel.add(buttonpanel);

    frame.setVisible(true);
}
}
/*package week;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code
public class GuiTest {

public static void main(String[] args) {

    JFrame frame = new JFrame("A Simple GUI");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

    frame.add(panel);

    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
    //lbl.setVisible(true); // Not needed

    panel.add(lbl);

    String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
                         "CHOICE 5", "CHOICE 6" };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize()); // added code
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
    //cb.setVisible(true); // Not needed
    panel.add(cb);

    JButton btn = new JButton("OK");
    btn.setAlignmentX(Component.LEFT_ALIGNMENT); // added code
    panel.add(btn);

    frame.setVisible(true); // added code

    }
} */