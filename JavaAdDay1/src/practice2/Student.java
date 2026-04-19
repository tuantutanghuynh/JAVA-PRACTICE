/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice2;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public abstract class Student {

    String id;
    String name;

    abstract double getScore();

    void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("  ID: ");
            try {
                id = sc.nextLine().trim();
                if (id.isEmpty()) throw new Exception("ID must not be empty");
                break;
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("  Name: ");
            try {
                name = sc.nextLine().trim();
                if (name.isEmpty()) throw new Exception("Name must not be empty");
                break;
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", score=" + getScore() + "}";
    }
}
