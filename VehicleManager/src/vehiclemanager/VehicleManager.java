/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiclemanager;

/**
 *
 * @author tangh
 */
public class VehicleManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        VehicleList list = new VehicleList();

        String option;

        while(true){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorbike");
            System.out.println("3. Add Truck");
            System.out.println("4. Show");
            System.out.println("5. Filter by fuel");
            System.out.println("6. Exit");
            System.out.print("Chon: ");

            option = sc.nextLine();

            switch(option){
                case "1":
                    list.AddCar();
                    break;

                case "2":
                    list.AddMotobike();
                    break;

                case "3":
                    list.AddTruck();
                    break;

                case "4":
                    list.Show();
                    break;

                case "5":
                    System.out.print("Nhap loai nhien lieu: ");
                    String fuel = sc.nextLine();
                    list.FilterByFuel(fuel);
                    break;

                case "6":
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Sai lua chon!");
            }
        }
    }
    }
    

