package BaitapLuyen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTER USER ===");
        TaskManager manager = new TaskManager();
        manager.user.Input();
        manager.user.ShowInfo();

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add task");
            System.out.println("2. Mark done");
            System.out.println("3. Get all tasks");
            System.out.println("4. Get tasks today");
            System.out.println("5. Get completed tasks");
            System.out.println("6. Get overdue tasks");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> manager.addTask();
                case "2" -> manager.markDone();
                case "3" -> manager.getAllTask();
                case "4" -> manager.getTaskToday();
                case "5" -> manager.getCompleteTask();
                case "6" -> manager.getOverDueTask();
                case "7" -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
