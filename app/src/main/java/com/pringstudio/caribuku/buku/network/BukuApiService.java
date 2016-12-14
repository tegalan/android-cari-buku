package com.pringstudio.caribuku.buku.network;

import com.pringstudio.caribuku.buku.entity.BookResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:50
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public interface BukuApiService {
    @GET("v1/volumes")
    Call<BookResult> search(@Query("q") String keyword);
}
