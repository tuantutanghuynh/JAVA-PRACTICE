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
public class HighSchoolTeacher extends Teacher{
    String degree;
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        
        while(true){
              System.out.print("Input degree: ");
              try{
                  degree = sc.nextLine().trim();
                  if(!degree.equalsIgnoreCase("Bachelor") && !degree.equalsIgnoreCase("Master") && !degree.equalsIgnoreCase("PhD")){
                      throw new Exception("Please enter 'Bachelor', 'Master', or 'PhD'.");
                  }
                  break;
              }catch(Exception e){
                  System.out.println("Error: " + e.getMessage());
              }
        }
    }

    @Override
    public String GetLevel() {
        return "High School (" +degree +")";
    }
    
    @Override
    public double CalcBonus(){
        return salary * 0.20;
    }
    
    public String getTypeCode(){
        return "H";
    }

    @Override
    public void PrintInfo() {
        System.out.println("[HIGH SCHOOL TEACHER");
        super.PrintInfo();
}
}