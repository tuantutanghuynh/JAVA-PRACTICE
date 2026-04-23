package supermarket;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public abstract class Item implements IStoreItem, Serializable {

    String barcode;
    String name;
    float price;
    int stock;

   public abstract String GetItemType();

    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input Barcode:  ");
            try {
                barcode = sc.nextLine().trim();
                if (barcode.isEmpty()) {
                    throw new Exception("Barcode must not be empty");
                }
                if(!barcode.matches("\\d{4,8}")){
                    throw new Exception("Barcode must be 4-8 digit");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("Input Name:  ");
            try {
                name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new Exception("Name must not be empty");
                }
                if (name.length() <= 3) {
                    throw new Exception("Name must contain more than 3 letters");
                }
                if(name.matches(".*\\d.*")){
                    throw new Exception("Name must not contain number");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Input price:  ");
            try {
                price = Float.parseFloat(sc.nextLine().trim());
                if (price <= 0) {
                    throw new Exception("Price must be greater than 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("Input Stock:  ");
            try {
                stock = Integer.parseInt(sc.nextLine().trim());
                if (stock < 0) {
                    throw new Exception("Stock must be >=0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    @Override
    public boolean IsInStock(){
        return stock > 0;
    }

    @Override
    public String toString() {
        return "Item{" + "barcode=" + barcode + ", name=" + name + ", price=" + price + ", stock=" + stock + '}';
    }
    
    @Override
    public void PrintInfo(){
        System.out.println(toString());
    }
}
            
