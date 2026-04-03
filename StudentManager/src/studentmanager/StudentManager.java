package studentmanager;

import java.util.Scanner;

/**
 * Entry point for the Student Management System.
 * Provides a menu-driven CLI to manage undergraduate and graduate student records,
 * demonstrating OOP design with inheritance, polymorphism, and collection management.
 *
 * <p>FR: Point d'entrée du Système de Gestion des Étudiants.
 * Offre une interface CLI par menus pour gérer les dossiers étudiants,
 * illustrant la POO : héritage, polymorphisme et gestion de collections.</p>
 *
 * @author tangh
 * @version 1.0
 */
public class StudentManager {

    /**
     * Launches the interactive student management menu loop.
     * FR: Lance la boucle de menu interactif de gestion des étudiants.
     *
     * @param args Command-line arguments (not used). / Arguments de ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        String option;

        while(true){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Undergraduate");
            System.out.println("2. Add Graduate");
            System.out.println("3. Show");
            System.out.println("4. Sort by GPA");
            System.out.println("5. Find GPA > X");
            System.out.println("6. Exit");
            System.out.print("Chon: ");

            option = sc.nextLine();

            switch(option){
                case "1":
                    list.AddUndergraduate();
                    break;

                case "2":
                    list.Addgraduate();
                    break;

                case "3":
                    list.Show();
                    break;

                case "4":
                    list.SortByGPA();
                    System.out.println("Da sap xep!");
                    break;

                case "5":
                    System.out.print("Nhap GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();
                    list.FindAboveGPA(gpa);
                    break;

                case "6":
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Sai lua chon!");
            }
        }
    }
    
}
