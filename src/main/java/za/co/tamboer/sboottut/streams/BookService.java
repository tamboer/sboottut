package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        getByAuthor(myBookList, author);
        printBookByAuthor(myBookList, author);

        listToMap();
    }

    public List<Book> getByAuthor(List<Book> bookList, String author){
        System.out.println("Get books by author " + author);

        return bookList.stream().filter(book -> book.byAuthor(author)).collect(Collectors.toList());
    }

    private void printBookByAuthor(List<Book> bookList, String author) {
        System.out.println("Print books by author " + author);

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
                new Book("Elephantoms", "Lyall Watson")
        );
    }

    public void listToMap(){

        List<String> list = new ArrayList<>();
        list.add("Mohan");
        list.add("Sohan");
        list.add("Mahesh");
        Map<String, Object> map = list.stream().collect(Collectors.toMap(Function.identity(), s->s));

        map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));

    }



}
