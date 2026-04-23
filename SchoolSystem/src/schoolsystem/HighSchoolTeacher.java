/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class HighSchoolTeacher extends Teacher {

    String degree;

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
    String GetLevel() {
        return "Highschool (" + degree + ")";
    }

    @Override
    public double CalcBonus(){
        return salary * 0.20;
    }

    @Override
    public void PrintInfo(){
        System.out.println("HIGH SCHOOL TEACHER: ");
        super.PrintInfo();
    }

    @Override
    public String toString() {
        return "H," + id + "," + name + "," + subject + "," + salary + "," + degree;
    }
}
