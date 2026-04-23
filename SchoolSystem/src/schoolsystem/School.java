/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author tangh
 */
public class School {

    ArrayList<Teacher> teachers = new ArrayList<>();
    String filename = "teacher.txt";

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

    public void WriteToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            for (Teacher t : teachers) {
                fos.write((t.toString() + "\n").getBytes());
            }
            fos.close();
            System.out.println("Saved " + teachers.size() + " teachers to " + filename);
        } catch (Exception e) {
            System.out.println("Error write to file: " + e.getMessage());
        }
    }

    public void ReadFromFile() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            String content = new String(fis.readAllBytes());
            fis.close();
            teachers.clear();
            for (String line : content.split("\n")) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.trim().split(",");
                if (p[0].equals("P")) {
                    PrimaryTeacher t = new PrimaryTeacher();
                    t.id = p[1]; t.name = p[2]; t.subject = p[3];
                    t.salary = Float.parseFloat(p[4]);
                    t.classLevel = Integer.parseInt(p[5]);
                    teachers.add(t);
                } else if (p[0].equals("H")) {
                    HighSchoolTeacher t = new HighSchoolTeacher();
                    t.id = p[1]; t.name = p[2]; t.subject = p[3];
                    t.salary = Float.parseFloat(p[4]);
                    t.degree = p[5];
                    teachers.add(t);
                }
            }
            System.out.println("Loaded " + teachers.size() + " teachers from " + filename);
        } catch (Exception e) {
            System.out.println("Error read file: " + e.getMessage());
        }
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
