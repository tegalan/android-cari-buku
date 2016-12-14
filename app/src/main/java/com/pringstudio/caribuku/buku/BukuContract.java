package com.pringstudio.caribuku.buku;

import com.pringstudio.caribuku.buku.entity.Book;
import com.pringstudio.caribuku.buku.entity.BookResult;

import java.util.List;

import retrofit2.Call;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:41
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public interface BukuContract {
    interface Model {
        Call<BookResult> search(String keyword);
    }
    interface View {
        void updateBookList(List<Book> books);
    }
    interface Presenter {
        void bind(View view);
        void unbind();
        void performSearch(String keyword);
    }
}
