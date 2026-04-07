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
public class DemoException2 {
     public static void main(String[] args) {
        int[] arr = new int [5];
        Scanner sc = new Scanner(System.in);
        
        while(true){
        try{
        System.out.println("Input number 1");
        arr[0] = sc.nextInt();
        break;
        }catch(Exception e){
            sc.nextLine();
            System.out.println("Error: " + e.getMessage());
        }
        
        
        while(true){
        try{
        System.out.println("Input number:");
        arr[1] = sc.nextInt();
        if(arr[1]==0){
            System.out.println("Number cannot be zero");
            continue;}
        break;
                }catch(Exception e){
            sc.nextLine();
            System.out.println("Error: " + e.getMessage());
        }
               
        
        
        try{
        int result = arr[0]/arr[1];
        System.out.println("result:" + result);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
        }
     }
}


