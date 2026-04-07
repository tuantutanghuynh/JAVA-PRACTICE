/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praticeday6;

/**
 *
 * @author tangh
 */
public class DemoException {
     public static void main(String[] args) {
        try{
            int a =10;
            int b= 0;
        
            int result = a/b;
            System.out.println(result);
        }catch(Exception e){
            System.out.println("Co loi xay ra: " + e.getMessage() );
        }
        System.out.println("Sth else...");
    }
}

