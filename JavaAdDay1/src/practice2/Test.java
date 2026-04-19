/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practice2;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class Test {

    public static void main(String[] args) {
        StudentManager<Student> manager = new StudentManager<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT MANAGER ===");
            System.out.println("1. Add IT Student");
            System.out.println("2. Add Biz Student");
            System.out.println("3. Display all");
            System.out.println("4. Find top student");
            System.out.println("5. Sort by score");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    StudentIT it = new StudentIT();
                    it.input();
                    manager.Add(it);
                }
                case "2" -> {
                    StudentBiz biz = new StudentBiz();
                    biz.input();
                    manager.Add(biz);
                }
                case "3" -> manager.Display();
                case "4" -> manager.FindTopStudent();
                case "5" -> manager.SortByScore();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
