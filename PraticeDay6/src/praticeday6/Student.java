package praticeday6;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name;
    private int age;
    private float mark;
    private ArrayList<String> listSubject = new ArrayList<>();


    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhap ten (> 3 ky tu): ");
                name = sc.nextLine(); // co the nem Exception neu loi doc input
                if (name.trim().length() < 3) { // NullPointerException neu input = null
                    System.out.println("Loi: Ten phai co nhieu hon 3 ky tu!");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhap tuoi (> 18): ");
                age = sc.nextInt(); // InputMismatchException neu nhap chuoi hoac so thuc
                if (age <= 18) {
                    throw new Exception("age >18");
                }
                break;

            } catch (Exception e) {
                sc.nextLine(); // xoa "abc\n" bi ket trong buffer khi nhap sai
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhap diem (0 - 100): ");
                mark = sc.nextFloat(); // InputMismatchException neu nhap chuoi
                if (mark < 0 || mark > 100) {
                    throw new Exception("0 < mark <100");
                }

                break;
            } catch (Exception e) {
                sc.nextLine(); // xoa "abc\n" bi ket trong buffer khi nhap sai
                System.out.println("Error:" + e.getMessage());
            }
        }
    }

    public void output() {
        System.out.println("=== Thong tin sinh vien ===");
        System.out.println("Ten  : " + name);
        System.out.println("Tuoi : " + age);
        System.out.println("Diem : " + mark);
    }

    public void Add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input subject: ");
        String subject = sc.nextLine();

        // kiểm tra môn học đã tồn tại hay chưa
        for (String sub : listSubject) {
            if (sub.trim().equalsIgnoreCase(subject)) {
                System.out.println("Mon hoc da ton tai:");
                return;
            }
        }
        listSubject.add(subject);
    }
    
    public void Show(){
        System.out.println(listSubject);
    }
}
