/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author tangh
 */
public class Student {
    String id, name;
    double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", score=" + score + '}';
    }
    
    
}
