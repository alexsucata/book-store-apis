package io.dotinc.springapi.model;

public class BookModel {
    private String isbn;
    private String name;
    private String author;
    private String price;
    private Integer pages;

    public BookModel() {
    }

    public BookModel(String isbn, String name, String author, String price, Integer pages) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", pages=" + pages +
                '}';
    }
}
