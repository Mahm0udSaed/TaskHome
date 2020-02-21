package com.example.mahmoudsaed.taskhome.di.modules;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mahmoudsaed.taskhome.data.HomeDataBase;
import com.example.mahmoudsaed.taskhome.data.Repository;
import com.example.mahmoudsaed.taskhome.data.local.dao.AttractionDao;
import com.example.mahmoudsaed.taskhome.data.local.dao.EventDao;
import com.example.mahmoudsaed.taskhome.data.local.dao.HotspotDao;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Module(includes = {NetworkServiceModule.class, ApplicationModule.class})
public class DataServiceModule {
    private static final String HOME_DATABASE_NAME = "home_db";

    @Provides
    @Singleton
    Repository provideRepository(Executor executor, HomeDataBase homeDataBase,  Retrofit HomerApi){
        return new Repository(executor,homeDataBase,HomerApi);
    }
    @Provides
    @Singleton
    EventDao provideEventsDao(HomeDataBase database){
        return database.eventDao();
    }
    @Provides
    @Singleton
    HotspotDao provideHotspotsDao(HomeDataBase database){
        return database.hotspotDao();
    }
    @Provides
    @Singleton
    AttractionDao provideAttractionsDao(HomeDataBase database){
        return database.attractionDao();
    }

    @Provides
    @Singleton
    HomeDataBase provideDataBase(Application application){
        return Room.databaseBuilder(application.getBaseContext(), HomeDataBase.class, HOME_DATABASE_NAME)
                .build();

    }
}
