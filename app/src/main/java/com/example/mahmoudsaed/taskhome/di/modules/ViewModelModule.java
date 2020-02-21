package com.example.mahmoudsaed.taskhome.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.mahmoudsaed.taskhome.ui.activity.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);
}
