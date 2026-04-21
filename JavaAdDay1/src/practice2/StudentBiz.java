/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice2;

import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class StudentBiz extends Student {

    int marketing, sales;

    @Override
    public double getScore() {
        return (marketing * 2 + sales) / 3.0;
    }

    @Override
    void input() {
        System.out.println("--- Biz Student ---");
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("  Marketing score: ");
            try {
                marketing = Integer.parseInt(sc.nextLine().trim());
                if (marketing < 0 || marketing > 10) throw new Exception("Score must be 0-10");
                break;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid integer");
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("  Sales score: ");
            try {
                sales = Integer.parseInt(sc.nextLine().trim());
                if (sales < 0 || sales > 10) throw new Exception("Score must be 0-10");
                break;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid integer");
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "StudentBiz{id=" + id + ", name=" + name + ", marketing=" + marketing + ", sales=" + sales + ", score=" + getScore() + "}";
    }
}
