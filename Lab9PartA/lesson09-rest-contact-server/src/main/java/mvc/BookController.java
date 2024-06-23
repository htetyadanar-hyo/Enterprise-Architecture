package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {
        private final Map<String, Book> books = new HashMap<>();

        public BookController(){
            books.put("1", new Book("1","Jane","HarryPotter",100.23));
        }

        @GetMapping("/books/{isbn}")
        public ResponseEntity<?> getBook(@PathVariable String isbn){
            Book book = books.get(isbn);
            if(book == null){
                return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn = " + isbn + "is not available"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }

        @PostMapping("/books")
        public ResponseEntity<?> addBook(@RequestBody Book book){
            books.put(book.getIsbn(), book);
            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }

        @DeleteMapping("/books/{isbn}")
        public ResponseEntity<?> deleteBook(@PathVariable String isbn){
            Book book = books.get(isbn);
            if(book == null){
                return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn=" +
                        isbn + "is not availabe"),HttpStatus.NOT_FOUND);
            }
            books.remove(isbn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PutMapping("/books/{isbn}")
        public ResponseEntity<?> updateBook(@PathVariable String isbn,@RequestBody Book book){
            books.put(isbn,book);
            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }

        @GetMapping("/books")
        public ResponseEntity<?> getAllBooks(){
            Books allbooks = new Books(books.values());
            return new ResponseEntity<Books>(allbooks,HttpStatus.OK);
        }
}
