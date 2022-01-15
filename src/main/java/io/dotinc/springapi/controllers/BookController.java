package io.dotinc.springapi.controllers;


import io.dotinc.springapi.model.BookModel;
import io.dotinc.springapi.model.BookStoreModel;
import io.dotinc.springapi.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {


    @Autowired
    public BookStoreRepository bookStoreRepository;

    public BookController(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @GetMapping("/books-in-a-store/{id}")
    public List<BookModel> getAllBooksInAStoreByStoreId(@PathVariable String id) {
        return bookStoreRepository.findAllForStore(id);
    }

    @GetMapping("/book-by-store-and-isbn/{id}/{isbn}")
    public BookModel getBookByStoreAndIsbn(@PathVariable String id, @PathVariable String isbn) {
        return bookStoreRepository.findBookByStoreAndIsbn(id, isbn);
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> addNewBookInAStore(@Valid @RequestBody BookStoreModel store, @RequestBody BookModel book, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("; "));
//            return ResponseEntity.status(412).body(errors);
//        } else {
//            bookStoreRepository.addNewBookToStore(store.getId(), book);
//            return ResponseEntity.ok().body("succes");
//        }
//
//    }
}
