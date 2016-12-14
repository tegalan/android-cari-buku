package com.pringstudio.caribuku.buku;

import com.pringstudio.caribuku.buku.entity.BookResult;

import javax.inject.Inject;

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
    BukuContract.View view;

    @Inject
    public BukuPresenter(BukuContract.Model model) {
        this.model = model;
    }

    @Override
    public void bind(BukuContract.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public void performSearch(String keyword) {

        if(view != null)
            view.showLoading();

        model.search(keyword)
                .enqueue(new Callback<BookResult>() {
                    @Override
                    public void onResponse(Call<BookResult> call, Response<BookResult> response) {
                        if (view != null) {
                            if (response.isSuccessful() && response.body() != null) {

                                view.updateBookList(response.body().getBooks());
                            }else{
                                view.showToast("Pencarian tidak ditemukan");
                            }

                            view.hideLoading();
                        }


                    }

                    @Override
                    public void onFailure(Call<BookResult> call, Throwable t) {
                        t.printStackTrace();
                        if(view != null){
                            view.hideLoading();
                        }
                    }
                });
    }
}
