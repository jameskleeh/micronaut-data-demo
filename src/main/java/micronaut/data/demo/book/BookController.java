package micronaut.data.demo.book;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/book")
public class BookController {

    private final BookRepository bookRepository;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get("/{id}")
    Book getBook(Long id) {
        return bookRepository.get(id);
    }

    @Post("/")
    Book save(String title, int pages) {
        return bookRepository.save(title, pages);
    }

    @Get("/")
    List<Book> list() {
        return bookRepository.list();
    }
}
