/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem2;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class CheckingAccount extends Account {
    double overdraftLimit;
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input overdraft number: ");
        overdraftLimit= sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public double CalcInterest() {
        
    }
    
}
