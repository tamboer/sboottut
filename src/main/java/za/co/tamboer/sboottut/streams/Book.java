package za.co.tamboer.sboottut.streams;

import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class Book {

    private String title;
    private String author;
    private Double price;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    //@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private OffsetDateTime updated;


    public Book(String title, String author, Double price, OffsetDateTime updated) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.updated = updated;

    }

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;

    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OffsetDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(OffsetDateTime updated) {
        this.updated = updated;
    }

    public boolean byAuthor(String author) {
        return author.equals(this.author);
    }

    public String titleUpper(){
        return getTitle().toUpperCase();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
