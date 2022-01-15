package io.dotinc.springapi.repository;

import io.dotinc.springapi.FakerUtil;
import io.dotinc.springapi.model.BookModel;
import io.dotinc.springapi.model.BookStoreModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookStoreRepository {
    //Consider the map of <id, book store> as the database
    private final static Map<String, BookStoreModel> bookStores = FakerUtil.initBookStores();

    public List<BookModel> findAllForStore(String storeId) {
        return bookStores.entrySet()
                .stream()
                .filter(b -> storeId.equals(b.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .map(BookStoreModel::getBooks)
                .orElse(new ArrayList<>());
    }

    // Get all book stores
    public List<BookStoreModel> getAllBookStores() {
        return bookStores.values().stream().toList();
    }
// Get a book store by id
    public BookStoreModel getBookStoreById(String storeId) {
        if (bookStores.containsKey(storeId)) {
            return bookStores.get(storeId);
        }else{
            throw new RuntimeException("The store with the id: " + storeId + "doesn't exist");
        }

    }

    // Add a new book store
    public void addBookStore(BookStoreModel store) {
        if (!bookStores.containsKey(store.getId())) {
            bookStores.put(store.getId(), store);
        } else {
            System.out.println("The store is already in the list");
        }
    }

    public BookModel findBookByStoreAndIsbn(String storeId, String isbn) {
        return findAllForStore(storeId)
                .stream()
                .filter(b -> isbn.equals(b.getIsbn()))
                .findFirst()
                .orElse(null);
    }

    public void addNewBookToStore(String storeId, BookModel book) {
        if (findBookByStoreAndIsbn(storeId, book.getIsbn()) == null) {
            BookStoreModel bookStore = getBookStoreById(storeId);
            if (bookStore != null) {
                bookStore.getBooks().add(book);
            } else {
                throw new RuntimeException("The store with the id: " + storeId + "doesn't exist");
            }

        }
    }
}


//        Book stores:
//        Get all book stores
//        Get a book store by id
//        Add a new book store
//        Books:
//        Get all books in a store
//        Get single book in a store by book isbn
//        Add a new book in a store