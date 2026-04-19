/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.util.ArrayList;

/**
 *
 * @author tangh
 */
public class School {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public void Add(Teacher t) {
        t.Input();
        teachers.add(t);
        System.out.println("Added: " + t.name);
    }

    public void Show() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers in the system");
            return;
        }
        System.out.println("SCHOOL (" + teachers.size() + " teacher) ");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". ");
            teachers.get(i).PrintInfo();
            System.out.println();
        }
    }

    public void FilterBySubject(String subject) {
        if (teachers.isEmpty()) {
            System.out.println("No teachers yet. ");
            return;
        }
        if (subject == null || subject.isBlank()) {
            System.out.println("Subject cannot be empty. ");
            return;
        }

        System.out.println("Teachers teaching:  " + subject);
        boolean found = false;
        for (Teacher t : teachers) {
            if (t.subject.equalsIgnoreCase(subject)) {
                t.PrintInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No teacher found for subject: " + subject);
        }

    }

    public void TotalSalary() {
        double total = 0;
        for (Teacher t : teachers) {
            try {
                if (t.salary < 0) {
                    throw new Exception("Invalid salary for " + t.name + ": " + t.salary);
                }
                total += t.salary;
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
        System.out.printf("Total salary: %.0f VND%n", total);
    }

    public void SecondHighestSalary() {
        if (teachers.size() < 2) {
            System.out.println("Need at least 2 teachers");
            return;
        }

        Teacher first = null, second = null;
        for (Teacher t : teachers) {
            if (first == null || t.salary > first.salary) {
                second = first;
                first = t;
            } else if ((second == null || t.salary > second.salary) && t.salary != first.salary) {
                second = t;
            }
        }
        
        if( second == null){
            System.out.println("All teachers have the same salary.");
        }else {
            System.out.println("2nd highest salary: " + second.name + ", " +second.salary);
        }
    }
}
