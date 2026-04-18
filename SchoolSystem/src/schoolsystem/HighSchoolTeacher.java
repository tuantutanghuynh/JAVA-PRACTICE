package schoolsystem;

import java.util.Scanner;

public class HighSchoolTeacher extends Teacher {

    String degree; // "Bachelor", "Master", or "PhD"

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);
        super.Input();

        while (true) {
            System.out.print("  Degree (Bachelor/Master/PhD): ");
            degree = sc.nextLine().trim();
            if (degree.equalsIgnoreCase("Bachelor")
                    || degree.equalsIgnoreCase("Master")
                    || degree.equalsIgnoreCase("PhD")) {
                break;
            }
            System.out.println("  Error: Please enter 'Bachelor', 'Master', or 'PhD'.");
        }
    }

    @Override
    public String GetLevel() { return "High School (" + degree + ")"; }

    // High school teachers get 20% bonus
    @Override
    public double CalcBonus() { return salary * 0.20; }

    @Override
    public void PrintInfo() {
        System.out.println("[HIGH SCHOOL TEACHER]");
        super.PrintInfo();
    }
}
