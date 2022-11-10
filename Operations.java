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

// public String reduceRational(int num,int denom){
//     int gcd = 1;
//     for (int i=1; i <= (num <= denom? num: denom); i++) {
//         if (num % i == 0 && denom % i == 0) {
//             gcd = i;
//         }
//     }

//     String numStr = Integer.toString(num / gcd);
//     String denomStr = Integer.toString(denom / gcd);

//     return numStr + '/' + denomStr;
//     }

}
