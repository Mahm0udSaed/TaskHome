package com.example.mahmoudsaed.taskhome.di.modules;

import com.example.mahmoudsaed.taskhome.data.utils.ConstantUtils;
import com.example.mahmoudsaed.taskhome.data.utils.MainThreadExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Module
public class NetworkServiceModule {
    @Provides
    @Singleton
    Retrofit provideHomeRequest() {
        return new Retrofit.Builder()
                .baseUrl(ConstantUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }
}
