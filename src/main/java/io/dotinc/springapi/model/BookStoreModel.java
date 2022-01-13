package io.dotinc.springapi.model;

import java.util.List;

public class BookStoreModel {
    private String id;
    private String name;
    private String address;
    private List<BookModel> bookModels;

    public BookStoreModel() {
    }

    public BookStoreModel(String id, String name, String address, List<BookModel> bookModels) {
        this.name = name;
        this.address = address;
        this.bookModels = bookModels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookModel> getBooks() {
        return bookModels;
    }

    public void setBooks(List<BookModel> bookModels) {
        this.bookModels = bookModels;
    }

    @Override
    public String toString() {
        return "BookStoreModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bookModels=" + bookModels +
                '}';
    }
}
