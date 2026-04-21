/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //show
    void Display() {
        list.forEach(System.out::println);
    }

    //tim top student
    void FindTopStudent() {
        list.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .limit(1)
                .forEach(System.out::println);
    }

    //sap xep theo diem
    void SortByScore() {
        list.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .forEach(System.out::println);
    }
}
