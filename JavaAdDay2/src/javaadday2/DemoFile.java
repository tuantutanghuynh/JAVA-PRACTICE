/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;

import java.io.File;

/**
 *
 * @author tangh
 */
public class DemoFile {
    public static void main(String[] args) {
        File file = new File("test.txt");
        
        //Kiểm tra xem file có tồn tại không
        System.out.println(file.exists());
        //lấy đường dẫn của file
        System.out.println(file.getAbsolutePath());
       
        //xóa file
        file.delete();
    }
       
}
