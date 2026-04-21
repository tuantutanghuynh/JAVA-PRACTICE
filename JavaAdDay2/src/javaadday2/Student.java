/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;

import java.io.Serializable;

/**
 *
 * @author tangh
 */
public class Student implements Serializable{
    String name;
    int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", mark=" + mark + '}';
    }
    
    
}
