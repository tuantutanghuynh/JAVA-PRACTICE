/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanager_genericmaplist;


/**
 *
 * @author tangh
 */
public class PrimaryTeacher extends Teacher {
    int classLevel;
    
    @Override
    public void Input(){
        super.Input();
        
        while(true){
            System.out.print("Input class level (1-5): ");
            try{
                String input = sc.nextLine().trim();
                if(input.isEmpty()){
                    throw new Exception("Class level must not be empty");
                }
                int classLevel = Integer.parseInt(input);
                if(classLevel < 1 || classLevel >5){
                    throw new Exception("Class level must be 1..5.");
                }
                this.classLevel = classLevel;
                break;
            }catch(NumberFormatException e){
                System.out.println("Error: Class level must be a number");
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    @Override
    public String GetLevel() {
        return "Primary (Gr. " + classLevel + ")";
    }
    
    @Override
    public double CalcBonus(){
        return salary * 0.15;
    }

    @Override
    public void PrintInfo() {
        System.out.println("[Primary]    ID: " + id + " | Name: " + name + " | Subject: " + subject + " | Salary: " + salary + " | Class: " + classLevel);
    }

    @Override
    public String toString() {
        return "P, " + id + ", " + name + ", " + subject + ", " + salary + ", " + classLevel;
    }
    
    
}
