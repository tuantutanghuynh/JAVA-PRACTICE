/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praticeday6;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class DemoThrow {
    public static void main(String[] args)  {
        try{
            Scanner sc = new Scanner(System.in);
        System.out.println("Input age: ");
        int age = sc.nextInt();
        
        if (age < 0){
            throw new Exception("Age >0");
        }
        
        }catch(Exception e){
            System.out.println("Loi:" +e.getMessage());
            
        }
    }
}

//thows Exception, và throw Exxception