import javax.swing.*;

import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Handler;


public class Frac implements ActionListener {

  JFrame frame, helperFrame;
  JPanel panel, helperPanel;
  JTextArea fracOne, fracTwo, arithmeticSign, calculation, helperText, fracOneCalc, fracTwoCalc;
  JLabel equalSign, calcLabel, imgLabel, fracOneLabel, fracTwoLabel;
  JButton calculate, simplifyFracOne, simplifyFracTwo, simplifyCalc, hexadecimal;
  ImageIcon waitGIF;
  JMenuBar menuBar;
  JMenu operation, help, quit;
  JMenuItem addItem, subtractItem, multiplyItem, divideItem, helpItem, quitItem;
  JMenuItem powerItem, cubeItem, rootItem, decimalItem, absItem, inverseItem;

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
    fracOneCalc = new JTextArea();
    fracTwoCalc = new JTextArea();

    fracOne.setText("Enter Fraction One");
    fracTwo.setText("Enter Fraction Two");
    arithmeticSign.setText("sign");
    arithmeticSign.setEditable(false);
    calculation.setEditable(false);
    fracOneCalc.setEditable(false);
    fracTwoCalc.setEditable(false);
    equalSign = new JLabel("=");

    // text area labels
    fracOneLabel = new JLabel("Frac One Calculation: ");
    fracTwoLabel = new JLabel("Frac Two Calculation: ");
    
    // buttons + action listeners
    calculate = new JButton("Calculate");
    simplifyFracOne = new JButton("Reduce Frac One");
    simplifyFracTwo = new JButton("Reduce Frac Two");
    simplifyCalc = new JButton("Reduce Final Calculation");
    hexadecimal = new JButton("Hexadecimal");

    calculate.addActionListener(this);
    simplifyFracOne.addActionListener(this);
    simplifyFracTwo.addActionListener(this);
    simplifyCalc.addActionListener(this);
    hexadecimal.addActionListener(this);

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
    powerItem = new JMenuItem("**");
    cubeItem = new JMenuItem("**3");
    rootItem = new JMenuItem("???");
    decimalItem = new JMenuItem("decimal");
    absItem = new JMenuItem("| |");
    inverseItem = new JMenuItem("f**(-1)");
  

    addItem.addActionListener(this);
    subtractItem.addActionListener(this);
    multiplyItem.addActionListener(this);
    divideItem.addActionListener(this);
    powerItem.addActionListener(this);
    cubeItem.addActionListener(this);
    rootItem.addActionListener(this);
    decimalItem.addActionListener(this);
    absItem.addActionListener(this);
    inverseItem.addActionListener(this);

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
    operation.add(powerItem);
    operation.add(cubeItem);
    operation.add(rootItem);
    operation.add(decimalItem);
    operation.add(absItem);
    operation.add(inverseItem);
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
    panel.add(simplifyFracOne);
    panel.add(simplifyFracTwo);
    panel.add(simplifyCalc);
    panel.add(hexadecimal);
    panel.add(fracOneLabel);
    panel.add(fracOneCalc);
    panel.add(fracTwoLabel);
    panel.add(fracTwoCalc);

