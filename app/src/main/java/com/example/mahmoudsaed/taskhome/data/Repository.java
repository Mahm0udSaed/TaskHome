package com.example.mahmoudsaed.taskhome.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.mahmoudsaed.taskhome.data.local.entity.Attraction;
import com.example.mahmoudsaed.taskhome.data.local.entity.Event;
import com.example.mahmoudsaed.taskhome.data.local.entity.Hotspot;
import com.example.mahmoudsaed.taskhome.data.remote.ApiRequestInterface;
import com.example.mahmoudsaed.taskhome.data.remote.Data;
import com.example.mahmoudsaed.taskhome.data.remote.Response;
import com.example.mahmoudsaed.taskhome.ui.activity.HomeActivity;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */

public class Repository {
    private Executor executor;
    private HomeDataBase homeDataBase;
    private Retrofit homeApi;
    public Repository(Executor executor, HomeDataBase homeDataBase,  Retrofit HomerApi){
        this.executor=executor;
        this.homeDataBase=homeDataBase;
        this.homeApi=HomerApi;
    }

    public LiveData<Data> getRemoteData(){
        final MutableLiveData<Data> data = new MutableLiveData<>();
        homeApi.create(ApiRequestInterface.class).getHomeData().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call,  retrofit2.Response<Response> response) {
//                executor.execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        saveHomeData(response.body().getData());
//                        Log.d("HomeActivity",response.body().getData().getAttractions().size()+"");
//                    }
//                });
                data.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("HomeActivity",t.getMessage()+"error");
                data.setValue(null);
            }
        });
        return data;
    }

    public void saveHomeData(Data data) {
        homeDataBase.attractionDao().saveAttractions(data.getAttractions());
        homeDataBase.eventDao().saveEvents(data.getEvents());
        homeDataBase.hotspotDao().saveHotspots(data.getHot_spots());
    }

    public LiveData<List<Attraction>> getAllAttractions(){
        return homeDataBase.attractionDao().getAllAttractions();
    }

    public LiveData<List<Event>> getAllEvents(){
        return homeDataBase.eventDao().getAllEvents();
    }

    public LiveData<List<Hotspot>> getAllHotSpots(){
        return homeDataBase.hotspotDao().getAllHotspots();
    }

}
