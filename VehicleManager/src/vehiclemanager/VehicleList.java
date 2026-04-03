/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclemanager;

import java.util.ArrayList;

/**
 *
 * @author tangh
 */
public class VehicleList {
    ArrayList<Vehicle> vList;
    
    public VehicleList(){
        vList = new ArrayList<>();       
    }
    
    public void AddCar(){
        Car c = new Car();
        c.Input();
        vList.add(c);
    }
    
    public void AddMotobike(){
        Motobike m = new Motobike();
        m.Input();
        vList.add(m);
    }
    
    public void AddTruck(){
        Truck t = new Truck();
        t.Input();
        vList.add(t);
    }
    
    public voiD Show(){
        for(Vehicle v : vList){
            v.ShowInfo();
        }
    }
    
    public void FilterByFuel(String fuel){
        for(Vehicle v : vList){
            if(v.fuelType.equalsIgnoreCase(fuel)){
                v.ShowInfo();
            }
        }
    }
    
}
