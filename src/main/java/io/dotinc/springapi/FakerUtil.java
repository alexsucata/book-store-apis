package io.dotinc.springapi;

import com.github.javafaker.Faker;
import io.dotinc.springapi.model.BookModel;
import io.dotinc.springapi.model.BookStoreModel;

import java.util.*;

public abstract class FakerUtil {

    private static List<BookModel> initBooks() {
        List<BookModel> books = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 100; i ++) {
            BookModel bookModel = new BookModel();
            bookModel.setIsbn(UUID.randomUUID().toString());
            bookModel.setAuthor(faker.book().author());
            bookModel.setName(faker.book().title());
            bookModel.setPages(faker.random().nextInt(100, 400));
            bookModel.setPrice(faker.commerce().price());
            books.add(bookModel);
        }

        return books;
    }

    public static Map<String, BookStoreModel> initBookStores() {
        Map<String, BookStoreModel> bookStores = new HashMap<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i ++) {
            BookStoreModel bookStore = new BookStoreModel();
            bookStore.setId("111" + i);
            bookStore.setName(faker.company().name());
            bookStore.setAddress(faker.address().fullAddress());
            bookStore.setBooks(initBooks());
            bookStores.put(bookStore.getId(), bookStore);
        }

        return bookStores;
    }

}
