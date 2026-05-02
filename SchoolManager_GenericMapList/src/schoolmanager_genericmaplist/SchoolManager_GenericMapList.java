/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanager_genericmaplist;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class SchoolManager_GenericMapList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        SchoolManager<Teacher> manager = new SchoolManager<>();

        while(true){
            System.out.println("\n===== SCHOOL MANAGER =====");
            System.out.println("1. Add Primary Teacher");
            System.out.println("2. Add High School Teacher");
            System.out.println("3. Display all");
            System.out.println("4. Filter by subject");
            System.out.println("5. Total salary");
            System.out.println("6. Sort by salary desc");
            System.out.println("7. Second highest salary");
            System.out.println("8. Check duplicate ID");
            System.out.println("9. Write file");
            System.out.println("10. Read file");
            System.out.println("11. Write file async");
            System.out.println("12. Read file async");
            System.out.println("13. Total salary async");
            System.out.println("14. Write async + join demo");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            
            try {
                switch (choice) {
                    case "1":
                        manager.Add(new PrimaryTeacher());
                        break;
                    case "2":
                        manager.Add(new HighSchoolTeacher());
                        break;
                    case "3":
                        manager.Display();
                        break;
                    case "4":
                        System.out.print("Subject: ");
                        manager.FilterBySubject(sc.nextLine().trim());
                        break;
                    case "5":
                        manager.TotalSalary();
                        break;
                    case "6":
                        manager.SelectionSortBySalaryDesc();
                        manager.Display();
                        break;
                    case "7":
                        manager.SecondHighestSalary();
                        break;
                    case "8":
                        manager.ContainsDuplicate();
                        break;
                    case "9":
                        manager.WriteToFile();
                        break;
                    case "10":
                        manager.ReadFromFile();
                        break;
                    case "11": {
                        Thread t = manager.WriteToFileAsync();
                        System.out.println("Write running in background: " + t.getName());
                        break;
                    }
                    case "12": {
                        Thread t2 = manager.ReadFromFileAsync();
                        System.out.println("Read running in background: " + t2.getName());
                        break;
                    }
                    case "13": {
                        Thread t3 = manager.TotalSalaryAsync();
                        System.out.println("Salary calc running in background: " + t3.getName());
                        break;
                    }
                    case "14": {
                        Thread t4 = manager.WriteToFileAsync();
                        System.out.println("Write async started: " + t4.getName());
                        System.out.println("Main thread waiting (join)...");
                        t4.join();
                        System.out.println("Write done. Main thread continues.");
                        break;
                    }
                    case "0":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        }
    }

}
