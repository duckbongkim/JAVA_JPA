package com.example.backend.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
 // 우선권을 가짐
public class BookMemoryRepository implements BookRepository{
    private final List<String> books = new ArrayList<>();

    @Override
    public void save(String bookName){
//        books.add(bookName);
        System.out.println(bookName);
    }

}
