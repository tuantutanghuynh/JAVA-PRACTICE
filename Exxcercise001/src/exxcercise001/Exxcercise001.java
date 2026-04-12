/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exxcercise001;

import Model.PhoneArray;
import java.util.Scanner;

public class Exxcercise001 {

    public static void main(String[] args) {
        Scanner    sc    = new Scanner(System.in);
        PhoneArray store = new PhoneArray();

        while (true) {
            System.out.println("\n==============================");
            System.out.println("       PHONE MANAGER");
            System.out.println("==============================");
            System.out.println(" 1. Add phone");
            System.out.println(" 2. Show all");
            System.out.println(" 3. Search by price");
            System.out.println(" 4. Delete by ID");
            System.out.println(" 5. Exit");
            System.out.println("------------------------------");

            int choice = readInt(sc, "Choose: ", 1, 5);

            switch (choice) {
                case 1:
                    store.Add();
                    break;
                case 2:
                    store.Show();
                    break;
                case 3:
                    int min = readInt(sc, "Min price: ", 1, 10000);
                    int max = readInt(sc, "Max price: ", 1, 10000);
                    store.SearchByPrice(min, max);
                    break;
                case 4:
                    System.out.print("Enter ID to delete (Pxx): ");
                    String id = sc.nextLine().trim();
                    store.DeleteById(id);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
            }
        }
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v < min || v > max)
                    throw new IllegalArgumentException("Enter " + min + "-" + max + ".");
                return v;
            } catch (NumberFormatException e) {
                System.out.println("[Error] Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }
    }
}
