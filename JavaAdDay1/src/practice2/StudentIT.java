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
public class StudentIT extends Student {

    int java, html, css;

    @Override
    public double getScore() {
        return (java + html + css) / 3.0;
    }

    @Override
    void input() {
        System.out.println("--- IT Student ---");
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("  Java score: ");
            try {
                java = Integer.parseInt(sc.nextLine().trim());
                if (java < 0 || java > 10) throw new Exception("Score must be 0-10");
                break;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid integer");
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("  HTML score: ");
            try {
                html = Integer.parseInt(sc.nextLine().trim());
                if (html < 0 || html > 10) throw new Exception("Score must be 0-10");
                break;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid integer");
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("  CSS score: ");
            try {
                css = Integer.parseInt(sc.nextLine().trim());
                if (css < 0 || css > 10) throw new Exception("Score must be 0-10");
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
        return "StudentIT{id=" + id + ", name=" + name + ", java=" + java + ", html=" + html + ", css=" + css + ", score=" + getScore() + "}";
    }
}
