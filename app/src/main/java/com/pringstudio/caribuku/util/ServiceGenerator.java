package com.pringstudio.caribuku.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:55
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class ServiceGenerator {

    public static Retrofit getService(){
        return new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
