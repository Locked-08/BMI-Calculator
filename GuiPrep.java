package week;
import javax.swing.*;
import java.awt.*;

public class GuiPrep {
    private JFrame frame;
    private JPanel cards; 
    private final String MAIN_PANEL = "Main Panel";
    private final String INFO_PANEL = "Info Panel";
    private String calc;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { 
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new GuiPrep().createAndShowGui();
            });
        }

    private void createAndShowGui() {
        frame = new JFrame("Obscure Unit BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        cards.add(createMainPanel(), MAIN_PANEL);
        cards.add(createInfoPanel(), INFO_PANEL);

        frame.getContentPane().add(cards);
        frame.setVisible(true);
    } 

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(0, 0, 50));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(0, 0, 50));
        titlePanel.setMaximumSize(new Dimension(500, 50));
        
        JLabel titleLabel = new JLabel("Obscure Unit BMI Calculator");  
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton infoButton = new JButton("i");
        infoButton.setFont(new Font("Arial", Font.BOLD, 16));
        infoButton.setPreferredSize(new Dimension(40, 10));
        infoButton.addActionListener(e -> {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, INFO_PANEL);
        });

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(infoButton, BorderLayout.EAST);

        //weight text field
        JTextField weightField = new JTextField(10);
        weightField.setMaximumSize(new Dimension(200, 30));
        weightField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // height text field
        JTextField heightField = new JTextField(10);
        heightField.setMaximumSize(new Dimension(200, 30));
        heightField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // weight unit box
        String[] weightUnits = {"pounds", "elephants", "kg"};
        JComboBox<String> weightUnitBox = new JComboBox<>(weightUnits);
        weightUnitBox.setMaximumSize(new Dimension(200, 30));
        weightUnitBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // height unit box
        String[] heightUnits = {"feet", "corona bottles", "metres"};
        JComboBox<String> heightUnitBox = new JComboBox<>(heightUnits);
        heightUnitBox.setMaximumSize(new Dimension(200, 30));
        weightField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // print weight button to console
        JButton showWeightButton = new JButton("Show Weight");
        showWeightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showWeightButton.addActionListener(e -> {
            String weight = weightField.getText();
            System.out.println("Weight entered: " + weight);
        });
        
        // print height button to console
        JButton showHeightButton = new JButton("Show Height");
        showHeightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showHeightButton.addActionListener(e -> {
            String height = heightField.getText();
            System.out.println("Height entered: " + height);
        });

        // display string addition label 
        JLabel calcDisplayLabel = new JLabel("sss");
        calcDisplayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        calcDisplayLabel.setForeground(Color.BLACK);
        calcDisplayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        calcDisplayLabel.setBackground(Color.WHITE);
        calcDisplayLabel.setOpaque(true);
        //calculation button for now adds the two strings together later implementation could parse our text field string into an int and spit back an error message when parse fails instead of breaking the program
        JButton showCalcButton = new JButton("Calculate");
        showCalcButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showCalcButton.addActionListener(e -> {
            String weight = weightField.getText();
            String height = heightField.getText();
            calc = (height + weight);
            System.out.println(calc);
            calcDisplayLabel.setText(calc);
            
        });


        // panel additions
// info button
        // mainPanel.add(infoButton);
 // title area       
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(titlePanel);
//weight area
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(new JLabel("Weight: ") {{ setForeground(Color.white); setAlignmentX(Component.CENTER_ALIGNMENT); setFont(new Font("Arial", Font.BOLD, 16)); }});
        mainPanel.add(weightUnitBox);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(weightField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(showWeightButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        //height area
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(new JLabel("Height: ") {{ setForeground(Color.white); setAlignmentX(Component.CENTER_ALIGNMENT); setFont(new Font("Arial", Font.BOLD, 16)); }});
        mainPanel.add(heightUnitBox);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(heightField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(showHeightButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        //calc display area
        mainPanel.add(showCalcButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        // calc display label jsut concatonates strings
        mainPanel.add(calcDisplayLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
  
  
        return mainPanel; 

    }

    private JPanel createInfoPanel() {
        //main info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(0, 0, 50));

        // elements that go onto info title panel
        //titile for info page
        JLabel infoTitle = new JLabel("BMI Info And Concept Idea");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 32));
        infoTitle.setForeground(Color.WHITE);
        infoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        //page swap button
        JButton backButton = new JButton("i");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(40, 10));
        backButton.addActionListener(e -> { //lambda fuction
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, MAIN_PANEL);
            });
        //actually adding these elements onto info title panel
        //info title panel
        JPanel infoTitlePanel = new JPanel();
        infoTitlePanel.setLayout(new BorderLayout());
        infoTitlePanel.setBackground(new Color(0, 0, 50));
        infoTitlePanel.setMaximumSize(new Dimension(500, 50));

        infoTitlePanel.add(infoTitle, BorderLayout.CENTER);
        infoTitlePanel.add(backButton, BorderLayout.EAST);    

        // elements that go onto sub title panel
        // concept title
        JLabel conceptTitle = new JLabel("concept");
        conceptTitle.setFont(new Font("Arial", Font.BOLD, 24));
        conceptTitle.setForeground(Color.WHITE);
        conceptTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        // What is BMI title
        JLabel bmiTitle = new JLabel("BMI");
        bmiTitle.setFont(new Font("Arial", Font.BOLD, 24));
        bmiTitle.setForeground(Color.WHITE);
        bmiTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        //creation and adding stuff into subtitile panel
        JPanel subTitlePanel = new JPanel();
        subTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 160, 0));
        subTitlePanel.setBackground(new Color(0, 0, 50));
        subTitlePanel.add(bmiTitle);
        subTitlePanel.add(conceptTitle);
        // stuff that'll go in sub text panel
        //concept and idea paragraph
        JLabel conceptText = new JLabel("<html><p style='width: 100px;'>"
        + "BMI is a measure of body fat based on height and weight."
        + " It applies to adult men and women."
        + "</p></html>");
        conceptText.setFont(new Font("Arial", Font.BOLD, 14));
        conceptText.setForeground(Color.WHITE);
        conceptText.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel bmiText = new JLabel("<html><p style='width: 100px;'>"
        + "BMI is a measure of body fat based on height and weight."
        + " It applies to adult men and women."
        + "</p></html>");
        bmiText.setFont(new Font("Arial", Font.BOLD, 14));
        bmiText.setForeground(Color.WHITE);
        bmiText.setAlignmentX(Component.CENTER_ALIGNMENT);

        //sub text panel creation and additions
        JPanel subTextPanel = new JPanel();
        subTextPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        subTextPanel.setBackground(new Color(0, 0, 50));
        subTextPanel.add(bmiText);
        subTextPanel.add(conceptText);

        // panel additions

        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(infoTitlePanel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        infoPanel.add(subTitlePanel);
        infoPanel.add(subTextPanel);


        


        return infoPanel;
    }
}
