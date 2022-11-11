// this file contains all basic arithmetic operators to be used in Frac.java


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

}
