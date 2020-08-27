package com.friendroid.daggerexamplewithretrofit.modules;

import android.app.Application;

import com.friendroid.daggerexamplewithretrofit.App;
import com.friendroid.daggerexamplewithretrofit.api.model.imp.FetchedDataPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gleb on 8/16/17.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    protected FetchedDataPresenterImpl provideFetchedData() {
        return new FetchedDataPresenterImpl();
    }
}