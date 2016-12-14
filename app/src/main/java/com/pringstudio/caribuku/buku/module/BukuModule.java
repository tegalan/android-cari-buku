package com.pringstudio.caribuku.buku.module;

import com.pringstudio.caribuku.buku.BukuContract;
import com.pringstudio.caribuku.buku.BukuModel;

import dagger.Module;
import dagger.Provides;

/**
 * Author       : sucipto
 * Created date : 12/14/16 22:40
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

@Module
public class BukuModule {
    @Provides
    public BukuContract.Model providesBukuModel(){
        return new BukuModel();
    }
}
