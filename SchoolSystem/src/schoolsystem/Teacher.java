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
public abstract class Teacher implements ITeachable {

    String id;
    String name;
    String subject;
    float salary;

    abstract String GetLevel();

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Teacher ID: ");
            try {
                id = sc.nextLine().trim();
                if (id.isEmpty()) {
                    throw new Exception("ID must not be empty");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Input Name:  ");
            try {
                name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new Exception("Name must not be empty.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Subject : ");
            try {
                subject = sc.nextLine().trim();
                if (subject.isEmpty()) {
                    throw new Exception("Subject must not be empty. ");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
       while(true){
           System.out.println("Salary : ");
           try{
               salary = Float.parseFloat(sc.nextLine().trim());
               if(salary <=0){
                   throw new Exception("Salary must be  >0");
               }
               break;
           } catch (NumberFormatException e){
               System.out.println("Error: Please enter a valid number");
           }catch(Exception e){
               System.out.println("Error: " +e.getMessage());
           }
       }
    }
    
    @Override
    public double CalcBonus(){
        return salary * 0.10;
    }
    
    @Override
    public void PrintInfo(){
       System.out.println("  [" + GetLevel() + "] " + id + " - " + name + " | Subject: " + subject + " | Salary: " + salary + " | Bonus: " + CalcBonus());

    }
}
