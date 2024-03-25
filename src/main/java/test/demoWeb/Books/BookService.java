package test.demoWeb.Books;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    Map<Long, Book> books = new ConcurrentHashMap<>();
    final AtomicLong counter = new AtomicLong();

    public Collection<Book> getBooks() {
        return books.values();
    }
    public Book getBookById(Long id) {
        return books.get(id);
    }

    public Book saveBook(Book book){
        Long id = book.getId() != null ? book.getId() : counter.incrementAndGet();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public  Book deleteBook(Long id){
       Book deletedBook =  books.remove(id);
        return deletedBook;
    }

    // New method to update an existing book
    public Book updateBook(Long id, Book bookDetails) {
        if (books.containsKey(id)) {
            Book existingBook = books.get(id);
            // Assuming Book class has setters for its fields
            // Update the necessary fields of the existing book
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            // Update other fields as necessary

            books.put(id, existingBook); // This step may be redundant if the map already contains a reference to the same object
            return existingBook;
        }
        // Optionally, throw an exception or return null if the book doesn't exist
        return null; // Or throw new RuntimeException("Book not found with id: " + id);
    }
}
