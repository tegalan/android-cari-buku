package com.pringstudio.caribuku.buku;

import com.pringstudio.caribuku.buku.entity.BookResult;
import com.pringstudio.caribuku.buku.network.BukuApiService;
import com.pringstudio.caribuku.util.ServiceGenerator;

import retrofit2.Call;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:44
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class BukuModel implements BukuContract.Model {
    @Override
    public Call<BookResult> search(String keyword) {
        BukuApiService service = ServiceGenerator.getService().create(BukuApiService.class);

        Call<BookResult> bookResultCall = service.search(keyword);

        return bookResultCall;
    }
}
