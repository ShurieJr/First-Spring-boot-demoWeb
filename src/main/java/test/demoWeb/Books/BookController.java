package test.demoWeb.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id ) {
        Book book =  bookService.getBookById(id);
        if(book == null)
            return new ResponseEntity<>("Book With id " + id + " not found"  , HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PostMapping("/")
    public ResponseEntity<Book> savebook(@RequestBody Book book) {
       Book savedbook =  bookService.saveBook(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedbook);
      //return ResponseEntity.ok(savedbook);
    }

@DeleteMapping("/{id}")
    public ResponseEntity<Book> deletebook(@PathVariable Long id) {
        Book deletedbook = bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedbook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updatebook(@PathVariable Long id , @RequestBody Book book) {
        Book updatedbook = bookService.updateBook(id , book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedbook);
    }


}
