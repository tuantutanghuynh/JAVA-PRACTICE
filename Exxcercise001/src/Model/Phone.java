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
public class Phone extends Product{
    String id;

    public String getId() { return id; }
    
    @Override
     void Input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Input product Id with forrmat Pxx (x is number): ");
            try{
                id=sc.nextLine().trim();
                 if (!id.matches("P\\d{2}")){
                    throw new Exception("ID must be format Pxx (P + 2 digits).");
                 }
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        super.Input();
    }

    @Override
    public String toString() {
        float tax   = price * TAX;
        float total = price + tax;
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Tax: " + tax + ", Total: " + total;
    }

    @Override
    public String Output() {
        return toString();
    }
}
