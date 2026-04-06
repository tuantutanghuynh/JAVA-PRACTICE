import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Basic CLI Calculator");

    
            System.out.print("Input number a: ");
            float numa = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Input operator (+ , - , * , /)");
            String operator = scanner.nextLine();

            System.out.print("Input number b: ");
            float numb = scanner.nextFloat();
            scanner.nextLine();

            float result = 0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = numa + numb;
                    break;
                case "-":
                    result = numa - numb;
                    break;
                case "*":
                    result = numa * numb;
                    break;
                case "/":
                    if(numb == 0){
                        System.out.println("Cannot divide by zero");
                        validOperation = false;
                        break;
                    }
                    result = numa/numb;
                    break;            
            
                default:
                    System.out.println("Invalid calculation");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("\n=> Result: " + numa + " " + operator + " " + numb + " = " + result);
            }
            System.out.println("Program has ended.");

        }

    }

}
