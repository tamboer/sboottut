package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

//http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

@Service
public class BookService {


    public BookService() {
    }

    public void perform() {
        List<Book> myBookList = getBooks();
        String author = "Lyall Watson";

        lineSeparator("getByAuthor");
        System.out.println(getByAuthor(myBookList, author));

        lineSeparator("printBookByAuthor");
        printBookByAuthor(myBookList, author);

        lineSeparator("booksbyAuthor");
        System.out.println(booksbyAuthor(myBookList));

        lineSeparator("booksbyAuthor");
        System.out.println(booksbyAuthor(myBookList, author));

        lineSeparator("booksbyExcludeAuthor");
        System.out.println(booksbyExcludeAuthor(myBookList, author));

        lineSeparator("booksbyPrice");
        System.out.println(booksbyPrice(myBookList, 10.5));

        lineSeparator("booksAvgPrice");
        System.out.println(booksAvgPrice(myBookList));

        lineSeparator("bookPriceSum");
        System.out.println(bookPriceSum(myBookList));

        lineSeparator("booksPerAuthorPriceSum");
        System.out.println(booksPerAuthorPriceSum(myBookList,author));

        lineSeparator("allBbooksPerAuthorPriceSummary");
        System.out.println(allBbooksPerAuthorPriceSummary(myBookList));

        lineSeparator("allBbooksPerAuthorPriceSum");
        System.out.println(allBbooksPerAuthorPriceSum(myBookList));

        lineSeparator("didAuthorWriteIt" + "\n");
        didAuthorWriteIt(myBookList, author);

        lineSeparator("stringStringMap");
        stringStringMap(myBookList);

        lineSeparator("stringBookMap");
        stringBookMap(myBookList);
    }

    private void lineSeparator(String header) {
        System.out.println("--------------------------------------------");
        System.out.println(header);
    }

    public List<Book> getByAuthor(List<Book> bookList, String author) {
        return bookList.stream().filter(book -> book.byAuthor(author)).collect(Collectors.toList());
    }

    public Map<Book, Boolean> didAuthorWriteIt(List<Book> bookList, String author) {
        Map map = bookList.stream().collect(Collectors.toMap(Function.identity(), b -> b.byAuthor(author)));
        map.forEach((x, y) -> System.out.println("\t\t" + x + ": " + y));
        return map;
    }

    public Map<String, String> stringStringMap(List<Book> list) {
        Map<String, String> map = list.stream()
                //.collect(Collectors.toMap(Book::titleUpper, Book::getAuthor));
                .collect(Collectors.toMap(b -> b.getTitle().toUpperCase(), Book::getAuthor));
        map.forEach((x, y) -> System.out.println("Title: " + x + ", Author: " + y));

        return map;
    }

    public Map<String, Book> stringBookMap(List<Book> list) {
        Map<String, Book> map = list.stream()
                .collect(Collectors.toMap(Book::getTitle, b -> b));
        map.forEach((x, y) -> System.out.println("\t\tTitle: " + x + ", " + y));

        return map;
    }

    public Map<String, List<Book>> booksbyAuthor(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> booksbyAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> booksbyExcludeAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(book -> !author.equals(book.getAuthor()))
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> booksbyPrice(List<Book> books, Double price) {
        return books.stream()
                .filter(book -> book.getPrice().doubleValue() == price)
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public OptionalDouble booksAvgPrice(List<Book> books) {
        return books.stream()
                .mapToDouble(book -> book.getPrice())
                .average();
    }

    public double bookPriceSum(List<Book> books) {
        return books.stream()
                .mapToDouble(book -> book.getPrice())
                .sum();
    }

    public double booksPerAuthorPriceSum(List<Book> books, String author) {
        return books.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .mapToDouble(book -> book.getPrice())
                .sum();
    }

    public Map<String, DoubleSummaryStatistics> allBbooksPerAuthorPriceSummary(List<Book> books) {
        return books.stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getAuthor, Collectors.summarizingDouble(Book::getPrice)
                        ));
    }
    public Map<String, Double> allBbooksPerAuthorPriceSum(List<Book> books) {
        return books.stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getAuthor, Collectors.summingDouble(Book::getPrice)
                        ));
    }


    private void printBookByAuthor(List<Book> bookList, String author) {
        bookList.stream()
                .filter(b -> b.byAuthor(author))
                .map(b -> b.toString().toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }

    private List<Book> getBooks() {
        return Arrays.asList(
                new Book("Spring in action", "Craig Walls", 10.5),
                new Book("Java 8 in action", "Uma", 20.5),
                new Book("Elephantoms", "Lyall Watson", 50.5),
                new Book("Elephantoms Hardcover", "Lyall Watson", 99.5),
                new Book("JavaSpring101", "Craig Walls", 30.5),
                new Book("Scrum101", "Bob Jones", 15.5),
                new Book("Java8", "Uma", 5.5)
        );
    }
}
