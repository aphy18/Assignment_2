import javax.swing.*;
import java.awt.event.*;
import java.util.TimerTask;


public class Frac implements ActionListener {

  JFrame frame, helperFrame;
  JPanel panel, helperPanel;
  JTextArea fracOne, fracTwo, arithmeticSign, calculation, helperText;
  JLabel equalSign, calcLabel, imgLabel;
  JButton calculate, simplify;
  ImageIcon waitGIF;
  JMenuBar menuBar;
  JMenu operation, help, quit;
  JMenuItem addItem, subtractItem, multiplyItem, divideItem, helpItem, quitItem;

  public Frac() {
    // setting frame
    frame = new JFrame();
    frame.setTitle("Fraction Calculator");
    frame.setSize(300,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // setting panel
    panel = new JPanel();

    // setting text areas
    fracOne = new JTextArea();
    fracTwo = new JTextArea();
    arithmeticSign = new JTextArea();
    calculation = new JTextArea();
    fracOne.setText("Enter Fraction One");
    fracTwo.setText("Enter Fraction Two");
    arithmeticSign.setText("sign");
    arithmeticSign.setEditable(false);
    calculation.setEditable(false);
    equalSign = new JLabel("=");
    
    // buttons + action listeners
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
    
    // menu items + action listeners
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

    // GIF
    waitGIF = new ImageIcon(getClass().getResource("wait.gif"));
    imgLabel = new JLabel(waitGIF);
    imgLabel.setVisible(false);

    // adding menuItems to the menu
    operation.add(addItem);
    operation.add(subtractItem);
    operation.add(multiplyItem);
    operation.add(divideItem);
    help.add(helpItem);
    quit.add(quitItem);

    // adding menus to menu bar
    menuBar.add(operation);
    menuBar.add(help);
    menuBar.add(quit);
    
    // adding components to panel
    panel.add(fracOne);
    panel.add(arithmeticSign);
    panel.add(fracTwo);
    panel.add(equalSign);
    panel.add(calculation);
    panel.add(calculate);
    panel.add(simplify);
    panel.add(imgLabel);

    // adding panel + setting menu bar to frame
    frame.add(panel);
    frame.setJMenuBar(menuBar);
  }

  private String reduceRational(int num,int denom){
    int gcd = 1;
    for (int i=1; i <= (num <= denom? num: denom); i++) {
        if (num % i == 0 && denom % i == 0) {
            gcd = i;
        }
    }
    String numStr = Integer.toString(num / gcd);
    String denomStr = Integer.toString(denom / gcd);
    return numStr + '/' + denomStr;
  }

  public void actionPerformed(ActionEvent e) {
    String fracOneStr = fracOne.getText();
    String fracTwoStr = fracTwo.getText();
    String calcText = calculation.getText();
    String caseOperation = arithmeticSign.getText();
    
    if (e.getSource() == quitItem) {
      System.exit(0);
    } else if (e.getSource() == helpItem) {
      helperFrame = new JFrame();
      helperPanel = new JPanel();
      helperFrame.setSize(200,200);
      helperFrame.setVisible(true);
      helperText = new JTextArea();
      helperText.setText("The menubar is where you're able to access the resources of the application\n1.Select an operation that you would like to use during calculation\n2.Click the calculate button to view the final results\n3.Click the simplify button to reducce all fractions\n4.Select quit on the menubar to close the application.\nWARNING: ALL inputs must be typed in a fraction format in order for the application to work properly");
      helperPanel.add(helperText);
      helperFrame.add(helperPanel);
    } else if (e.getSource() == addItem) {
      arithmeticSign.setText("+");
    } else if (e.getSource() == subtractItem) {
      arithmeticSign.setText("-");
    } else if (e.getSource() == multiplyItem) {
      arithmeticSign.setText("x");
    } else if (e.getSource() == divideItem) {
      arithmeticSign.setText("/");
    } else if (e.getSource() == calculate) {
      try {
        int num1 = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
        int denom1 = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
        int num2 = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
        int denom2 = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));

        Operations firstFrac = new Operations(num1, denom1);

        // System.out.println("sleep before");

        imgLabel.setVisible(true);
        Thread.sleep(2000);
        System.out.println("sleep done");

        
        

        switch (caseOperation) {
          case "+":
            String add = firstFrac.addRationals(num2, denom2);
            calculation.setText(add);
          break;
          case "-":
            String subtract = firstFrac.subtractRationals(num2, denom2);
            calculation.setText(subtract);
          break;
          case "x":
            String multiply = firstFrac.multiplyRationals(num2, denom2);
            calculation.setText(multiply);
          break;
          case "/":
            String divide = firstFrac.multiplyRationals(num2, denom2);
            calculation.setText(divide);
          break;
          default:
          System.out.println("Not a proper operation");
          break;
        }

      } catch (Exception err) {
        System.out.println("ERROR: Input not properly integrated.");
      }
    } else if (e.getSource() == simplify) {
      try {
        int num1 = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
        int denom1 = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
        int num2 = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
        int denom2 = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));
        int calcNum = Integer.parseInt(calcText.substring(0, calcText.indexOf('/')));
        int calcDenom = Integer.parseInt(calcText.substring(calcText.indexOf('/') + 1));

        fracOne.setText(reduceRational(num1, denom1));
        fracTwo.setText(reduceRational(num2, denom2));
        calculation.setText(reduceRational(calcNum, calcDenom));
      } catch (Exception error) {
        System.out.println("ERROR: Input not properly integrated.");
      }
    }
  }

  public static void main(String[] args) {
    Frac newFrac = new Frac();
    if (args.length != 0) {
      try {
        String f1;
        String op;
        String f2;
        if (args[0].equals("-txt") || args[0].equals("-console")) {
          newFrac.frame.removeAll();
          f1 = args[1];
          op = args[2];
          f2 = args[3];
        } else {
          f1 = args[0];
          op = args[1];
          f2 = args[2];
        }
        newFrac.fracOne.setText(f1);
        newFrac.fracTwo.setText(f2);
        newFrac.arithmeticSign.setText(op);
  
        int num1 = Integer.parseInt(f1.substring(0,f1.indexOf('/')));
        int denom1 = Integer.parseInt(f1.substring(f1.indexOf('/') + 1));
        int num2 = Integer.parseInt(f2.substring(0,f2.indexOf('/')));
        int denom2 = Integer.parseInt(f2.substring(f2.indexOf('/') + 1));
        Operations firstFrac = new Operations(num1, denom1);
  
        switch(op) {
          case "+":
          String add = firstFrac.addRationals(num2, denom2);
          newFrac.calculation.setText(add);
          break;
          case "-":
          String subtract = firstFrac.subtractRationals(num2, denom2);
          newFrac.calculation.setText(subtract);
          break;
          case "x":
          String multiply = firstFrac.multiplyRationals(num2, denom2);
          newFrac.calculation.setText(multiply);
          break;
          case "/":
          String divide = firstFrac.divideRationals(num2, denom2);
          newFrac.calculation.setText(divide);
          break;
        }
        System.out.println(f1 + " " + op + " " + f2 + " = " + newFrac.calculation.getText());
      } catch (Exception e) {
        System.out.println("ERROR: Input not properly integrated");
      }
    }
  }
}