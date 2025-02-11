package repetition.ex2;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("Gone with the wind","123456789", 1998));
        books.add(new Book("Lollipop","234567891", 1998));
        books.add(new Book("Tease","345678912", 1998));
    }

    public boolean doesBookExist(Book book){
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Library library=new Library();
        System.out.println(library.doesBookExist(new Book("", "123456789", 0)));
        System.out.println(library.doesBookExist(new Book("", "123", 0)));
    }
}
