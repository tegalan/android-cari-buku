package com.pringstudio.caribuku.buku.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:53
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class Book {
    @SerializedName("volumeInfo")
    BookDetail bookDetail;

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }
}
