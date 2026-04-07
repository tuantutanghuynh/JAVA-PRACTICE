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

}
