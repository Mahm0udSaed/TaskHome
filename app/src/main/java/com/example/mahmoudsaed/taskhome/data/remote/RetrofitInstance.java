package com.example.mahmoudsaed.taskhome.data.remote;

import com.example.mahmoudsaed.taskhome.data.utils.ConstantUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahmoud Saed on 9/21/2019.
 */

public class RetrofitInstance {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(ConstantUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }
}
