package com.example.firstProject.controller;

import com.example.firstProject.model.BookModel;
import com.example.firstProject.model.LibrarianModel;
import com.example.firstProject.model.StudentModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    List<LibrarianModel> librarianList = new ArrayList<>();
    List<BookModel> issuedBookList = new ArrayList<>();

    @PostMapping("/create")
    public Map<String,String> createLibrarian(@RequestBody LibrarianModel librarian) {
        librarianList.add(librarian);
        Map<String, String> output = new HashMap<>();
        output.put("message","Librarian Created Successfully");
        return output;
    }

    @PostMapping("/assignBook")
    public Map<String,String> assignBook(@RequestBody LibrarianModel librarian) {
        Map<String, String> output = new HashMap<>();
        boolean bookPresent = false;
        boolean studentPresent = false;

        for (BookModel book : BookController.books){
            if(book.getAccId()==librarian.getBookAccId()){
                bookPresent = true;
                issuedBookList.add(book);
                break;
            }

        }
        for (StudentModel student:FirstController.students){
            if(student.getPrn()==librarian.getStudentPrn()){
                studentPresent = true;
                break;
            }
        }

        if (bookPresent && studentPresent){
            output.put("message","Book Issued Successfully");
            return output;
        }
        else {
            output.put("message","Either Student or Book is not present");
            return output;
        }

    };
    @PostMapping("/collectBook")
    public Map<String,String> collectBook( @RequestBody  LibrarianModel librarian) {
        BookModel presentBook = null;
        Map<String, String> output = new HashMap<>();
        boolean bookPresent = false;

        for(BookModel book : issuedBookList){
            if(book.getAccId()==librarian.getBookAccId()){
                presentBook = book;
                bookPresent = true;
                break;
            }
        }

        if(bookPresent){
            issuedBookList.remove(presentBook);
            output.put("message","Book Collected Successfully");
            return output;
        }
        else {
            output.put("message","Book is not present");
            return output;
        }
    }


}
