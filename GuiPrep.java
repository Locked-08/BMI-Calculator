package week;
import javax.swing.*;
import java.awt.*;

public class GuiPrep {
    private JFrame frame;
    private JPanel cards; 
    private final String MAIN_PANEL = "Main Panel";
    private final String INFO_PANEL = "Info Panel";

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

        JLabel titleLabel = new JLabel("Obscure Unit BMI Calculator");  
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField weightField = new JTextField(10);
        weightField.setMaximumSize(new Dimension(200, 30));
        weightField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton showWeightButton = new JButton("Show Weight");
        showWeightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showWeightButton.addActionListener(e -> {
            String weight = weightField.getText();
            System.out.println("Weight entered: " + weight);
        });
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(weightField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        return mainPanel; 

    }

    private JPanel createInfoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(0, 0, 50));

        JLabel infoTitle = new JLabel("BMI Info");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 24));
        infoTitle.setForeground(Color.WHITE);
        infoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(infoTitle);

        return infoPanel;
    }
}
