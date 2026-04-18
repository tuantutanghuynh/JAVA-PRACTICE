package schoolsystem;

import java.util.ArrayList;

public class School {

    ArrayList<Teacher> teachers = new ArrayList<>();

    // -------- Add --------

    public void Add(Teacher t) {
        t.Input();
        teachers.add(t);
        System.out.println("Added: " + t.name);
    }

    // -------- Display --------

    public void Show() {
        if (teachers.isEmpty()) { System.out.println("No teachers in the system."); return; }
        System.out.println("=== SCHOOL (" + teachers.size() + " teachers) ===");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.print((i + 1) + ". ");
            teachers.get(i).PrintInfo();
            System.out.println();
        }
    }

    // -------- Filter by subject --------

    public void FilterBySubject(String subject) {
        if (teachers.isEmpty()) { System.out.println("No teachers yet."); return; }
        if (subject == null || subject.isBlank()) { System.out.println("Subject cannot be empty."); return; }

        System.out.println("--- Teachers teaching '" + subject + "' ---");
        boolean found = false;
        for (Teacher t : teachers) {
            if (t.subject.equalsIgnoreCase(subject)) {
                t.PrintInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) System.out.println("No teacher found for subject: " + subject);
    }

    // -------- Total salary --------

    public void TotalSalary() {
        double total = 0;
        for (Teacher t : teachers) {
            if (t.salary < 0)
                throw new IllegalArgumentException("Invalid salary for " + t.name + ": " + t.salary);
            total += t.salary;
        }
        System.out.printf("Total salary: %.0f VND%n", total);
    }

    // -------- Algorithm: Selection Sort by salary descending --------

    public void SelectionSort() {
        int n = teachers.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (teachers.get(j).salary > teachers.get(maxIdx).salary)
                    maxIdx = j;
            }
            // swap i and maxIdx
            Teacher temp = teachers.get(i);
            teachers.set(i, teachers.get(maxIdx));
            teachers.set(maxIdx, temp);
        }
        System.out.println("Sorted by salary (descending):");
        Show();
    }

    // -------- Algorithm: Second highest salary --------

    public void SecondHighestSalary() {
        if (teachers.size() < 2) { System.out.println("Need at least 2 teachers."); return; }

        Teacher first = null, second = null;

        for (Teacher t : teachers) {
            if (first == null || t.salary > first.salary) {
                second = first;
                first  = t;
            } else if ((second == null || t.salary > second.salary) && t.salary != first.salary) {
                second = t;
            }
        }

        if (second == null) System.out.println("All teachers have the same salary.");
        else System.out.printf("2nd highest salary: %s | %.0f%n", second.name, second.salary);
    }

    // -------- LeetCode #217 — Contains Duplicate --------

    public void ContainsDuplicate() {
        boolean hasDuplicate = false;
        for (int i = 0; i < teachers.size() - 1; i++) {
            for (int j = i + 1; j < teachers.size(); j++) {
                if (teachers.get(i).id.equals(teachers.get(j).id)) {
                    System.out.println("Duplicate ID found: " + teachers.get(i).id
                            + " (" + teachers.get(i).name + " & " + teachers.get(j).name + ")");
                    hasDuplicate = true;
                }
            }
        }
        if (!hasDuplicate) System.out.println("No duplicate IDs.");
    }

    // -------- LeetCode #268 — Missing Number --------
    // Assumes IDs are consecutive integers 1..N+1, one is missing.

    public void MissingNumber() {
        int n = teachers.size();
        int expected = (n + 1) * (n + 2) / 2; // sum of 1..(n+1)
        int actual   = 0;
        for (Teacher t : teachers) {
            try {
                actual += Integer.parseInt(t.id);
            } catch (NumberFormatException e) {
                System.out.println("MissingNumber requires numeric IDs — skipping non-numeric: " + t.id);
                return;
            }
        }
        System.out.println("Missing teacher ID: " + (expected - actual));
    }
}
