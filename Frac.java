import javax.swing.*;


public class Frac {
  JFrame frame;
  JPanel panel;
  JTextArea fracOne, fracTwo, equalSign, calculation;
  JLabel fracOneLabel, fracTwoLabel, calcLabel;
  JButton calculate, simplify;

  public Frac() {
    frame = new JFrame();
    frame.setTitle("Fraction Calculator");
    frame.setSize(300,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();

    fracOne = new JTextArea();
    fracOneLabel = new JLabel("Fraction 1: ");

    fracTwo = new JTextArea();
    fracTwoLabel = new JLabel("Fraction 2: ");

    equalSign = new JTextArea();
    calculation = new JTextArea();
    
    
    panel.add(fracOneLabel);
    panel.add(fracOne);

    panel.add(fracTwoLabel);
    panel.add(fracTwo);

    panel.add(equalSign);
    panel.add(calculation);

    frame.add(panel);

  }

  public static void main(String[] args) {
    new Frac();
  }

}