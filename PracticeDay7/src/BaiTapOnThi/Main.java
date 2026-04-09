package BaiTapOnThi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Delete product");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> manager.add();
                case "2" -> manager.show();
                case "3" -> manager.delete();
                case "4" -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
