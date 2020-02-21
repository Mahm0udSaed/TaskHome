package com.example.mahmoudsaed.taskhome;

import android.app.Application;

import com.example.mahmoudsaed.taskhome.di.components.ApplicationComponent;
import com.example.mahmoudsaed.taskhome.di.components.DaggerApplicationComponent;
import com.example.mahmoudsaed.taskhome.di.modules.ApplicationModule;

import javax.inject.Singleton;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */

public class TaskHomeApp extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    @Singleton
    public ApplicationComponent getmApplicationComponent() {
        return mApplicationComponent;
    }
}
