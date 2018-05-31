package za.co.tamboer.sboottut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.tamboer.sboottut.streams.BookService;

@SpringBootApplication
public class SbootTutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootTutApplication.class, args);
		BookService bookService = new BookService();
		bookService.perform();
	}
}
