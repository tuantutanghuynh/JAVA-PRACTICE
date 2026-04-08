package BookLibrary;

public class TextBook extends Book {
    String subject;
    int edition;

    @Override
    public void Input(){
        super.Input();
        System.out.print("Input Subject: ");
        subject = INPUT.nextLine();
        System.out.print("Input Edition: ");
        edition = INPUT.nextInt();
        INPUT.nextLine();
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
