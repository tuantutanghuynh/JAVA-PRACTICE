/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclemanager;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class Motobike extends Vehicle {
    int engineCC;
    
    @Override
    public void Input(){
          super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Engine CC: ");
        engineCC = sc.nextInt();
      }
    
    public void ShowInfo(){
          System.out.println("Brand: " + brand + ", Speed: " + speed + ", Fuel type: " + fuelType + ", Engine CC: " +engineCC);
      }
    
}
