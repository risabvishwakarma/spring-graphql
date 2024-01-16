package com.unitral.graphql.controler;

import com.unitral.graphql.models.Book;
import com.unitral.graphql.service.Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphController {
    private final Service bookService;

    @Autowired
    public GraphController(Service bookService) {
        this.bookService = bookService;
    }

    @MutationMapping("createBook")
    public Book addBook(@Argument BookInput book){
        if(book==null){
            return null;
        }
        Book book1=new Book();
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setStandard(book.getStandard());


        return bookService.insertBook(book1);
    }

    @QueryMapping("getBooks")
    public List<Book> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK).getBody();
    }

    @QueryMapping("getBook")
    public Book getBook(@Argument int bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK).getBody();
    }
}

@Getter
@Setter
class BookInput{
    private String name;
    private String author;
    private float price;
    private String standard;

}
