package BookLibrary;
import java.util.Scanner;
public abstract class Book implements IBookable{
    protected static final Scanner INPUT = new Scanner(System.in);
    String bookId;
    String title;
    String author;
    float price;
    boolean isBorrowed = false;

    @Override
    public void Input(){
        System.out.print("Input Book ID: ");
        bookId = INPUT.nextLine();
        System.out.print("Input title: ");
        title = INPUT.nextLine();
        System.out.print("Input price: ");
        price = INPUT.nextFloat();
        INPUT.nextLine();
    }

    @Override
    public void PrintInfo(){
        System.out.println("Code: " + bookId + ", Book name: " + title + ", Author: " + author + ", Price" + price + ", Status: " + (isBorrowed? "Borrowed" : "Available") + ", Fine/day: " + CalcFine());
    }

    //borrow book
    public void Borrow(){
        if(!isBorrowed){
            isBorrowed=true;
            System.out.println("Borrow sucessfully: " + title);
        }else{
            System.out.println("The book is being borrowed by another reader");
        }
    }

    //return book
    public void Return(){
        if(isBorrowed){
            isBorrowed =false;
            System.out.println("Return successfully: " + title);
        }else{
            System.out.println("Book is not borrowed");
        }
    }

    public abstract float CalcFine();

    @Override
    public String GetTitle(){
        return title;
    }
}
