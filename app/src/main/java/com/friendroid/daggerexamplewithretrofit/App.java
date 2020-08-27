package com.friendroid.daggerexamplewithretrofit;

import android.app.Application;

import com.project.dajver.dagger2testexample.components.AppComponent;

/**
 * Created by gleb on 8/16/17.
 */

public class App extends Application {

    private static AppComponent appComponent;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        buildComponentGraph();
    }

    public static AppComponent component() {
        return appComponent;
    }

    public static void buildComponentGraph() {
        appComponent = AppComponent.Initializer.init(app);
    }
}