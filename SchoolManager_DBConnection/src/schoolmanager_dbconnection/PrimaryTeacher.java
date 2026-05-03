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
public class PrimaryTeacher extends Teacher {
    int classLevel;
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        
        while(true){
            System.out.print("Input class level: ");
            try{
                classLevel = Integer.parseInt(sc.nextLine().trim());
                if(classLevel<1 || classLevel >5){
                    throw new Exception("Class level must be between 1 and 5");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Error: " +e.getMessage());
            }catch (Exception e){
                System.out.println("Error" + e.getMessage());
            }
        }
    }

    @Override
    public String GetLevel() {
        return "Primary (Gr." + classLevel + ")";
    }
    
    @Override
    public double CalcBonus(){
        return salary * 0.15;
    }
    
    @Override
    public String getTypeCode(){
        return "P";
    }

    @Override
    public void PrintInfo() {
        System.out.println("[PRIMARY TEACHER]");
        super.PrintInfo();
    }
    
    
}
