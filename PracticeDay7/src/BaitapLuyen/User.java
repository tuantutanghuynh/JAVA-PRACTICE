/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaitapLuyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class User {
    String id;
    String name;
    List<Task> tasks = new ArrayList<>();
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Id: ");
        id = sc.nextLine();
        System.out.println("Input user name: ");
        name = sc.nextLine();
    }
    
    public void ShowInfo(){
        System.out.println("User id: " + id + ", User name: " + name + ", Total tasks: " + tasks.size());
    }
}
