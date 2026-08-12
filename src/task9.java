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

public class task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        Calculator calculator = new Calculator();

        boolean passed = false;

        try {
            if (operator.equals("+")) {

                int result = calculator.add(a, b);

                // Expected result for the test
                passed = result == a + b;

            } else if (operator.equals("/")) {

                double result = calculator.divide(a, b);

                passed = result == (double) a / b;
            }

        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}