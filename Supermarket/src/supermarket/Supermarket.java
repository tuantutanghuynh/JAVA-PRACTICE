package supermarket;

import java.util.Scanner;

/**
 * Supermarket System - Bài 13
 * Main class with menu
 * @author tangh
 */
public class Supermarket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            printMenu();
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("--- Add Fresh Item ---");
                    cart.AddItem(new FreshItem());
                    break;
                case "2":
                    System.out.println("--- Add Packaged Item ---");
                    cart.AddItem(new PackagedItem());
                    break;
                case "3":
                    cart.Show();
                    break;
                case "4":
                    cart.Checkout();
                    break;
                case "5":
                    cart.InsertionSort();
                    break;
                case "6":
                    cart.IsSorted();
                    break;
                case "7": {
                    System.out.print("Number of price entries: ");
                    try {
                        int n = Integer.parseInt(sc.nextLine().trim());
                        if (n <= 0) {
                            System.out.println("Error: Must be > 0");
                            break;
                        }
                        double[] prices = new double[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("  Day " + (i + 1) + " price: ");
                            prices[i] = Double.parseDouble(sc.nextLine().trim());
                        }
                        Cart.BestTimeToBuy(prices);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format");
                    }
                    break;
                }
                case "8":
                    cart.RunningSum();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Error: Invalid choice. Enter 0-8.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("  SUPERMARKET SYSTEM - Bai 13  ");
        System.out.println("==============================");
        System.out.println(" 1. Add Fresh item");
        System.out.println(" 2. Add Packaged item");
        System.out.println(" 3. View cart");
        System.out.println(" 4. Checkout");
        System.out.println(" 5. Sort by price (Insertion Sort)");
        System.out.println(" 6. Check if sorted");
        System.out.println(" 7. Best time to buy (stock prices)");
        System.out.println(" 8. Running revenue sum");
        System.out.println(" 0. Exit");
        System.out.println("------------------------------");
    }
}
