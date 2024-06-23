package repository;

import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer > {
    List<Book> findByTitle(String title);
}
