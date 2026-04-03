package studentmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Manages a heterogeneous collection of {@link Student} objects (undergraduate and graduate).
 * Leverages generics, the Comparator pattern, and polymorphic dispatch for flexible data operations.
 *
 * <p>FR: Gère une collection hétérogène d'objets {@link Student} (licence et master/doctorat).
 * Utilise les génériques, le patron Comparator et la liaison dynamique pour des opérations flexibles.</p>
 *
 * @author tangh
 * @version 1.0
 */
public class StudentList {

    ArrayList<Student> stList;

    /**
     * Initializes an empty student list.
     * FR: Initialise une liste d'étudiants vide.
     */
    public StudentList() {
        stList = new ArrayList<>();
    }

    /**
     * Prompts for input and adds a new undergraduate student to the list.
     * FR: Saisit et ajoute un nouvel étudiant en licence à la liste.
     */
    public void AddUndergraduate() {
        UndergraduateStudent s = new UndergraduateStudent();
        s.Input();
        stList.add(s);
    }

    /**
     * Prompts for input and adds a new graduate student to the list.
     * FR: Saisit et ajoute un nouvel étudiant en master/doctorat à la liste.
     */
    public void Addgraduate() {
        GraduateStudent s = new GraduateStudent();
        s.Input();
        stList.add(s);
    }

    /**
     * Displays all students using polymorphic {@code ShowInfo()} dispatch.
     * FR: Affiche tous les étudiants via le polymorphisme de {@code ShowInfo()}.
     */
    public void Show() {
        for (Student s : stList) {
            s.ShowInfo();
        }
    }

    /**
     * Sorts the student list by GPA in descending order (highest first).
     * Uses an anonymous {@link Comparator} for flexible, in-place sorting.
     *
     * <p>FR: Trie la liste par moyenne décroissante (la plus haute en premier).
     * Utilise un {@link Comparator} anonyme pour un tri flexible sur place.</p>
     */
    public void SortByGPA() {
        Collections.sort(stList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.gpa, o1.gpa);
            }
        });
    }

    /**
     * Filters and displays students whose GPA exceeds the given threshold.
     * FR: Filtre et affiche les étudiants dont la moyenne dépasse le seuil donné.
     *
     * @param gpa Minimum GPA threshold (exclusive). / Seuil minimal de moyenne (exclusif).
     */
    public void FindAboveGPA(double gpa) {
        for (Student s : stList) {
            if (s.gpa > gpa) {
                s.ShowInfo();
            }
        }
    }
}