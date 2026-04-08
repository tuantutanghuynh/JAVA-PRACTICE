package BookLibrary;

public class Novel extends Book {
    String genre;
    int pages;

    @Override
    public void Input(){
        super.Input();
        System.out.print("Input Genre: ");
        genre = INPUT.nextLine();
        System.out.print("Input Number of Pages: ");
        pages = INPUT.nextInt();
        INPUT.nextLine();
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
