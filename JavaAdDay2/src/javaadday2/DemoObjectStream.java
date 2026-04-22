/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // ghi file (serialize)
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("Student.ser")
        );

        oos.writeObject(new Student("van A", 100));
        oos.close();

        // đọc file (deserialize)
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Student.ser")
        );

        Student s = (Student) ois.readObject();
        System.out.println(s);

        ois.close();
    }
}