// this file contains all basic arithmetic operators to be used in Frac.java
import java.text.DecimalFormat;


public class Operations {
  int n;
  int d;

  public Operations(int n, int d) {
    this.n = n;
    this.d = d;
  }

  public String addRationals(int num2, int denom2) {
    int num1 = n;
    int lowestCommonMultiple = 0;
    int multiply = d * denom2;
    if (d != denom2) {
        for (int i = (denom2 >= d ? denom2 : d); i <= multiply; i++) {
            if (i % d == 0 && i % denom2 == 0) {
                lowestCommonMultiple = i;
                break;
            }
        }
        num1 = n * (lowestCommonMultiple / d);
        num2 = num2 * (lowestCommonMultiple / denom2);
    }

    int finalNumerator = num1 + num2;
    int denominator = (d == denom2 ? d : lowestCommonMultiple);

    return finalNumerator + "/" + denominator;
}


public String subtractRationals(int num2, int denom2) {
    int num1 = n;
    int lowestCommonMultiple = 0;
    int multiply = d * denom2;

    if (d != denom2) {
        for (int i = (denom2 >= d ? denom2 : d); i <= multiply; i++) {
            if (i % d == 0 && i % denom2 == 0) {
                lowestCommonMultiple = i;
                break;
            }
        }
        num1 = n * (lowestCommonMultiple / d);
        num2 = num2 * (lowestCommonMultiple / denom2);
    }

    int finalNumerator = num1 - num2;
    int denominator = (d == denom2 ? d : lowestCommonMultiple);

    return finalNumerator + "/" + denominator;
}

public String multiplyRationals(int num2, int denom2) {
    int productNumerator = n * num2;
    int productDenominator = d * denom2;
    return productNumerator + "/" + productDenominator;
}

public String divideRationals(int num2, int denom2) {
    int[] arr = new int[2];
    arr[0] = num2;
    arr[1] = denom2;

    num2 = arr[1];
    denom2 = arr[0];

    int numerator = n * num2;
    int denominator = d * denom2;

    return numerator + "/" + denominator;
}

public String squareRational(int n1, int d1) {
    double squareN1 = Math.pow((double) n1, 2);
    double squareD1 = Math.pow((double) d1, 2);

    System.out.println("N1: " + squareN1);
    System.out.println("D1: " + squareD1);
    return squareN1 + "/" + squareD1;
}

public String cubeRational(int n1, int d1) {
    double cubeN1 = Math.pow((double) n1, 3);
    double cubeD1 = Math.pow((double) d1, 3);

    System.out.println("N1: " + cubeN1);
    System.out.println("D1: " + cubeD1);
    return cubeN1 + "/" + cubeD1;
}

public String squareRootRational(int n1, int d1) {
    DecimalFormat twoDecimalPlaces = new DecimalFormat("0.##");
    double sqrtN1 = Math.sqrt((double) n1);
    double sqrtD1 = Math.sqrt((double) d1);

    System.out.println("N1: " + sqrtN1);
    System.out.println("D1: " + sqrtD1);
    return twoDecimalPlaces.format(sqrtN1) + "/" + twoDecimalPlaces.format(sqrtD1);
    }

public String toDecimal(int n1, int d1) {
    DecimalFormat twoDecimalPlaces = new DecimalFormat("0.##");
    double conversion = (double) n1 / d1;
    return twoDecimalPlaces.format(conversion);
}

public String inverse(int n1, int d1) {
    return d1 + "/" + n1;
}

    public String absoluteValue(int n1, int d1) {
       int absN1 = Math.abs(n1);
       int absD1 = Math.abs(d1);
       return absN1 + "/" + absD1;
    }

    // gives u remainders
    public String base(int i) {
        String letters="";
        String reverseStr = "";
        int remainderNum = 0;
        String remainder = "";
        boolean isCompleted=false;
    
        while(!isCompleted) {
            remainderNum = i % 16;
            i = i / 16;
            if (i % 16 == 0) {
                isCompleted = true;
            } else if (remainderNum < 10) {
                remainder = "0" + String.valueOf(remainderNum);
            } else {
                remainder = String.valueOf(remainderNum);
            }
            letters = remainderNum + letters;
        }
      
        return letters;
    }

    // converts into digits of hexa
    public String addLetters (String str) {
        String currentStr = "";
        String finalStr = "";
        String values = "0123456789ABCDEFG";
        char[] alphabet = values.toCharArray();

        System.out.println("alpabet length: " + alphabet.length);

        for (int i=0; i < (str.length()); i = i + 2) {
            currentStr = str.substring(i, i = i + 2);
            System.out.println("Current: " + currentStr);
            finalStr = finalStr + alphabet[Integer.parseInt(currentStr)];
        }
        System.out.println("FINAL STRING: " + finalStr);
        return finalStr;
    }

    }
  



//  
