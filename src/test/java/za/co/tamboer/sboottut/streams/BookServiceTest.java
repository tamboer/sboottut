package za.co.tamboer.sboottut.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.tamboer.sboottut.config.StreamConfig;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;


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
}

