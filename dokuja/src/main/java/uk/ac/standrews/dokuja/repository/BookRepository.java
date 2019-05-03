package uk.ac.standrews.dokuja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.standrews.dokuja.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}