    // adding panel + setting menu bar to frame
    frame.add(panel);
    frame.setJMenuBar(menuBar);
  }

  // reducing rationals on button click
  private String reduceRational(int num,int denom){
    int gcd = 1;
    for (int i=1; i <= (num <= denom ? num: denom); i++) {
        if (num % i == 0 && denom % i == 0) {
            gcd = i;
        }
    }
    String numStr = Integer.toString(num / gcd);
    String denomStr = Integer.toString(denom / gcd);
    return numStr + '/' + denomStr;
  }

  // GCD using recursion method
  public static int hcf(int n1, int n2) {
    if (n2 != 0) {
      if (n1 % n2 != 0) {
        int modulo = n1 % n2;
        System.out.println("GCF: " + modulo);
      }
      return hcf(n2, n1 % n2);
    } else {
      return n1;
    }    
  }

  // create helper menu
  public void createPopupMenu() {
    helperFrame = new JFrame();
    helperPanel = new JPanel();
    helperFrame.setSize(200,200);
    helperFrame.setVisible(true);
    helperText = new JTextArea();
    helperText.setText("The menubar is where you're able to access the resources of the application\n1.Select an operation that you would like to use during calculation\n2.Click the calculate button to view the final results\n3.Click the simplify button to reducce all fractions\n4.Select quit on the menubar to close the application.\nWARNING: ALL inputs must be typed in a fraction format in order for the application to work properly");
    helperPanel.add(helperText);
    helperFrame.add(helperPanel);
  }

  public void actionPerformed(ActionEvent e) {
    String fracOneStr = fracOne.getText();
    String fracTwoStr = fracTwo.getText();
    // String fracOneCalcStr = fracOneCalc.getText();
    // String fracTwoCalcStr = fracTwoCalc.getText();
    String calcText = calculation.getText();
    String caseOperation = arithmeticSign.getText();
    
    
    if (e.getSource() == quitItem) {
      System.exit(0);
    } else if (e.getSource() == helpItem) {
      createPopupMenu();
    } else if (e.getSource() == addItem) {
      arithmeticSign.setText("+");
    } else if (e.getSource() == subtractItem) {
      arithmeticSign.setText("-");
    } else if (e.getSource() == multiplyItem) {
      arithmeticSign.setText("x");
    } else if (e.getSource() == divideItem) {
      arithmeticSign.setText("/");
    } else if (e.getSource() == powerItem) {
      arithmeticSign.setText("**");
    } else if (e.getSource() == cubeItem) {
      arithmeticSign.setText("**3");
    } else if (e.getSource() == rootItem) {
      arithmeticSign.setText( "???");
    } else if (e.getSource() == decimalItem) {
      arithmeticSign.setText( "to decimal");
    } else if (e.getSource() == absItem) {
      arithmeticSign.setText( "| |");
    } else if (e.getSource() == inverseItem) {
      arithmeticSign.setText("f**(-1)");
    } else if (e.getSource() == calculate) {
      try {
        int num1 = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
        int denom1 = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
        int num2 = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
        int denom2 = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));
        
        
    
        Operations firstFrac = new Operations(num1, denom1);
        switch (caseOperation) {
          case "+":
            String add = firstFrac.addRationals(num2, denom2);
            calculation.setText(add);
            fracOneCalc.setText("");
            fracTwoCalc.setText("");
          break;
          case "-":
            String subtract = firstFrac.subtractRationals(num2, denom2);
            calculation.setText(subtract);
            fracOneCalc.setText("");
            fracTwoCalc.setText("");
          break;
          case "x":
            String multiply = firstFrac.multiplyRationals(num2, denom2);
            calculation.setText(multiply);
            fracOneCalc.setText("");
            fracTwoCalc.setText("");
          break;
          case "/":
            String divide = firstFrac.multiplyRationals(num2, denom2);
            calculation.setText(divide);
            fracOneCalc.setText("");
            fracTwoCalc.setText("");
          break;
          case "**":
            String squareOne = firstFrac.squareRational(num1, denom1);
            String squareTwo = firstFrac.squareRational(num2, denom2);
            fracOneCalc.setText(squareOne);
            fracTwoCalc.setText(squareTwo);
            calculation.setText("");
          break;
          case "**3":
            String cubeOne = firstFrac.cubeRational(num1, denom1);
            String cubeTwo = firstFrac.cubeRational(num2, denom2);
            fracOneCalc.setText(cubeOne);
            fracTwoCalc.setText(cubeTwo);
            calculation.setText("");
          break;
          case "???":
            String sqrtOne = firstFrac.squareRootRational(num1, denom1);
            String sqrtTwo = firstFrac.squareRootRational(num2, denom2);
            fracOneCalc.setText(sqrtOne);
            fracTwoCalc.setText(sqrtTwo);
            calculation.setText("");
          break;
          case "to decimal":
            String convertOne = firstFrac.toDecimal(num1, denom1);
            String convertTwo = firstFrac.toDecimal(num2, denom2);
            fracOneCalc.setText(convertOne);
            fracTwoCalc.setText(convertTwo);
            calculation.setText("");
          break;
          case "| |":
            String absOne = firstFrac.absoluteValue(num1, denom1);
            String absTwo = firstFrac.absoluteValue(num2, denom2);
            fracOneCalc.setText(absOne);
            fracTwoCalc.setText(absTwo);
            calculation.setText("");
          break;
          case "f**(-1)":
            String invOne = firstFrac.inverse(num1, denom1);
            String invTwo = firstFrac.inverse(num2, denom2);
            fracOneCalc.setText(invOne);
            fracTwoCalc.setText(invTwo);
            calculation.setText("");
          break;
          default:
          System.out.println("Not a proper operation (205)");
          break;
        }

      } catch (Exception err) {
        System.out.println("ERROR: Input not properly integrated.");
      }
    } else if (e.getSource() == simplifyFracOne) {
        int num = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
        int denom = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
        hcf(num, denom);  
        fracOne.setText(reduceRational(num, denom));

    } else if (e.getSource() == simplifyFracTwo) {
      int num = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
      int denom = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));
      hcf(num, denom);  
      fracTwo.setText(reduceRational(num, denom));

    } else if (e.getSource() == simplifyCalc) {
      int num = Integer.parseInt(calcText.substring(0, calcText.indexOf('/')));
      int denom = Integer.parseInt(calcText.substring(calcText.indexOf('/') + 1));
      hcf(num, denom);  
      calculation.setText(reduceRational(num, denom));

    } else if (e.getSource() == hexadecimal) {

        int num1 = Integer.parseInt(fracOneStr.substring(0,fracOneStr.indexOf('/')));
        int denom1 = Integer.parseInt(fracOneStr.substring(fracOneStr.indexOf('/') + 1));
        int num2 = Integer.parseInt(fracTwoStr.substring(0,fracTwoStr.indexOf('/')));
        int denom2 = Integer.parseInt(fracTwoStr.substring(fracTwoStr.indexOf('/') + 1));
        Operations firstFrac = new Operations(num1, denom1);

        String test1= firstFrac.base(11);
        String test2 = firstFrac.base(21);
        String test3 = firstFrac.base(12);
        // System.out.println("TEST 1 " + test1);
        // System.out.println("TEST 2 " + test2);
        // System.out.println("TEST 3 " + test3);
        firstFrac.addLetters(test1);
        firstFrac.addLetters(test2);
        firstFrac.addLetters("08");
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