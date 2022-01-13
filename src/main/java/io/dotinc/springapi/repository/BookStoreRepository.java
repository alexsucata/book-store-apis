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
}
