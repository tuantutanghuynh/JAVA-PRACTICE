package supermarket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Cart class - manages shopping cart items using ArrayList
 * Implements: Insertion Sort, Check Sorted, Best Time to Buy, Running Sum
 * @author tangh
 */
public class Cart {
    
    ArrayList<Item> items = new ArrayList<>();
    String filename = "item.ser";
    
    // -------- Add Item --------
    public void AddItem(Item item) {
        item.Input();
        items.add(item);
        System.out.println("Added: " + item.name);
    }
    
    // -------- Display --------
    public void Show() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("=== CART (" + items.size() + " items) ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". ");
            items.get(i).PrintInfo();
        }
    }
    
    // -------- Checkout --------
    public void Checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty, nothing to checkout.");
            return;
        }
        double total = 0;
        for (Item item : items) {
            total += item.price;
        }
        System.out.printf("Checkout total: %.0f VND%n", total);
    }
    
    // -------- Algorithm: Insertion Sort by price ascending --------
    public void InsertionSort() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty, nothing to sort.");
            return;
        }
        for (int i = 1; i < items.size(); i++) {
            Item key = items.get(i);
            int j = i - 1;
            while (j >= 0 && items.get(j).price > key.price) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }
        System.out.println("Sorted by price (ascending):");
        Show();
    }
    
    // -------- Algorithm: Check if sorted --------
    public void IsSorted() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).price > items.get(i + 1).price) {
                System.out.println("Cart is NOT sorted by price.");
                return;
            }
        }
        System.out.println("Cart IS sorted by price (ascending).");
    }
    
    // -------- LeetCode #121 — Best Time to Buy and Sell Stock --------
    public static void BestTimeToBuy(double[] prices) {
        if (prices.length < 2) {
            System.out.println("Need at least 2 prices.");
            return;
        }
        double minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        System.out.printf("Max profit: %.0f%n", maxProfit);
    }
    
    // -------- Write to file (Serialization) --------
    public void WriteToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(items);
            oos.close();
            System.out.println("Saved " + items.size() + " items to " + filename);
        } catch (Exception e) {
            System.out.println("Error write to file: " + e.getMessage());
        }
    }

    // -------- Read from file (Serialization) --------
    @SuppressWarnings("unchecked")
    public void ReadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            items = (ArrayList<Item>) ois.readObject();
            ois.close();
            System.out.println("Loaded " + items.size() + " items from " + filename);
        } catch (Exception e) {
            System.out.println("Error read file: " + e.getMessage());
        }
    }

    // -------- LeetCode #1480 — Running Sum --------
    public void RunningSum() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double running = 0;
        System.out.println("Running revenue sum:");
        for (Item item : items) {
            running += item.price;
            System.out.printf("  After %s: %.0f VND%n", item.name, running);
        }
    }
}
