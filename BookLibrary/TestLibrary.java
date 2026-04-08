package BookLibrary;

import java.util.Scanner;

public class TestLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookList list = new BookList();
        String option;

        while(true){
            System.out.println("\n==============================");
            System.out.println("      LIBRARY MANAGEMENT");
            System.out.println("==============================");
            System.out.println("1. Add textbook");
            System.out.println("2. Add novel");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Show book list");
            System.out.println("6. Find by book ID");
            System.out.println("7. Total library value");
            System.out.println("8. Most expensive novel");
            System.out.println("9. Count borrowed books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextLine();

            switch(option){
                case "1":
                    list.AddTextBook();
                    break;
                case "2":
                    list.AddNovel();
                    break;
                case "3":
                    System.out.print("Input Book Id: ");
                    String idBorrow =sc.nextLine();
                    list.Borrow(idBorrow);
                    break;
                case "4":
                    System.out.print("Input Book Id");
                    String idReturn = sc.nextLine();
                    list.Return(idReturn);
                    break;
                case "5":
                    list.Show();
                    break;
                case "6":
                    System.out.print("Input book Id: ");
                    String idFind = sc.nextLine();
                    list.FindById(idFind);
                    break;
                case "7":
                    System.out.println("Total value: " +  list.TotalValue() );
                    break;
                case "8":
                    list.findMostExpensiveNovel();
                    break;
                case "9":
                    list.CounBorrowed();
                    break;
                case "0":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("WRONG OPTION, input again");

                   
            }

        }
    }
}
