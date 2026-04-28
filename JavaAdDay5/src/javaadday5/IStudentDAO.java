/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday5;

import java.util.List;

/**
 *
 * @author tangh
 */
public interface IStudentDAO {
    void insert(Student s);
    List<Student> findAll();
    Student findById(int id);
    void update(Student s);
    void delete(int id);
}
