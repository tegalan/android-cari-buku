package com.pringstudio.caribuku.buku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:53
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class BookResult {
    @SerializedName("items")
    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
