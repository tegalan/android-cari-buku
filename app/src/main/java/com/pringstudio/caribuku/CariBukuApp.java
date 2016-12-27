package com.pringstudio.caribuku;

import android.app.Application;

import com.pringstudio.caribuku.util.AppComponent;
import com.pringstudio.caribuku.util.DaggerAppComponent;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:42
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class CariBukuApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
