package com.example.mahmoudsaed.taskhome.data.utils;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Mahmoud Saed on 2/20/2020.
 */

public class StringConverter {
    @TypeConverter
    public  String imagesToString(List<String > images){
        Gson gson=new Gson();
        return gson.toJson(images);
    }
    @TypeConverter
    public List<String> imagesFromJson(String json){
        Gson gson=new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        return gson.fromJson(json,listType);
    }
}
