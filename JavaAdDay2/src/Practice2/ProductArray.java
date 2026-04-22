/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class ProductArray {

    ArrayList<Product> list = new ArrayList<>();
    String filename = "productlist.ser";

    void Add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("name:");
        String name = sc.nextLine();
        System.out.println("price:");
        int price = sc.nextInt();
        Product p = new Product(name, price);
        list.add(p);
    }

    void Show() {
        for (Product p : list) {
            System.out.println(p);
        }
    }

    void WriteToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error write to file");
        }
    }

    void ReadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            list = (ArrayList<Product>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error read file");
        }
    }
}
