/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praticeday6;

/**
 *
 * @author tangh
 */
public class DemoException3 {

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 1;
            arr[1] = 0;
            int result = arr[10] / arr[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Loi Index");
        } catch (Exception e) {
            System.out.println("Loi chung");
        } finally {
            System.out.println("Luon chay");
        }
    }
}
