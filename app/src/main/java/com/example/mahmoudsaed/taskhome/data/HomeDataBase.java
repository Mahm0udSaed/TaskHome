package com.example.mahmoudsaed.taskhome.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.mahmoudsaed.taskhome.data.local.dao.AttractionDao;
import com.example.mahmoudsaed.taskhome.data.local.dao.EventDao;
import com.example.mahmoudsaed.taskhome.data.local.dao.HotspotDao;
import com.example.mahmoudsaed.taskhome.data.local.entity.Attraction;
import com.example.mahmoudsaed.taskhome.data.local.entity.Event;
import com.example.mahmoudsaed.taskhome.data.local.entity.Hotspot;
import com.example.mahmoudsaed.taskhome.data.utils.StringConverter;

/**
 * Created by Mahmoud Saed on 2/20/2020.
 */
@Database(entities = {Attraction.class, Event.class, Hotspot.class}, version = 1, exportSchema = false)
@TypeConverters(StringConverter.class)
public abstract class HomeDataBase extends RoomDatabase {
    public abstract AttractionDao attractionDao();
    public abstract EventDao eventDao();
    public abstract HotspotDao hotspotDao();
}
