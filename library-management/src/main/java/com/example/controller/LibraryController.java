package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BorrowRequestDTO;
import com.example.model.Book;
import com.example.model.Borrower;
import com.example.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return libraryService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
    }

    @PostMapping("/borrow")
    public void borrowBook(@RequestBody BorrowRequestDTO request) {
        libraryService.borrowBook(request);
    }

    @PutMapping("/return/{recordId}")
    public void returnBook(@PathVariable Long recordId) {
        libraryService.returnBook(recordId);
    }
    // Endpoint to add a new borrower
    @PostMapping("/borrowers")
    public Borrower addBorrower(@RequestBody Borrower borrower) {
        return libraryService.addBorrower(borrower);
    }

    // Endpoint to get all borrowers
    @GetMapping("/borrowers")
    public List<Borrower> getAllBorrowers() {
        return libraryService.getAllBorrowers();
    }
}