/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday5;

/**
 *
 * @author tangh
 */
public class TestSingleton {
    public static void main(String[] args) {
       StudentSingleton s1 = StudentSingleton.getInstance();
       StudentSingleton s2= StudentSingleton.getInstance();
        
        System.out.println(s1 == s2);
    }
}
