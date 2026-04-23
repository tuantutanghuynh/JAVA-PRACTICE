package schoolsystem;

import java.util.Scanner;

public class SchoolSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        School school = new School();

        while (true) {
            printMenu();
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("--- Add Primary Teacher ---");
                    school.Add(new PrimaryTeacher());
                    break;
                case "2":
                    System.out.println("--- Add High School Teacher ---");
                    school.Add(new HighSchoolTeacher());
                    break;
                case "3":
                    school.Show();
                    break;
                case "4":
                    System.out.print("Filter by subject: ");
                    school.FilterBySubject(sc.nextLine().trim());
                    break;
                case "5":
                    school.TotalSalary();
                    break;
                case "6":
                    school.SecondHighestSalary();
                    break;
                case "7":
                    school.WriteToFile();
                    break;
                case "8":
                    school.ReadFromFile();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("   SCHOOL SYSTEM - Bai 12    ");
        System.out.println("==============================");
        System.out.println(" 1. Add Primary Teacher");
        System.out.println(" 2. Add High School Teacher");
        System.out.println(" 3. Show all teachers");
        System.out.println(" 4. Filter by subject");
        System.out.println(" 5. Total salary");
        System.out.println(" 6. 2nd highest salary");
        System.out.println(" 7. Write to file (text)");
        System.out.println(" 8. Read from file (text)");
        System.out.println(" 0. Exit");
        System.out.println("------------------------------");
    }
}
