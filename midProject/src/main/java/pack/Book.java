package pack;

import java.io.UnsupportedEncodingException;

public class Book {

    String title;
    Integer price;
    String publisher;
    JSONArray authors;
    Integer discountPrice;
    String ISBN;
    public Book(String title, Integer price, String publisher, Integer discountPrice, JSONArray authors, String ISBN) throws UnsupportedEncodingException {
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
        this.discountPrice = discountPrice;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return this.title + " | " + this.price + " | " + this.publisher + " | " + this.authors.get(0) + " | " + this.discountPrice + " | " + this.ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public JSONArray getAuthors() {
        return authors;
    }

    public void setAuthors(JSONArray authors) {
        this.authors = authors;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

