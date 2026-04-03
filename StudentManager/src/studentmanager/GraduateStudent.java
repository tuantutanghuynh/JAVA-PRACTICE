package studentmanager;

import java.util.Scanner;

/**
 * Represents a graduate student, extending {@link Student} with a thesis title.
 * Demonstrates polymorphism: the same {@code ShowInfo()} call produces different output per type.
 *
 * <p>FR: Représente un étudiant en master/doctorat, étendant {@link Student} avec un titre de thèse.
 * Illustre le polymorphisme : le même appel {@code ShowInfo()} produit un affichage différent selon le type.</p>
 *
 * @author tangh
 * @version 1.0
 * @see Student
 */
public class GraduateStudent extends Student {

    String thesisTitle;

    /**
     * Reads graduate-specific data after collecting base student fields.
     * FR: Saisit les données spécifiques au master/doctorat après les champs de base.
     */
    @Override
    public void Input() {
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Thesis Title: ");
        thesisTitle = sc.nextLine();
    }

    /**
     * Displays full graduate student profile including thesis title.
     * FR: Affiche le profil complet de l'étudiant, y compris le titre de la thèse.
     */
    @Override
    public void ShowInfo() {
        System.out.println("St. ID: " + id + ", Name: " + name + ", GPA: " + gpa
                + ", Rank: " + GetRank() + ", Thesis: " + thesisTitle);
    }
}