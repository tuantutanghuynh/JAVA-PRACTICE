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
public abstract class Account implements IBankable{
    String accountNumber;
    String ownerName;
    double balance;
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input account number: ");
        accountNumber = sc.nextLine();
        System.out.print("Input account name: ");
        ownerName = sc.nextLine();
        System.out.println("Input account balance: ");
        balance = sc.nextDouble();
        sc.nextLine();
    }
    
    public void Deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit successfully");
        } else { System.out.println("The deposit amount must be greater than zero");
    }
    }
    
    public void Withdraw(double amount){
        if ( amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw successfully");
        }else {System.out.println("Insufficient balance");
     
    }
    }
    
    @Override
    public void PrinInfo(){
        System.out.println("Account No.: " + accountNumber + ", Account Name: "+ ownerName + ", Balance: " + balance) ;
    }
    
    @Override
    public double GetBalance(){
        return balance;
    }
    
    public abstract double CalcInterest();
}
