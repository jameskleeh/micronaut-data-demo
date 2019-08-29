package micronaut.data.demo;

import io.micronaut.test.annotation.MicronautTest;
import micronaut.data.demo.book.Book;
import micronaut.data.demo.book.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.inject.Inject;

@MicronautTest(application = Application.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookTest {

    @Inject
    BookRepository bookRepository;

    @BeforeAll
    void createBooks() {
        bookRepository.save("IT", 500);
        bookRepository.save("Harry Potter", 325);
    }

    @Test
    void testFindingABook() {
        Book book = bookRepository.findByTitle("Harry Potter");

        Assertions.assertEquals(325, book.getPages());
    }
}
