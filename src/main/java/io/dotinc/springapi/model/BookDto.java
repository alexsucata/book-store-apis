package io.dotinc.springapi.model;

public class BookDto {

    private String isbn;
    private String name;
    private String author;
    private String price;
    private Integer pages;

    private String storeId;

    public BookDto(String isbn, String name, String author, String price, Integer pages, String storeId) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.storeId = storeId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", pages=" + pages +
                ", storeId=" + storeId +
                '}';
    }
}
