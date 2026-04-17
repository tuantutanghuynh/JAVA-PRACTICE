package services;

import entities.Phone;
import repositories.PhoneDAO;
import java.util.Scanner;

public class PhoneTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneDAO phone = new PhoneDAO();

        while (true) {
            System.out.println(" PHONE MANAGER");
            System.out.println(" 1. Create new phone");
            System.out.println(" 2. Find by brand");
            System.out.println(" 3. Exit");
            System.out.println("------------------------------");
            System.out.print("Your choice: ");

            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Create New Phone...");
                    Phone newPhone = new Phone();
                    phone.createPhone(newPhone);
                    break;

                case "2":
                    System.out.print("Enter brand to search (LG / Samsung / Sony / Nokia): ");
                    String keyword = sc.nextLine().trim();
                    phone.findByBrand(keyword);
                    break;

                case "3":
                    System.out.println("Exit!");
                    sc.close();
                    return;

                default:
                    System.out.println("Error: Invalid choice.Enter only : 1, 2, 3.");
            }
        }
    }
}
