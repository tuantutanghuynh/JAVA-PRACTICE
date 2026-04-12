/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class PhoneArray {
    static final int MAX = 20;
    Phone[] pArray = new Phone[MAX];
    int count =0;
    
    void Add(Scanner sc){
        if(count == MAX) {
            System.out.println("Error: Array is full");
            return;
        }
        while(true){
            Phone p = new Phone();
            try{
                p.Input();
                for (int i = 0; i < count; i++) {
                    if (pArray[i].getId().equals(p.getId()))
                        throw new Exception("ID " + p.getId() + " already exists.");              
                }
                pArray[count++] = p;
                System.out.println("Added: " + p.getId());
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    void Show(){
        if (count == 0) {
            System.out.println("Error: Array is empty");
            return;
        }
        System.out.println("Phone List: " + count + "phones");
        for(int i = 0; i< count ; i++){
            System.out.println( (i + 1) + ". " + pArray[i]);
        }
    }
    
    void SearchByPrice(int min, int max) {
        if (count == 0) {
            System.out.println("Error: Array is empty."); 
            return; 
        }
        if (min >= max) { 
            System.out.println("Error: Min must be < max."); 
            return; }

        System.out.println("--- Phones with price in [" + min + ", " + max + "] ---");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (pArray[i].getPrice() >= min && pArray[i].getPrice() <= max) {
                System.out.println(pArray[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No phones found in price range [" + min + ", " + max + "].");
    }
    
    public void DeleteById(String id) {
        if (count == 0) { 
            System.out.println("Error: Array is empty."); 
            return; 
        }

        for (int i = 0; i < count; i++) {
            if (pArray[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    pArray[j] = pArray[j + 1]; 
                }
                pArray[--count] = null; 
                System.out.println("Deleted ID: " + id);
                return;
            }
        }
        System.out.println("Error: ID " + id + " not found.");
    }
    
}
