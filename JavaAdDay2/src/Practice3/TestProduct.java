/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice3;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class TestProduct {
    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Product Menu:  ");
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Write to file");
            System.out.println("4. Read from file");
            System.out.println("5. Exit");
            
            String option = sc.nextLine().trim();
            
            switch(option){
                case "1":
                    pa.Add();
                    break;
                case "2":
                    pa.Show();
                    break;
                case "3":
                    pa.WriteToFile();
                    System.out.println("Write file successfully");
                    break;
                case "4":
                    pa.ReadFromFile();
                    System.out.println("Read file successfully");
                    break;
                case "5":
                    System.out.println("Exit");
            }
            
        }
    }
}
