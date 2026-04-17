package entities;

import java.util.Scanner;

public class Phone {

    public String model;
    public float price;
    public String brand;
    public int year;

    public Phone() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter model: ");
            try {
                model = sc.nextLine().trim();
                if (model.isEmpty()) {
                    throw new Exception("Model cannot be empty.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter price > 0 : ");
            try {
                price = Float.parseFloat(sc.nextLine().trim());
                if (price <= 0) {
                    throw new Exception("Price must be > 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter brand (LG / Samsung / Sony / Nokia): ");
            try {
                brand = sc.nextLine().trim();
                if (brand.equalsIgnoreCase("LG")) {
                    brand = "LG";
                } else if (brand.equalsIgnoreCase("Samsung")) {
                    brand = "Samsung";
                } else if (brand.equalsIgnoreCase("Sony")) {
                    brand = "Sony";
                } else if (brand.equalsIgnoreCase("Nokia")) {
                    brand = "Nokia";
                } else {
                    throw new Exception("Brand must be one of: LG, Samsung, Sony, Nokia.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter year from 2000 to 2026: ");
            try {
                year = Integer.parseInt(sc.nextLine().trim());
                if (year < 2000 || year > 2026) {
                    throw new Exception("Year must be between 2000 and 2026.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void print() {
        System.out.println("  Model : " + model + ",  Price : " + price + ",  Brand : " + brand + ",  Year  : " + year);
    }
}
