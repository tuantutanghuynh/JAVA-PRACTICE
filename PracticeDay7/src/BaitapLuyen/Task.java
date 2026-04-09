/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaitapLuyen;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class Task {
   String id;
    String title;
    LocalDate deadline;
    boolean isDone;
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Task name: ");
        title = sc.nextLine();
        System.out.print("Deadline (yyyy-mm-dd): ");
        deadline = LocalDate.parse(sc.nextLine());
    }
    
    
    
   @Override
   public String toString() {
    return "Id: " + id 
        + ", Title: " + title 
        + ", Deadline: " + deadline 
        + ", Done: " + isDone ;
}
} 
