/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanager_genericmaplist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tangh
 */
public class SchoolManager<T extends Teacher> {
    private final Map<String,  T> map = new HashMap<>();
    private final List<T> list = new ArrayList<>();
    private final Object lock = new Object();
    private final String filename = "teacher.txt";
    
    public void Add(T value){
        value.Input();
        
        synchronized (lock) {
            if (map.containsKey(value.id)){
                System.out.println("Duplicate ID: " + value.id + " -> rejected");
                return;
            }
            
            map.put(value.id, value);
            list.add(value);
        }
        
        System.out.println("Added: " + value.name);
    }
    
    public void Display(){
        List<T> snapshot;
        synchronized (lock){
            snapshot = new ArrayList<>(list);
        }
        
        if(snapshot.isEmpty()){
            System.out.println("No teachers in the system.");
            return;
        }
        snapshot.forEach(Teacher::PrintInfo);
    }
    
    public void FilterBySubject(String subject){
        if(subject == null || subject.isBlank()){
            System.out.println("Subject cannot be empty.");
            return;
        }
        
        List<T> snapshot;
        synchronized (lock){
            snapshot = new ArrayList<>(list);
        }
        
        if(snapshot.isEmpty()){
            System.out.println("No teachers yet");
            return;
        }
        
        boolean found = false;
        for(T t : snapshot){
            if(t.subject.equalsIgnoreCase(subject)){
                t.PrintInfo();
                found = true;
            }
        }
        if(!found){
            System.out.println("No teacher found for subject: " + subject);
        }
    }
    
    public void TotalSalary(){
        List<T> snapshot;
        synchronized (lock){
            snapshot = new ArrayList<>(list);
        }
        
        double total = 0 ;
        for(T t: snapshot){
            if(t.salary < 0){
                throw new IllegalArgumentException("Invalid salary for " + t.name + ": " + t.salary);
            }
            total += t.salary;
        }
        System.out.println("Total salary: " + total);
    }
    
    public void SelectionSortBySalaryDesc(){
        synchronized (lock){
            int n = list.size();
            for (int i = 0; i < n -1; i++){
                int maxIdx = i;
                for(int j = i +1; j< n ; j++){
                    if(list.get(j).salary > list.get(maxIdx).salary){
                        maxIdx = j;
                    }
                }
                 T temp = list.get(i);
                 list.set(i, list.get(maxIdx) );
                 list.set(maxIdx, temp);
            }       
        }
        System.out.println("Sorted by salary desc");
    }

public void SecondHighestSalary(){
    List<T> snapshot;
    synchronized (lock){
        snapshot = new ArrayList<>(list);
    }
    
    if(snapshot.size()<2){
        System.out.println("Need at least 2 teachers.");
        return;
    }
    
    T first = null;
    T second = null;
    
    for (T t: snapshot){
        if(first == null || t.salary > first.salary){
            second = first;
            first = t;
        }else if ((second == null || t.salary > second.salary) && t.salary != first.salary ){
            second =t;
        }
    }
    
    if(second == null){
        System.out.println("All teachers have the same salary");
    }else {
        System.out.println("2nd highest: " + second.name + " with " + second.salary);
    }
}

public void ContainsDuplicate(){
    List<T> snapshot;
    synchronized (lock){
        snapshot = new ArrayList<>(list);
    }
    
    boolean hasDup = false;
    for(int i = 0; i < snapshot.size(); i++){
        for (int j = i + 1; j < snapshot.size(); j++){
            if(snapshot.get(i).id.equals(snapshot.get(j).id)){
                hasDup = true;
                System.out.println("Duplicate ID found: " + snapshot.get(i).id);
            }
        }
    }
    if(!hasDup){
        System.out.println("No Duplicate IDs");
    }
}

public void WriteToFile(){
    List <T> snapshot;
    synchronized (lock){
        snapshot = new ArrayList<>(list);
    }
    
    try(
            FileOutputStream fos = new FileOutputStream(filename)){
        for(T t : snapshot){
            String line = t.toString() + "\n";
            fos.write(line.getBytes(StandardCharsets.UTF_8));
        }
        System.out.println("Write file success.");
    }catch (Exception e){
        System.out.println("Error write file: " + e.getMessage());
    }
}

@SuppressWarnings("unchecked")
public void ReadFromFile(){
    try(FileInputStream fis = new FileInputStream(filename)){
        byte[] data = fis.readAllBytes();
        String content = new String(data, StandardCharsets.UTF_8);
        String[] lines = content.split("\\R");
        
        Map<String, T> tempMap = new HashMap<>();
        List<T> tempList = new ArrayList<>();
        
        for(String line : lines){
            if(line.isBlank()) {
                continue;
            }
            String[] p = line.split(", ");
            Teacher t = null;
            
            if ("P".equals(p[0])) {
                    PrimaryTeacher pt = new PrimaryTeacher();
                    pt.id = p[1];
                    pt.name = p[2];
                    pt.subject = p[3];
                    pt.salary = Double.parseDouble(p[4]);
                    pt.classLevel = Integer.parseInt(p[5]);
                    t = pt;
                } else if ("H".equals(p[0])) {
                    HighSchoolTeacher ht = new HighSchoolTeacher();
                    ht.id = p[1];
                    ht.name = p[2];
                    ht.subject = p[3];
                    ht.salary = Double.parseDouble(p[4]);
                    ht.degree = p[5];
                    t = ht;
                }

                if (t != null) {
                    T value = (T) t;
                    if (!tempMap.containsKey(value.id)) {
                        tempMap.put(value.id, value);
                        tempList.add(value);
                    }
                }
            }

            synchronized (lock) {
                map.clear();
                list.clear();
                map.putAll(tempMap);
                list.addAll(tempList);
            }

            System.out.println("Read file success.");
        } catch (Exception e) {
            System.out.println("Error read file: " + e.getMessage());
        }
    }

    public Thread WriteToFileAsync() {
        Thread worker = new Thread(this::WriteToFile, "write-file-thread");
        worker.start();
        return worker;
    }

    public Thread ReadFromFileAsync() {
        Thread worker = new Thread(this::ReadFromFile, "read-file-thread");
        worker.start();
        return worker;
    }

    public Thread TotalSalaryAsync() {
        Thread worker = new Thread(this::TotalSalary, "salary-thread");
        worker.start();
        return worker;
    }
}
    
    
