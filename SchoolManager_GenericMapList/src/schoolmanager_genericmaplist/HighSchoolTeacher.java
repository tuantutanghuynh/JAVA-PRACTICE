/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanager_genericmaplist;


/**
 *
 * @author tangh
 */
public class HighSchoolTeacher extends Teacher{
    String degree;
    
    @Override
    public void Input(){
        super.Input();
        
        while(true){
            System.out.println("Input Degree : Bachelor | Master | PhD: ");
            try{
                degree = sc.nextLine().trim();            
                if(!degree.equalsIgnoreCase("Bachelor") && !degree.equalsIgnoreCase("Master") && !degree.equalsIgnoreCase("PhD")){
                    throw new Exception("Degree must be Bachelor/Master/PhD.");
                }
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    

    @Override
    public String GetLevel() {
       return "High school (" + degree + ")";
    }
    
    @Override
    public double CalcBonus(){
        return salary * 0.20;
    }
    
    @Override
    public void PrintInfo() {
        System.out.println("[HighSchool] ID: " + id + " | Name: " + name + " | Subject: " + subject + " | Salary: " + salary + " | Degree: " + degree);
    }

    @Override
    public String toString(){
        return "H, " + id + ", " + name + ", " + subject + ", " + salary + ", " + degree;
    }
    
}
