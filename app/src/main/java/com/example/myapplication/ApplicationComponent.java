package com.example.myapplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AndroidModule.class
})
public interface ApplicationComponent {
    void inject(GlideConfiguration glideConfiguration);
    void inject(MyApp superbApp);
}
