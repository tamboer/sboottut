package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

@Service
public class BookService {


    public BookService() {
    }

    public void perform(){
        List<Book> myBookList = getBooks();
        String author = "Lyall Watson";

        System.out.println("============================================");
        System.out.println("Get books by author " + author + "\n");
        getByAuthor(myBookList, author);

        System.out.println("--------------------------------------------");
        printBookByAuthor(myBookList, author);

        System.out.println("--------------------------------------------");
        System.out.println("Books by Author");
        System.out.println(booksbyAuthor(myBookList));

        System.out.println("--------------------------------------------");
        System.out.println("Books by this Author");
        System.out.println(booksbyAuthor(myBookList, author));

        System.out.println("--------------------------------------------");
        System.out.println("Books by exclude this Author");
        System.out.println(booksbyExcludeAuthor(myBookList, author));



        System.out.println("--------------------------------------------");
        System.out.println("Did Author Write It"  + "\n");
        didAuthorWriteIt(myBookList, author);

        System.out.println("--------------------------------------------");
        stringStringMap(myBookList);

        System.out.println("--------------------------------------------");
        stringBookMap(myBookList);
        System.out.println("============================================");
    }

    public List<Book> getByAuthor(List<Book> bookList, String author){
        return bookList.stream().filter(book -> book.byAuthor(author)).collect(Collectors.toList());
    }

    public Map<Book, Boolean> didAuthorWriteIt(List<Book> bookList, String author){
        Map map = bookList.stream().collect(Collectors.toMap(Function.identity(),b -> b.byAuthor(author)));
        map.forEach((x, y) -> System.out.println("\t\t" + x +": " + y));
        return map;
    }

    public Map<String, String> stringStringMap(List<Book> list) {
        Map<String, String> map = list.stream()
                //.collect(Collectors.toMap(Book::titleUpper, Book::getAuthor));
                .collect(Collectors.toMap(b -> b.getTitle().toUpperCase(), Book::getAuthor));
        map.forEach((x, y) -> System.out.println("Title: " + x +", Author: "+ y));

        return map;
    }

    public Map<String, Book> stringBookMap(List<Book> list) {
        Map<String, Book> map = list.stream()
                .collect(Collectors.toMap(Book::getTitle, b -> b));
        map.forEach((x, y) -> System.out.println("\t\tTitle: " + x +", "+ y));

        return map;
    }

    public Map<String, List<Book>> booksbyAuthor(List<Book> books){
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> booksbyAuthor(List<Book> books, String author){
        return books.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> booksbyExcludeAuthor(List<Book> books, String author){
        return books.stream()
                .filter(book -> !author.equals(book.getAuthor()))
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    private void printBookByAuthor(List<Book> bookList, String author) {
        System.out.println("Print books by author " + author + "\n");

        bookList.stream()
                .filter(b -> b.byAuthor(author))
                .map(b -> b.toString().toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }

    private List<Book> getBooks() {
        return Arrays.asList(
                new Book("Spring in action", "Craig Walls"),
                new Book("Java 8 in action", "Uma"),
                new Book("Elephantoms", "Lyall Watson"),
                new Book("JavaSpring101", "Craig Walls"),
                new Book("Scrum101", "Bob Jones"),
                new Book("Java8", "Uma")
        );
    }
}
