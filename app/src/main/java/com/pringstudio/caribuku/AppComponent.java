package com.pringstudio.caribuku;

import com.pringstudio.caribuku.buku.BukuActivity;
import com.pringstudio.caribuku.buku.module.BukuModule;

import dagger.Component;

/**
 * Author       : sucipto
 * Created date : 12/14/16 22:30
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

@Component(dependencies = {BukuModule.class})
public interface AppComponent {
    void inject(BukuActivity activity);
}
