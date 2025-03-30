package week;
import javax.swing.*;
import java.awt.*;

public class BMICalculatorGUI {
    private JFrame frame;
    private JPanel cards;
    private final String MAIN_PANEL = "Main Panel";
    private final String INFO_PANEL = "Info Panel";
    private double kg; // Weight in kilograms
    private double m;  // Height in meters
    private JLabel resultLabel; // Added to display BMI result
    
    // History feature implementation
    private String[] bmiHistory = new String[5]; // Array to store last 5 BMI calculations
    private int historyCount = 0; // Total number of valid calculations

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new BMICalculatorGUI().createAndShowGui();
        });
    }

    // Method to calculate BMI
    private void calculateBMI() {
        double bmi = kg / (m * m);
        String category;
        
        // Determine BMI category
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
        
        // Format and display result
        String result = String.format("BMI: %.1f - %s", bmi, category);
        resultLabel.setText(result);
        
        // Add to history
        addToHistory(result);
    }
    
    // Add result to history and print
    private void addToHistory(String result) {
        // Shift all elements one position to make room for the new result
        for (int i = bmiHistory.length - 1; i > 0; i--) {
            bmiHistory[i] = bmiHistory[i-1];
        }
        
        // Add the new result at the beginning
        bmiHistory[0] = result;
        
        // Increment history count if we haven't reached the maximum yet
        if (historyCount < bmiHistory.length) {
            historyCount++;
        }
        
        // Print history to terminal
        printHistory();
    }
    
    // Print history to terminal
    private void printHistory() {
        System.out.println("Recent BMI History:");
        for (int i = 0; i < historyCount; i++) {
            System.out.println((i + 1) + ". " + bmiHistory[i]);
        }
        System.out.println(); // Empty line for better readability
    }

    // Convert height based on unit
    private void convertHeight(double value, String unit) {
        switch (unit) {
            case "corona bottles":
                m = value * 0.0231;
                break;
            case "feet":
                m = value * 0.3048;
                break;
            case "metres":
                m = value;
                break;
        }
    }

    // Convert weight based on unit
    private void convertWeight(double value, String unit) {
        switch (unit) {
            case "elephants":
                kg = value * 6300;
                break;
            case "pounds":
                kg = value / 2.2;
                break;
            case "kg":
                kg = value;
                break;
        }
    }

    private void createAndShowGui() {
        frame = new JFrame("BMI Calculator");
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

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(0, 0, 50));
        titlePanel.setMaximumSize(new Dimension(500, 50));
        
        JLabel titleLabel = new JLabel("Obscure Unit BMI Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton infoButton = new JButton("i");
        infoButton.setFont(new Font("Arial", Font.BOLD, 16));
        infoButton.setPreferredSize(new Dimension(40, 30));
        infoButton.addActionListener(e -> {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, INFO_PANEL);
        });

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(infoButton, BorderLayout.EAST);

        // Create a container panel for input fields
        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new BoxLayout(inputContainer, BoxLayout.Y_AXIS));
        inputContainer.setBackground(new Color(0, 0, 50));
        inputContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputContainer.setMaximumSize(new Dimension(300, 400));

        // Weight section
        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.Y_AXIS));
        weightPanel.setBackground(new Color(0, 0, 50));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weightPanel.setMaximumSize(new Dimension(300, 100));

        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setForeground(Color.WHITE);
        weightLabel.setFont(new Font("Arial", Font.BOLD, 16));
        weightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField weightField = new JTextField(10);
        weightField.setMaximumSize(new Dimension(200, 30));
        weightField.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] weightUnits = {"pounds", "elephants", "kg"};
        JComboBox<String> weightUnitBox = new JComboBox<>(weightUnits);
        weightUnitBox.setMaximumSize(new Dimension(200, 30));
        weightUnitBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        weightPanel.add(weightLabel);
        weightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        weightPanel.add(weightUnitBox);
        weightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        weightPanel.add(weightField);

        // Height section
        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
        heightPanel.setBackground(new Color(0, 0, 50));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        heightPanel.setMaximumSize(new Dimension(300, 100));

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setForeground(Color.WHITE);
        heightLabel.setFont(new Font("Arial", Font.BOLD, 16));
        heightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField heightField = new JTextField(10);
        heightField.setMaximumSize(new Dimension(200, 30));
        heightField.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] heightUnits = {"feet", "corona bottles", "metres"};
        JComboBox<String> heightUnitBox = new JComboBox<>(heightUnits);
        heightUnitBox.setMaximumSize(new Dimension(200, 30));
        heightUnitBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        heightPanel.add(heightLabel);
        heightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        heightPanel.add(heightUnitBox);
        heightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        heightPanel.add(heightField);

        // Result section
        resultLabel = new JLabel("Enter values and click Calculate");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.setMaximumSize(new Dimension(200, 30));
        calculateButton.addActionListener(e -> {
            try {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                
                if (weight <= 0 || height <= 0) {
                    resultLabel.setText("Please enter positive values");
                    return;
                }

                convertWeight(weight, (String)weightUnitBox.getSelectedItem());
                convertHeight(height, (String)heightUnitBox.getSelectedItem());
                calculateBMI();
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers");
            }
        });

        // Add all sections to input container
        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));
        inputContainer.add(weightPanel);
        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));
        inputContainer.add(heightPanel);
        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));
        inputContainer.add(calculateButton);
        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));
        inputContainer.add(resultLabel);

        // Add everything to main panel
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(titlePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(inputContainer);

        return mainPanel;
    }

    private JPanel createInfoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(0, 0, 50));

        // Title Panel
        JPanel infoTitlePanel = new JPanel();
        infoTitlePanel.setLayout(new BorderLayout());
        infoTitlePanel.setBackground(new Color(0, 0, 50));
        infoTitlePanel.setMaximumSize(new Dimension(500, 50));

        JLabel infoTitle = new JLabel("BMI Info And Concept Idea");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 32));
        infoTitle.setForeground(Color.WHITE);
        infoTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JButton backButton = new JButton("i");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(40, 30));
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, MAIN_PANEL);
        });

        infoTitlePanel.add(infoTitle, BorderLayout.CENTER);
        infoTitlePanel.add(backButton, BorderLayout.EAST);

        // Subtitle Panel
        JPanel subTitlePanel = new JPanel();
        subTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 160, 0));
        subTitlePanel.setBackground(new Color(0, 0, 50));
        subTitlePanel.setMaximumSize(new Dimension(500, 40));

        JLabel bmiTitle = new JLabel("BMI");
        bmiTitle.setFont(new Font("Arial", Font.BOLD, 24));
        bmiTitle.setForeground(Color.WHITE);

        JLabel conceptTitle = new JLabel("Concept");
        conceptTitle.setFont(new Font("Arial", Font.BOLD, 24));
        conceptTitle.setForeground(Color.WHITE);

        subTitlePanel.add(bmiTitle);
        subTitlePanel.add(conceptTitle);

        // Text Panel
        JPanel subTextPanel = new JPanel();
        subTextPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        subTextPanel.setBackground(new Color(0, 0, 50));

        JLabel bmiText = new JLabel("<html><div style='width: 180px; text-align: left;'>" +
            "<div style='text-align: center; margin-bottom: 15px;'>BMI Categories</div>" +
            "<table style='width: 100%; border-spacing: 0 8px;'>" +
            "<tr><td style='padding: 4px;'>Under</td><td style='padding: 4px;'>< 18.5</td></tr>" +
            "<tr><td style='padding: 4px;'>Normal</td><td style='padding: 4px;'>18.5-24.9</td></tr>" +
            "<tr><td style='padding: 4px;'>Over</td><td style='padding: 4px;'>25-29.9</td></tr>" +
            "<tr><td style='padding: 4px;'>Obese</td><td style='padding: 4px;'>≥ 30</td></tr>" +
            "</table>" +
            "</div></html>");
        bmiText.setFont(new Font("Arial", Font.BOLD, 14));
        bmiText.setForeground(Color.WHITE);

        JLabel conceptText = new JLabel("<html><div style='width: 180px;'>" +
            "<div style='text-align: center; margin-bottom: 12px;'>Units</div>" +
            "<table style='width: 100%; border-spacing: 0 6px;'>" +
            "<tr><td colspan='2' style='padding: 4px 0 6px 0;'>Weight:</td></tr>" +
            "<tr><td style='padding: 4px;'>• Elephant</td><td style='padding: 4px;'>6300kg</td></tr>" +
            "<tr><td style='padding: 4px;'>• Pound</td><td style='padding: 4px;'>0.45kg</td></tr>" +
            "<tr><td colspan='2' style='padding: 10px 0 6px 0;'>Height:</td></tr>" +
            "<tr><td style='padding: 4px;'>• Bottle</td><td style='padding: 4px;'>0.023m</td></tr>" +
            "<tr><td style='padding: 4px;'>• Feet</td><td style='padding: 4px;'>0.305m</td></tr>" +
            "</table>" +
            "</div></html>");
        conceptText.setFont(new Font("Arial", Font.BOLD, 14));
        conceptText.setForeground(Color.WHITE);

        subTextPanel.add(bmiText);
        subTextPanel.add(conceptText);

        // Adjusted spacing for info panel components
        infoPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        infoPanel.add(infoTitlePanel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        infoPanel.add(subTitlePanel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(subTextPanel);

        return infoPanel;
    }
}