package repositories;

import entities.Phone;

public class PhoneDAO {

    Phone[] arr = new Phone[20];
    int max = 20;
    int next = 0;

    public void createPhone(Phone newPhone) {
        if (next == max) {
            System.out.println("Error: Catalog is full.");
            return;
        }
        arr[next] = newPhone;
        next++;
        System.out.println("Phone added successfully.");
    }

    public void findByBrand(String keyword) {
        boolean found = false;
        System.out.println(" Search results for brand: " + keyword + ":");
        for (int i = 0; i < next; i++) {
            if (arr[i].brand.equalsIgnoreCase(keyword)) {
                System.out.println((i + 1) + ".");
                arr[i].print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No phone to display.");
        }
    }
}
