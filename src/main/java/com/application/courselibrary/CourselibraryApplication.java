package com.application.courselibrary;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) -> {
			Book book1 = new Book("ABC", "Bookname", "MyFirstBook");
			Author author1 = new Author("Authorname", "Test Description");
			Category category1 = new Category("Categoryname");
			Publisher publisher1 = new Publisher("Publishername");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("DEF", "Bookname2", "MySecondBook");
			Author author2 = new Author("Authorname2", "Test Description2");
			Category category2 = new Category("Categoryname2");
			Publisher publisher2 = new Publisher("Publishername2");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);
		};
	}
}
