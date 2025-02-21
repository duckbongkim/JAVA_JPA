package com.example.backend.repository.book;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BookMySqlRepository implements BookRepository {

    @Override
    public void save(String bookName){
        System.out.println("MySql Repository"+bookName);
    }
}
