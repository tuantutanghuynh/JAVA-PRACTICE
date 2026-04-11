import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Basic CLI Calculator ===");

        while (true) {
            // --- Input number a ---
            double numa;
            while (true) {
                System.out.print("Input number a: ");
                try {
                    numa = Double.parseDouble(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Please enter a valid number.");
                }
            }

            // --- Input operator ---
            String operator;
            while (true) {
                System.out.print("Input operator (+, -, *, /): ");
                operator = scanner.nextLine().trim();
                if (operator.equals("+") || operator.equals("-")
                        || operator.equals("*") || operator.equals("/")) {
                    break;
                }
                System.out.println("[Error] Invalid operator. Please enter +, -, *, or /.");
            }

            // --- Input number b ---
            double numb;
            while (true) {
                System.out.print("Input number b: ");
                try {
                    numb = Double.parseDouble(scanner.nextLine().trim());
                    if (operator.equals("/") && numb == 0) {
                        System.out.println("[Error] Cannot divide by zero.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Please enter a valid number.");
                }
            }

            // --- Calculate ---
            double result = 0;
            switch (operator) {
                case "+": result = numa + numb; break;
                case "-": result = numa - numb; break;
                case "*": result = numa * numb; break;
                case "/": result = numa / numb; break;
            }

            System.out.println("=> Result: " + numa + " " + operator + " " + numb + " = " + result);

            // --- Continue? ---
            while (true) {
                System.out.print("Calculate again? (yes/no): ");
                String again = scanner.nextLine().trim().toLowerCase();
                if (again.equals("yes")) break;
                if (again.equals("no")) {
                    System.out.println("Program has ended.");
                    scanner.close();
                    return;
                }
                System.out.println("[Error] Please enter 'yes' or 'no'.");
            }
        }
    }
}
