/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public abstract class Product {

     static final float TAX = 0.10f; // 10%
     String name;
     float  price;

    public float getPrice() { 
        return price; 
    }

    void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input name ( > 3 letters): ");
            try {
                name = sc.nextLine().trim();
                if (name.length() <= 3) {
                    throw new Exception("Name must contain more than 3 letters");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("Input price (1-10000");
            try {
                price = Float.parseFloat(sc.nextLine().trim());
                if (price < 1 || price > 10000) {
                    throw new Exception("Price must be from 1 to 10000");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
          
            }
        }
       
    }
          public abstract String Output();
}

