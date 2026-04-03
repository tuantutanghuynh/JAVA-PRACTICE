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
public class Truck extends Vehicle{
    double maxLoad;
    
    @Override
      public void Input(){
          super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Max Load: ");
        maxLoad= sc.nextDouble();
      }
      
    @Override
      public void ShowInfo(){
          System.out.println("Brand: " + brand + ", Speed: " + speed + ", Fuel type: " + fuelType + ", Maxload: " + maxLoad);
      }
}
