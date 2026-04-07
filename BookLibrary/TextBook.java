package BookLibrary;

import java.util.Scanner;

public class TextBook extends Book {
    String subject;
    int edition;

    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.print("Input Subject: ");
        subject = sc.nextLine();
        System.out.print("Input Edition: ");
        edition = sc.nextInt();
        sc.nextLine();
        sc.close();
    }

    @Override
    public void PrintInfo(){
        System.out.println("Code: " + bookId + ", Book name: " + title + ", Subject: " + subject + ", Edition:" + edition + ", Status: " + (isBorrowed? "Borrowed" : "Available"));
    }

    // Fine 5000/day for any book
    @Override
    public float CalcFine() {
        return 5000;
    }
    
}
