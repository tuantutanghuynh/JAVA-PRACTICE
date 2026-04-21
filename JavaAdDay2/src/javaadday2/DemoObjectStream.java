/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;

import java.io.FileInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author tangh
 */
public class DemoObjectStream {
    public static void main(String[] args)  throws IOException{
        ObjectOutputStream oos = new ObjectOutPutStream(new FileOutputStream("Student.txt"));
    }
}
