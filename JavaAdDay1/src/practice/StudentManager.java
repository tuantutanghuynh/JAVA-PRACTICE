/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tangh
 */
public class StudentManager<T extends Student> {

    Map<String, T> map = new HashMap<>();
    List<T> list = new ArrayList<>();

    //thêm
    void Add(T value) {
        map.put(value.id, value);
        list.add(value);
        System.out.println("Added: " + value.name);
    }

    void Add(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter score: ");
        double score = sc.nextDouble();
        sc.nextLine();
        Add((T) new Student(id, name, score));
    }

    //xóa
    void Remove() {;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Id to remove: ");
        String id = sc.nextLine();
        T value = map.get(id);
        if(value != null) {
            map.remove(id);
            list.remove(value);
            return;
        }
        System.out.println("Id not found");
    }

    //show
    void Show() {
        list.forEach(System.out::println);
    }

    //tim theo ten
    public void FindByName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Id to name: ");
        String name = sc.nextLine();
        
        list.stream()
                .filter(s-> s.name.contains(name))
                .forEach(System.out::println);
    }

    //loc diem(min, max)
    void FilterByScore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input min score to find: ");
        double minScore = sc.nextDouble();
        System.out.println("Input max score to find: ");
        double maxScore = sc.nextDouble();

        list.stream()
                .filter(s -> s.score >= minScore && s.score <= maxScore)
                .forEach(System.out::println);
    }

    //filter: lọc, map: biến đổi, reduce: gộp

    //tinh diem trung binh
    public double AvgScore() {
        return  list.stream()
                        .map(s -> s.score)
                        .reduce(0.0, (a,b) -> a + b) / list.size();
        
    }
}