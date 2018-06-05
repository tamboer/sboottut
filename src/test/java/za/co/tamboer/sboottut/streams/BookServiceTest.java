package za.co.tamboer.sboottut.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.tamboer.sboottut.config.StreamConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= StreamConfig.class)
public class BookServiceTest {

    @Autowired
    private Book book;

    @Autowired
    private BookService bookService;

    @Test
    public void bookShouldNotBeNull() {
        assertNotNull(book);
    }

    @Test
    public void getByAuthor() {

    List<Book> bookList = bookService.getByAuthor(
            Arrays.asList(
                    new Book("Title","Tom"),
                    new Book("Title1","Dick"),
                    new Book("Title2","Harry")
            ), "Harry");

    assert(bookList.get(0).getAuthor()).equals("Harry");

    }



    @Test
    public void didAuthorWriteIt() {
    }

    @Test
    public void stringStringMap() {
    }

    @Test
    public void stringBookMap() {
    }

    @Test
    public void booksbyAuthor() {

        Map<String, List<Book>> books = bookService.booksbyAuthor(
                Arrays.asList(
                        new Book("Tom's Book1","Tom"),
                        new Book("Tom's Book2","Tom"),
                        new Book("Tom's Book3","Tom"),
                        new Book("Tom's Book4","Tom"),
                        new Book("Tom's Book5","Tom"),
                        new Book("Dick's Title 1","Dick"),
                        new Book("Dick's Title 2","Dick"),
                        new Book("Dick's Title 3","Dick"),
                        new Book("Dick's Title 4","Dick"),
                        new Book("Dick's Title 5","Dick"),
                        new Book("Dick's Title 6","Dick"),
                        new Book("Title2","Harry")
                ));


        assertThat(books.size(), is(3));


    }
}

