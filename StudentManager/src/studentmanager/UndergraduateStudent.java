package studentmanager;

import java.util.Scanner;

/**
 * Represents an undergraduate student, extending {@link Student} with enrollment year.
 * Applies inheritance and method overriding to specialize behavior.
 *
 * <p>FR: Représente un étudiant de licence, étendant {@link Student} avec l'année d'inscription.
 * Applique l'héritage et la redéfinition de méthodes pour spécialiser le comportement.</p>
 *
 * @author tangh
 * @version 1.0
 * @see Student
 */
public class UndergraduateStudent extends Student {

    int year;

    /**
     * Reads undergraduate-specific data after collecting base student fields.
     * FR: Saisit les données spécifiques à la licence après les champs de base.
     */
    @Override
    public void Input() {
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input year: ");
        year = sc.nextInt();
    }

    /**
     * Displays full undergraduate student profile including enrollment year.
     * FR: Affiche le profil complet de l'étudiant en licence, y compris l'année.
     */
    @Override
    public void ShowInfo() {
        System.out.println("St. ID: " + id + ", Name: " + name + ", GPA: " + gpa
                + ", Rank: " + GetRank() + ", Year: " + year);
    }
}