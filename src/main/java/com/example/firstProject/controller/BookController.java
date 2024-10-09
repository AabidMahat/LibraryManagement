package com.example.firstProject.controller;

import com.example.firstProject.model.BookModel;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
   static public List<BookModel> books = new ArrayList<>();

    @PostMapping("/addBook")
    public Map<String, String> createBooks(@RequestBody BookModel book) {
        Map<String, String> output = new HashMap<>();
        books.add(book);
        output.put("message","Book Added Successfully");
        return output;
    };

    @GetMapping
    public List<BookModel> getBooks() {
        return books;
    }

    @PatchMapping("/updateBook")
    public Map<String, String> updateBook(@RequestBody BookModel updatedBook) {

        books.forEach(book->{
           if(book.getAccId()==updatedBook.getAccId()) {
               book.setAccId(updatedBook.getAccId());
           }
        });
        Map<String, String> output = new HashMap<>();
        output.put("message","Book Updated Successfully");
        return output;
    }

    @DeleteMapping("/removeBook")
    public Map<String, String> removeBook(@RequestBody BookModel book) {
        books.remove(book);
        Map<String, String> output = new HashMap<>();
        output.put("message","Book Removed Successfully");
        return output;

    }
}
