package com.example.firstProject.model;

import lombok.Data;

@Data
public class LibrarianModel {
    String name;
    int bookAccId;
    int studentPrn;

    LibrarianModel(String name, int bookAccId, int studentPrn) {
        this.name = name;
        this.bookAccId = bookAccId;
        this.studentPrn = studentPrn;
    }
}
