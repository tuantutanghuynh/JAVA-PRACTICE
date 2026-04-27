/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class ProductArray {
    ArrayList<Product> list = new ArrayList<>();
    String filename = "product.txt";
    
    void Add(){
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        String id =sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        float price = sc.nextFloat();
        Product p = new Product(id, name, price);
        list.add(p);
    }
    
    void Show(){
        for(Product p : list){
            System.out.println(p);
        }
    }
    
    void WriteToFile(){
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            for(Product p : list){
                String line = p.toString() + "\n";
                fos.write(line.getBytes());
            }
            fos.close();
        }catch(Exception e){
            System.out.println("Error to write fo file");
        }
    }
    
    void ReadFromFile(){
        try{
            FileInputStream fis = new FileInputStream(filename);
            
            byte[] data = fis.readAllBytes();
            String content = new String(data);
            fis.close();
            
            String[] lines = content.split("\n");
            
            for(String line : lines){
                if(!line.trim().isEmpty()){
                    String[] parts = line.split(", ");
                    Product p = new Product (
                        parts[0],
                        parts[1],
                        Float.parseFloat(parts[2]));
                    list.add(p);
                }
            }     
        }catch (Exception e) {
            System.out.println("Error read file");
        }
    }
}
