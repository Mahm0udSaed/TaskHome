package com.example.mahmoudsaed.taskhome.di.components;

import com.example.mahmoudsaed.taskhome.di.modules.ApplicationModule;
import com.example.mahmoudsaed.taskhome.di.modules.DataServiceModule;
import com.example.mahmoudsaed.taskhome.di.modules.NetworkServiceModule;
import com.example.mahmoudsaed.taskhome.di.modules.ViewModelModule;
import com.example.mahmoudsaed.taskhome.ui.activity.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Singleton
@Component(modules = {ApplicationModule.class ,  NetworkServiceModule.class, DataServiceModule.class, ViewModelModule.class})
public interface ApplicationComponent {
 void inject(HomeActivity homeActivity);
}
