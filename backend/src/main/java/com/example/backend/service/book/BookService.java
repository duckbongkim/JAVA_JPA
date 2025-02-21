package com.example.backend.service.book;

import com.example.backend.dto.book.request.SaveBookRequest;
import com.example.backend.repository.book.BookMemoryRepository;
import com.example.backend.repository.book.BookMySqlRepository;
import com.example.backend.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
//    private final BookMemoryRepository bookMemoryRepository = new BookMemoryRepository();

//    private final BookMySqlRepository bookMySqlRepository = new BookMySqlRepository();

//    private final BookRepository bookRepository = new BookRepository();

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(SaveBookRequest request){
//        bookMemoryRepository.save(request.getBook());
        bookRepository.save(request.getBook());
    }




}
