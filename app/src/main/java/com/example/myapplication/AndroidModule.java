package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    private final Context applicationContext;

    public AndroidModule(Application application) {
        this.applicationContext = application.getBaseContext();
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return applicationContext;
    }
}
