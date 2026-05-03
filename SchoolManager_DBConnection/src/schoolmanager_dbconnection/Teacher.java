/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanager_dbconnection;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public abstract class Teacher implements ITeachable, IStorable{
    String id;
    String name;
    String subject;
    double salary;
    
    public abstract String GetLevel();
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("Input Id: ");
            try{
                id = sc.nextLine().trim();
                if(id.isEmpty()){
                    throw new Exception ("ID must not be empty.");
                }
                break;
                }catch (Exception e) {
                    System.out.print("Error: " + e.getMessage());
            }
        }
        
        while(true){
            System.out.print("Input Name: ");
            try{
                name = sc.nextLine().trim();
                if(name.isEmpty()){
                    throw new Exception("Name must not be empty");
                }
                if(name.length()<=3){
                    throw new Exception("Name mus contain at least 3 characters");
                }
                break;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        while(true){
            System.out.print("Input subject");
            try{
                subject = sc.nextLine().trim();
                if(subject.isEmpty()){
                    throw new Exception("Subject must not be empty");
                }
                break;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        while(true){
            System.out.print("Input salary: ");
            try{
                salary = Double.parseDouble(sc.nextLine().trim());
                if(salary <= 0){
                    throw new Exception ("Salary must be greater than 0");
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        
    }
    
    @Override
    public double CalcBonus(){
        return salary *0.10;
    }
    
    public void PrintInfo(){
        System.out.println(" [" + GetLevel() + "] " + id + " - " +
                 name + ", Subject: " + subject + ", Salary: " + salary + ", Bonus: " + CalcBonus());
    }
    @Override
    public String getTypeCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
