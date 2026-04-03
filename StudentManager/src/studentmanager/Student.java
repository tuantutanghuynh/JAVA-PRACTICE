package studentmanager;

import java.util.Scanner;

/**
 * Abstract base class representing a student entity.
 * Demonstrates OOP principles: encapsulation and polymorphism via subclassing.
 *
 * <p>FR: Classe de base représentant un étudiant.
 * Illustre les principes POO : encapsulation et polymorphisme par héritage.</p>
 *
 * @author tangh
 * @version 1.0
 */
public class Student {

    String id;
    String name;
    Float gpa;

    /**
     * Reads student data from standard input.
     * FR: Saisit les données de l'étudiant depuis l'entrée standard.
     */
    public void Input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Student Id: ");
        id = sc.nextLine();

        System.out.println("Input Student name: ");
        name = sc.nextLine();

        System.out.println("Input Student's gpa: ");
        gpa = sc.nextFloat();
        sc.nextLine();
    }

    /**
     * Displays student information to standard output.
     * Overridden in subclasses to include type-specific fields.
     *
     * <p>FR: Affiche les informations de l'étudiant.
     * Redéfinie dans les sous-classes pour inclure les champs spécifiques.</p>
     */
    public void ShowInfo() {
    }

    /**
     * Determines the academic rank based on GPA.
     * FR: Détermine le rang académique en fonction de la moyenne.
     *
     * @return Academic rank label: "Excellent", "Good", "Average", or "Bad".
     *         / Libellé du rang : "Excellent", "Good", "Average" ou "Bad".
     */
    public String GetRank() {
        if (gpa >= 8) {
            return "Excellent";
        } else if (gpa >= 6.5) {
            return "Good";
        } else if (gpa >= 5) {
            return "Average";
        } else {
            return "Bad";
        }
    }
}
