package BookLibrary;

import java.util.Scanner;

public class Novel extends Book {
    String genre;
    int pages;

    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.print("Input Genre: ");
        genre = sc.nextLine();
        System.out.print("Input Number of Pages: ");
        pages = sc.nextInt();
        sc.nextLine();
        sc.close();
    }

    @Override
    public void PrintInfo(){
        System.out.println("Code: " + bookId + ", Book name: " + title + ", Genre: " + genre + ", Pages:" + pages + ", Price: "+ price+ ", Status: " + (isBorrowed? "Borrowed" : "Available") );

    }

    @Override
    public float CalcFine() {
        return pages *10;
        
    }
    
}
