import javax.swing.*;
import java.awt.event.*;


public class Frac implements ActionListener {
  JFrame frame, helperFrame;
  JPanel panel;
  JTextArea fracOne, fracTwo, arithmeticSign, calculation;
  JLabel fracOneLabel, fracTwoLabel, equalSign, calcLabel, helperText;
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

    arithmeticSign = new JTextArea();
    arithmeticSign.setEditable(false);
    equalSign = new JLabel("=");
    
    calculation = new JTextArea();
    calculation.setEditable(false);

    // buttons
    calculate = new JButton("Calculate");
    simplify = new JButton("Simplify");
    calculate.addActionListener(this);
    simplify.addActionListener(this);

    // menu bar
    menuBar = new JMenuBar();

    // menus
    operation = new JMenu("Operation");
    help = new JMenu("Help");
    quit = new JMenu("Quit");
    

    // menu items
    addItem = new JMenuItem("+");
    subtractItem = new JMenuItem("-");
    multiplyItem = new JMenuItem("x");
    divideItem = new JMenuItem("/");
    addItem.addActionListener(this);
    subtractItem.addActionListener(this);
    multiplyItem.addActionListener(this);
    divideItem.addActionListener(this);

    helpItem = new JMenuItem("Help");
    quitItem = new JMenuItem("Quit");
    helpItem.addActionListener(this);
    quitItem.addActionListener(this);

    operation.add(addItem);
    operation.add(subtractItem);
    operation.add(multiplyItem);
    operation.add(divideItem);

    help.add(helpItem);
    quit.add(quitItem);

    menuBar.add(operation);
    menuBar.add(help);
    menuBar.add(quit);
    
    // panel.add(fracOneLabel);
    panel.add(fracOne);

    panel.add(arithmeticSign);

    // panel.add(fracTwoLabel);
    panel.add(fracTwo);

    panel.add(equalSign);
    panel.add(calculation);

    panel.add(calculate);
    panel.add(simplify);

    frame.add(panel);
    frame.setJMenuBar(menuBar);

  }

  public void actionPerformed(ActionEvent e) {
    String fracOneStr = fracOne.getText();
    String fracTwoStr = fracTwo.getText();
    String caseOperation = arithmeticSign.getText();

    int num1 = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
    int denom1 = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
    int num2 = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
    int denom2 = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));
    
    if (e.getSource() == quitItem) {
      System.exit(0);
    } else if (e.getSource() == helpItem) {
      helperFrame = new JFrame();
      helperFrame.setSize(200,200);
      helperFrame.setVisible(true);
      helperText = new JLabel("---help---\n1.Choose an Operation to use to calculate\n2.Select quit to exit the program");
      helperFrame.add(helperText);
    } else if (e.getSource() == addItem) {
      arithmeticSign.setText("+");
    } else if (e.getSource() == subtractItem) {
      arithmeticSign.setText("-");
    } else if (e.getSource() == multiplyItem) {
      arithmeticSign.setText("x");
    } else if (e.getSource() == divideItem) {
      arithmeticSign.setText("/");
    } else if (e.getSource() == calculate) {
        Operations newFrac = new Operations(num1, denom1);
        switch (caseOperation) {
          case "+":
          String add = newFrac.addRationals(num2, denom2);
          calculation.setText(add);
          break;
          case "-":
          String subtract = newFrac.subtractRationals(num2, denom2);
          calculation.setText(subtract);
          break;
          case "x":
          String multiply = newFrac.multiplyRationals(num2, denom2);
          calculation.setText(multiply);
          case "/":
          String divide = newFrac.divideRationals(num2, denom2);
          calculation.setText(divide);
          break;
          default:
          System.out.println("operation doesn't exist");
          break;
        }
    }
  }

  public static void main(String[] args) {
    new Frac();
  }

}