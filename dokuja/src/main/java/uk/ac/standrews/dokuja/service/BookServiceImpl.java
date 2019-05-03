package uk.ac.standrews.dokuja.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import uk.ac.standrews.dokuja.domain.Book;
import uk.ac.standrews.dokuja.repository.BookRepository;
import uk.ac.standrews.dokuja.service.exception.BookAlreadyExistsException;

@Service
@Validated
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(final BookRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        LOGGER.debug("Creating {}", book);
        Book existing = repository.findOne(book.getId());
        if(existing != null){
            throw new BookAlreadyExistsException(String.format("There already exists a book with id=%s", book.getId()));
        }
        return repository.save(book);
    }

    @Override
    public List<Book> getList() {
        LOGGER.debug("Retrieving the list of all the books");
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBook(Long bookId) {
       return repository.findOne(bookId);
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        LOGGER.debug("deleting {}", bookId);
        repository.delete(bookId);
    }

}