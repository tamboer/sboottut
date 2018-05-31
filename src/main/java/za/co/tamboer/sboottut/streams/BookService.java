package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

@Service
public class BookService {


    public BookService() {

        getByAuthor();

    }

    public void getByAuthor(){
        System.out.println("Get books by author");

        List<Book> myBookList =
                Arrays.asList(
                        new Book("Spring in action", "Craig Walls"),
                        new Book("Java 8 in action", "Uma"),
                        new Book("Elephantoms", "Lyall Watson")
                );

        myBookList
                .stream()
                .filter(b -> b.byAuthor("Lyall Watson"))
                //.map(Book::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public Map <String, List<Book>> booksByAuthor(String authorName, List<Book> books){
        Map <String, List<Book>> booksPerAuthor;

        Map <String, List<Book>> booksPerAuthor = books.stream().map(book -> book.byAuthor("Lyall Watson")).collect(Collectors.toMap(authorName,book -> book.byAuthor("Lyall Watson")));
        Map <String, List<Book>> booksPerAuthor = books.stream().map(book -> book.byAuthor("Lyall Watson")).collect(Collectors.toMap(authorName,book -> book.byAuthor("Lyall Watson")));

        List<Book> booksFromWillem = booksPerAuthor.get("Lyall Watson");
    }



}
