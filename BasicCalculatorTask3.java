import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculatorTask3 extends JFrame implements ActionListener {

    private JTextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    public BasicCalculatorTask3() {
        setTitle("Basic Calculator - Task 3");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        display = new JTextField();
        display.setFont(new Font("Consolas", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9\\.]")) {
            if (isOperatorClicked) {
                display.setText("");
                isOperatorClicked = false;
            }
            display.setText(display.getText() + input);
        } else if (input.matches("[\\+\\-\\*/]")) {
            try {
                firstNumber = Double.parseDouble(display.getText());
                operator = input;
                isOperatorClicked = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (input.equals("=")) {
            try {
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                display.setText(String.valueOf(result));
                isOperatorClicked = true;
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (input.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operator = "";
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? 0 : a / b;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new BasicCalculatorTask3();
    }
}

