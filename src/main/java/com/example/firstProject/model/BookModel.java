package com.example.firstProject.model;

import lombok.Data;

@Data
public class BookModel {
    private int accId;
    private String title;
    private String author;
    private int price;

    BookModel(int accId, String title, String author, int price) {
        this.accId = accId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
