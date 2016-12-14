package com.pringstudio.caribuku.buku;

import com.pringstudio.caribuku.buku.entity.BookResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:44
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class BukuPresenter implements BukuContract.Presenter {

    BukuContract.Model model;

    @Override
    public void performSearch(String keyword) {
        model.search(keyword)
                .enqueue(new Callback<BookResult>() {
                    @Override
                    public void onResponse(Call<BookResult> call, Response<BookResult> response) {

                    }

                    @Override
                    public void onFailure(Call<BookResult> call, Throwable t) {

                    }
                });
    }
}
