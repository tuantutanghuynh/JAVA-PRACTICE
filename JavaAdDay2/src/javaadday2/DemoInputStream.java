/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author tangh
 */
public class DemoInputStream {

    public static void main(String[] args) {
        //ghi file
        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            fos.write("Hello world".getBytes());
            fos.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file");
        }
        
        
    // đọc file
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            fis.close();
        } catch (Exception e) {
            System.out.println("Loi doc file");
        }
    }
}
