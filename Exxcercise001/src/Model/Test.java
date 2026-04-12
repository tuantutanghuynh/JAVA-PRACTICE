package Model;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner    sc    = new Scanner(System.in);
        PhoneArray store = new PhoneArray();

        while (true) {
            System.out.println("\n==============================");
            System.out.println("     PHONE MANAGER");
            System.out.println("==============================");
            System.out.println(" 1. Add phone");
            System.out.println(" 2. Show all phones");
            System.out.println(" 3. Search by price range");
            System.out.println(" 4. Delete by ID");
            System.out.println(" 5. Exit");
            System.out.println("------------------------------");
            System.out.print("Choose: ");

            String option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    System.out.println("--- Add Phone ---");
                    store.Add(sc);
                    break;

                case "2":
                    store.Show();
                    break;

                case "3":
                    int min, max;
                    while (true) {
                        System.out.print("Min price: ");
                        try {
                            min = Integer.parseInt(sc.nextLine().trim());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Please enter a valid integer.");
                        }
                    }
                    while (true) {
                        System.out.print("Max price: ");
                        try {
                            max = Integer.parseInt(sc.nextLine().trim());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Please enter a valid integer.");
                        }
                    }
                    store.SearchByPrice(min, max);
                    break;

                case "4":
                    System.out.print("Enter ID to delete (Pxx): ");
                    String id = sc.nextLine().trim();
                    store.DeleteById(id);
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Error: Invalid choice. Enter 1-5.");
            }
        }
    }
}
