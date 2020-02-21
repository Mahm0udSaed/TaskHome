package com.example.mahmoudsaed.taskhome.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Module
public class ApplicationModule {
    private final Application app;
    public ApplicationModule(Application app) {
        this.app = app;
    }


    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return app;
    }
}
