package io.dotinc.springapi.controllers;

import io.dotinc.springapi.FakerUtil;
import io.dotinc.springapi.model.BookStoreModel;
import io.dotinc.springapi.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class BookStoreController {

    @Autowired
    public BookStoreRepository bookStoreRepository;


    @GetMapping("/bookstores")
    public List<BookStoreModel> getAllBookStores() {
        return bookStoreRepository.getAllBookStores().stream().toList();
    }

    @GetMapping("/bookstores/{id}")
    public BookStoreModel getBookStoreById(@PathVariable String id) {
        return bookStoreRepository.getBookStoreById(id);
    }

    @PostMapping("/bookstores/add")
    public ResponseEntity<String> addNewBookStore(@Valid @RequestBody BookStoreModel store, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("; "));
            return ResponseEntity.status(412).body(errors);
        } else {
            bookStoreRepository.addBookStore(store);
            return ResponseEntity.ok().body("succes");
        }

    }
}
