public class CalculatorUnitTesting {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        assert add(10, 5) == 15;
        assert subtract(10, 5) == 5;
        assert multiply(10, 5) == 50;
        assert divide(10, 5) == 2.0;

        try {
            divide(10, 0);
            System.out.println("Division test failed");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero test passed");
        }

        System.out.println("Addition: " + add(10, 5));
        System.out.println("Subtraction: " + subtract(10, 5));
        System.out.println("Multiplication: " + multiply(10, 5));
        System.out.println("Division: " + divide(10, 5));
        System.out.println("All calculator tests passed");
    }
}
Division by zero test passed
Addition: 15
Subtraction: 5
Multiplication: 50
Division: 2.0
All calculator tests passed
