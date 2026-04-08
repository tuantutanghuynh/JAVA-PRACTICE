package BookLibrary;

public class BookList {
    Book[] books;
    int count = 0;

    public BookList(){
        books = new Book[20];
    }

    public void AddTextBook(){
        TextBook b = new TextBook();
        b.Input();
        books[count]=b;
        count ++;
        System.out.println("Add textbook successfully");
    }

    public void AddNovel(){
        Novel b = new Novel();
        b.Input();
        books[count] = b;
        count ++;
        System.out.println("Add novel successfully");
    }

    public void Show(){
        if(count == 0){
            System.out.println("There is no book yet!");
        }
        System.out.println("Book list: ");
        for (int i= 0; i < count ; i++){
            books[i].PrintInfo();
        }
    }

    //find book by id
    public void FindById(String id){
        boolean found = false;
        for (int i = 0; i < count; i++){
            if(books[i].bookId.equals(id)){
                books[i].PrintInfo();
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Cannot find book with ID: " + id);
        }
    }

    //total value of all books
    public double TotalValue(){
        double total = 0;
        for (int i=0 ; i<count ; i++){
            total += books[i].price;
        }
        return total;
    }

    //Borrow book by id
    public void Borrow(String id){
        for(int i =0 ; i<count; i++){
            if(books[i].bookId.equals(id)){
                books[i].Borrow();
                return;
        }
    }
    System.out.println("Cannot find book");
}

    //return book by id
    public void Return(String id){
        for(int i = 0; i< count; i++){
            if(books[i].bookId.equals(id)){
                books[i].Return();
                return;
            }
        }
        System.out.println("Cannot find a returned book");
    }

    //Find Novel with the highest price
    public void findMostExpensiveNovel(){
        Novel max = null;
        for (int i = 0; i < count; i++){
            if(books[i] instanceof Novel){
                Novel nv = (Novel) books[i];
                if(max == null || nv.price > max.price){
                    max = nv;
                }
            }
        }
        if(max != null){
            System.out.println("Novel with the highest price: ");
            max.PrintInfo();
        } else {
            System.out.println("No novels found.");
        }
    }

    //Count the number of borrowed books
    public void CounBorrowed(){
        int borrowedCount = 0 ;
        for( int i = 0; i < count; i++){
            if(books[i].isBorrowed){
                borrowedCount ++;
            }
        }
        System.out.println("Borrow list: " + borrowedCount);
    }
}
