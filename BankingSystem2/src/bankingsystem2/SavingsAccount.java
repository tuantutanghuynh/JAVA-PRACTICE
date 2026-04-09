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
public class SavingsAccount extends Account {
    float interestRate;
    
    @Override
    public void Input(){
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Interest rate: ");
        interestRate = sc.nextFloat();
        sc.nextLine();
    }
    
    @Override
   public void PrinInfo(){
         System.out.println("Account No.: " + accountNumber + ", Account Name: "+ ownerName + ", Balance: " + balance + ", Interest rate: " + interestRate + "%, Temporary interest: " + CalcInterest() );
    }
    @Override
    public double CalcInterest() {
        return balance * interestRate/100;
        
    }
    
    
}
