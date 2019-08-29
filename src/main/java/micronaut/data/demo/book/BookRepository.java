package micronaut.data.demo.book;

import io.micronaut.data.jdbc.annotation.JdbcRepository;

import java.util.List;

@JdbcRepository
public interface BookRepository {

    Book save(String title, int pages);

    Book findByTitle(String title);

    Book get(Long id);

    List<Book> list();
}
