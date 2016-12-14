package com.pringstudio.caribuku;

import android.app.Application;

/**
 * Author       : sucipto
 * Created date : 12/14/16 21:42
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
