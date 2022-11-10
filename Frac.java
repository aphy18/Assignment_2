import javax.swing.*;


public class Frac {
  JFrame frame;
  JPanel panel;
  JTextArea fracOne, fracTwo, equalSign, calculation;
  JLabel fracOneLabel, fracTwoLabel, calcLabel;
  JButton calculate, simplify;
  JMenuBar menuBar;
  JMenu operation, help, quit;
  JMenuItem addItem, subtractItem, multiplyItem, divideItem, helpItem, quitItem;

  public Frac() {
    frame = new JFrame();
    frame.setTitle("Fraction Calculator");
    frame.setSize(300,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();

    fracOne = new JTextArea();
    fracOne.setText("Enter Fraction One");
    fracOneLabel = new JLabel("Fraction 1: ");
  
    fracTwo = new JTextArea();
    fracTwo.setText("Enter Fraction Two");
    fracTwoLabel = new JLabel("Fraction 2: ");

    equalSign = new JTextArea();
    equalSign.setText("=");
    equalSign.setEditable(false);

    calculation = new JTextArea();
    calculation.setEditable(false);

    // menus
    menuBar = new JMenuBar();
    operation = new JMenu("Operation");
    help = new JMenu("Help");
    quit = new JMenu("Quit");

    // menu items
    addItem = new JMenuItem("+");
    subtractItem = new JMenuItem("-");
    multiplyItem = new JMenuItem("x");
    subtractItem = new JMenuItem("/");

    helpItem = new JMenuItem("Help");
    quitItem = new JMenuItem("Quit");

    operation.add(addItem);
    operation.add(subtractItem);
    operation.add(multiplyItem);
    operation.add(divideItem);

    help.add(helpItem);
    quit.add(quitItem);

    menuBar.add(operation);
    menuBar.add(help);
    menuBar.add(quit);
    
    panel.add(fracOneLabel);
    panel.add(fracOne);

    panel.add(fracTwoLabel);
    panel.add(fracTwo);

    panel.add(equalSign);
    panel.add(calculation);

    frame.add(panel);
    frame.setJMenuBar(menuBar);

  }

  public static void main(String[] args) {
    new Frac();
  }

}