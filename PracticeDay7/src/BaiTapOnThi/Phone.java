package BaiTapOnThi;

import java.util.Scanner;

public class Phone implements Product {
    String id;
    String name;
    double price;

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Phone id: ");
                id = sc.nextLine();
                if (id.isEmpty()) 
                    throw new Exception("Id not empty");
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Phone name (>3 chars): ");
                name = sc.nextLine();
                if (name.length() <= 3) 
                    throw new Exception("Name > 3 chars");
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Phone price (>1): ");
                price = Double.parseDouble(sc.nextLine());
                if (price <= 1) 
                    throw new Exception("Price > 1");
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "[Phone] Id: " + id + ", Name: " + name + ", Price: " + price;
    }
}
