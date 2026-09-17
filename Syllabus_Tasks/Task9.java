import java.util.*;

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return (double) a / b;
    }
}

public class Task9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        Calculator calculator = new Calculator();

        boolean testPassed = false;

        try {

            if (operator.equals("+")) {

                int result = calculator.add(a, b);

                if (result == a + b) {
                    testPassed = true;
                }

            } else if (operator.equals("/")) {

                double result = calculator.divide(a, b);

                if (result == (double) a / b) {
                    testPassed = true;
                }
            }

        } catch (ArithmeticException e) {
            testPassed = false;
        }

        if (testPassed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}