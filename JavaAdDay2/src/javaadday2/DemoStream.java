/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday2;



import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tangh
 */
public class DemoStream {
    public static void main(String[] args) {
                List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        
        list.stream()
                .filter(x -> x % 2 ==0)
                .map(x -> x*2)
                .forEach(System.out::println);
        
        //takeWhile: lấy phần tử đến khi điều kiện sai
        list.stream()
                .takeWhile(x-> x<4)
                .forEach(System.out::println);
        //dropWhile: bỏ phần tử đến khi điều kiện sai
         list.stream()
                .dropWhile(x-> x<4)
                .forEach(System.out::println);
                
                
    }

}
