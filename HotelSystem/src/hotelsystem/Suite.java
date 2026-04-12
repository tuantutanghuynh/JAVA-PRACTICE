/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class Suite extends Room {

    int numRoom;

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);
        super.Input();

        while (true) {
            System.out.print("Number of rooms in suite: ");
            try {
                numRoom = Integer.parseInt(sc.nextLine().trim());
                if (numRoom <= 0) {
                    throw new Exception("Number of rooms must be > 0");
                }
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
    
    public void PrintInfo(){
        System.out.println("[SUITE]");
        super.PrintInfo();
        System.out.println("Room in suite: " + numRoom);
    }

    @Override
    public String GetRoomType() {
       return "Suite";
    }
    
    public double CalcCost(int nights){
        return pricePerNight * nights * 2.0;
    }
}
