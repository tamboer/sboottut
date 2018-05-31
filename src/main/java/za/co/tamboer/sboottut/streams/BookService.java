package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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



}
