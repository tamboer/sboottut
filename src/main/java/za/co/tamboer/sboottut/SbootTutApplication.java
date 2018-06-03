package za.co.tamboer.sboottut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.tamboer.sboottut.apple.Apple;
import za.co.tamboer.sboottut.apple.AppleService;
import za.co.tamboer.sboottut.apple.AppleServiceImpl;
import za.co.tamboer.sboottut.apple.HeavyApplesPredicate;
import za.co.tamboer.sboottut.apple.RedApplesPredicate;
import za.co.tamboer.sboottut.streams.BookService;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SbootTutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootTutApplication.class, args);
		BookService bookService = new BookService();
		bookService.perform();
		appleMain();
	}

	public static void appleMain() {

		Apple redApple = new Apple("red");
		Apple greenApple = new Apple("green");
		greenApple.setWeight(151.0f);
		Apple yellowApple = new Apple("yellow");
		Apple toffeeApple = new Apple("brown");


		AppleService appleService = new AppleServiceImpl();

		appleService.addToInventory(Arrays.asList(redApple,greenApple));


		List<Apple> filter = appleService.getInventory().filterApples("red");
		List<Apple> redApples = appleService.getInventory().filterApples(new RedApplesPredicate());
		List<Apple> heavyApples = appleService.getInventory().filterApples(new HeavyApplesPredicate());


		System.out.println(appleService.getInventory().getApples());
		System.out.println("filter" +  filter);
		System.out.println("red" + redApples);
		System.out.println("heavy" + heavyApples);
	}
}
