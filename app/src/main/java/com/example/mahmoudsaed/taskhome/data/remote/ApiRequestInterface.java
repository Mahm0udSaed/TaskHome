package com.example.mahmoudsaed.taskhome.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */

public interface ApiRequestInterface {
    @GET("home")
    Call<Response> getHomeData();
}
