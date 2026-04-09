package BaiTapOnThi;

import java.util.Scanner;

public class Laptop implements Product {
    String id;
    String model;
    double price;

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Laptop id: ");
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
                System.out.print("Laptop model (>3 chars): ");
                model = sc.nextLine();
                if (model.length() <= 3) 
                    throw new Exception("Model > 3 chars");
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Laptop price (>0): ");
                price = Double.parseDouble(sc.nextLine());
                if (price <= 0) 
                    throw new Exception("Price > 0");
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "[Laptop] Id: " + id + ", Model: " + model + ", Price: " + price;
    }
}
