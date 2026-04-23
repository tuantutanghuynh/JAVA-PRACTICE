/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaadday3;

/**
 *
 * @author tangh
 */
public class JavaAdDay3 implements Runnable{
    private String name;
    private volatile boolean running = true;
    private volatile boolean pause = false;
    
    public JavaAdDay3(String name){
        this.name = name;
    }

    public void stopTask(){
        running = false;
    }
    
    public void pauseTask(){
        pause = true;
    }
    
    public void resumeTask(){
        pause = false;
    }
    
    @Override
    public void run() {
        int i = 1;
        
        while(running && 1 <=10){
            while(pause){
                try{
                    Thread.sleep(2000);                 
                        }catch (Exception e){
                            e.printStackTrace();
                        }
            }
            System.out.println(name + "chay " + i);
            try{
                Thread.sleep(3000);            
            }catch(Exception e){
                e.printStackTrace();
            }
            i++;
        }
        System.out.println(name +"Da dung!");
    }
    public static void main(String[] args) throws InterruptedException {
        JavaAdDay3 task1 = new  JavaAdDay3("luong 1 ");
        JavaAdDay3 task2 = new  JavaAdDay3("luong 2 ");
        
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        
        //trước khi chạy sert priority
        t1.setPriority(Thread.MIN_PRIORITY);//1
        t2.setPriority(Thread.MAX_PRIORITY);//10
        
        t1.start();
        t2.start();
        
        Thread.sleep(4000);
        
        System.out.println("Tam dung luong 1");
        task1.pauseTask();
        
        Thread.sleep(5000);
        System.out.println("luong 1 tiep tuc");
        task1.resumeTask();
        
        Thread.sleep(6000);
        System.out.println("luong 2 dung han");
        task2.stopTask();
        System.out.println("Ket thuc");
        
        t1.join();
    }
}