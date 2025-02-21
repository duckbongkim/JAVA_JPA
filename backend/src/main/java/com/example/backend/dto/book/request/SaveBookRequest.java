package com.example.backend.dto.book.request;

public class SaveBookRequest {
    private String book;

    public SaveBookRequest(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }
}
