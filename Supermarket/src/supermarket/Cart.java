package supermarket;

import java.util.ArrayList;

/**
 * Cart class - manages shopping cart items using ArrayList
 * Implements: Insertion Sort, Check Sorted, Best Time to Buy, Running Sum
 * @author tangh
 */
public class Cart {
    
    // ArrayList thay mảng cố định — không cần quản lý biến count
    ArrayList<Item> items = new ArrayList<>();
    
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
