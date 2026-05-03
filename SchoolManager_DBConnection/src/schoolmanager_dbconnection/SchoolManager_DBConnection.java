/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanager_dbconnection;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class SchoolManager_DBConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TeacherDAO dao = new TeacherDAO();

            while (true) {
                System.out.println("\n===== SCHOOL DB =====");
                System.out.println("1. Add Primary Teacher");
                System.out.println("2. Add High School Teacher");
                System.out.println("3. Show all teachers");
                System.out.println("4. Filter by subject");
                System.out.println("5. Total salary");
                System.out.println("6. Sort by salary (Selection Sort)");
                System.out.println("7. 2nd highest salary");
                System.out.println("8. Check duplicate IDs");
                System.out.println("9. Find missing ID");
                System.out.println("10. Delete teacher");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                String choice = sc.nextLine().trim();

                try {
                    switch (choice) {
                        case "1": {
                            PrimaryTeacher t = new PrimaryTeacher();
                            t.Input();
                            if (dao.findByID(t.id) != null) {
                                System.out.println("Error: ID " + t.id + " already exists.");
                                break;
                            }
                            if (dao.insert(t)) {
                                System.out.println("Added: " + t.name);
                            } else {
                                System.out.println("Error: Insert failed");
                            }
                            break;
                        }
                        case "2": {
                            HighSchoolTeacher t = new HighSchoolTeacher();
                            t.Input();
                            if (dao.findByID(t.id) != null) {
                                System.out.println("Error: ID " + t.id + " already exists.");
                                break;
                            }
                            if (dao.insert(t)) {
                                System.out.println("Added: " + t.name);
                            } else {
                                System.out.println("Error: Insert failed");
                            }
                            break;
                        }
                        case "3":{
                            List<Teacher> list= dao.findAll();
                            if(list.isEmpty()){
                                System.out.println("No teachers in the system");
                                break;
                            }
                            for(int i = 0; i < list.size(); i++){
                                System.out.println((i+1)+". ");
                                list.get(i).PrintInfo();
                                System.out.println();
                            }
                            break;
                        }
                        case "4" : {
                            System.out.println("Subject: ");
                            String subject = sc.nextLine().trim();
                            if(subject.isEmpty()){
                                System.out.println("Subject cannot be empty");
                                break;
                            }
                            List<Teacher> result = dao.findBySubject(subject);
                            if(result.isEmpty()){
                                System.out.println("No teachers found for subject: " + subject);
                                break;
                            }
                            result.forEach(
                                        t-> {t.PrintInfo();
                                            System.out.println();
                                        });
                            break;
                        }
                        case "5":
                            System.out.println("Total salary: " + dao.totalSalary());
                            break;                 
                        case"6":{
                            List<Teacher> list = dao.findAll();
                            if(list.size() <2){
                                System.out.println("Need at least 2 teachers.");
                                break;}
                            int n = list.size();
                            for(int i = 0 ; i< n-1;i++){
                                int maxIdx= i;
                                for(int j =i +1; j<n; j++){
                                    if(list.get(j).salary > list.get(maxIdx).salary){
                                        maxIdx = j;
                                    }
                                }
                                Teacher temp= list.get(i);
                                list.set(i, list.get(maxIdx));
                                list.set(maxIdx, temp);
                            }
                            System.out.println("Sorted by salary descending: ");
                            for(int i= 0; i < list.size(); i++ ){
                                System.out.println((i+1) + ". ");
                                list.get(i).PrintInfo();
                                System.out.println();
                            }
                            break;
                        }
                        case "7":{
                            List<Teacher> list = dao.findAll();
                            if(list.size()<2){
                                System.out.println("Need at least 2 teachers.");
                                break;
                            }
                            Teacher first = null, second = null;
                            for (Teacher t : list) {
                                if (first == null || t.salary > first.salary) {
                                    second = first;
                                    first  = t;
                                } else if ((second == null || t.salary > second.salary) && t.salary != first.salary) {
                                    second = t;
                                }
                            }
                            if(second == null){
                                System.out.println("All teachers have the same salary. ");
                            }else {
                                System.out.println("2nd highest salary: " + second.name + ", " +second.salary);
                            }
                            break;
                        }
                        case"8":{
                            List<Teacher> list= dao.findAll();
                            boolean hasDuplicate = false;
                            for(int i= 0; i < list.size() ; i++){
                                for(int j=i+1; j< list.size(); j++){
                                    if(list.get(i).id.equalsIgnoreCase(list.get(j).id)){
                                        System.out.println("Duplicate ID: " + list.get(i).id);
                                        hasDuplicate = true;
                                    }
                                }
                            }
                            if(!hasDuplicate){
                                System.out.println("No duplicate IDs");
                            }
                            break;
                        }
                        case "9":{
                            List<Teacher> list = dao.findAll();
                            int n = list.size();
                            int expected = (n+1)*(n+2)/2;
                            int actual = 0;
                            boolean valid = true;
                            for(Teacher t :list){
                                try{
                                    actual += Integer.parseInt(t.id);
                                }catch (NumberFormatException e){
                                    System.out.println("Missing number requires numeric IDs - skipping: " + t.id);
                                    valid = false;
                                    break;
                                }
                            }
                            if(valid){
                                System.out.println("Missing teacher ID: "+ (expected-actual));
                            }
                            break;
                        }
                        case "10":{
                            System.out.println("Enter ID to delete: ");
                            String id= sc.nextLine().trim();
                            if(!dao.delete(id)){
                                System.out.println("Error: ID not found or delete failed.");
                            }else{
                                System.out.println("Deleted: " +id);
                            }
                            break;
                        }
                        case "0":
                            System.out.println("Goodbye!");
                            return;
                    }
                    }catch (Exception e){
                            System.out.println("Error: " + e.getMessage());
                            }
                }
            }
        }

    }
