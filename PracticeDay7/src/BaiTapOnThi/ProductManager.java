package BaiTapOnThi;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> pros = new ArrayList<>();

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Phone  2. Laptop");
        System.out.print("Choose type: ");
        String choice = sc.nextLine();

        Product p;
        if (choice.equals("1")) {
            p = new Phone();
        } else {
            p = new Laptop();
        }
        p.Input();
        pros.add(p);
        System.out.println("Added successfully!");
    }
 // hoặc dùng switch case:
//        switch (choice) {
//            case "1" -> p = new Phone();
//            case "2" -> p = new Laptop();
//            default -> throw new IllegalArgumentException("Invalid choice");
//        }
    public void show() {
        if (pros.isEmpty()) {
            System.out.println("No products.");
            return;
        }
        for (Product p : pros) {
            System.out.println(p);
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id to delete: ");
        String id = sc.nextLine();

        for (int i = 0; i < pros.size(); i++) {
            Product p = pros.get(i);
            if (p instanceof Phone ph && ph.id.equals(id)) {
                pros.remove(i);
                System.out.println("Deleted!");
                return;
            }
            if (p instanceof Laptop lp && lp.id.equals(id)) {
                pros.remove(i);
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Id not found.");
    }
}
