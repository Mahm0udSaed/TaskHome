package com.example.mahmoudsaed.taskhome.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mahmoudsaed.taskhome.data.local.entity.Attraction;
import com.example.mahmoudsaed.taskhome.data.local.entity.DataContainer;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


/**
 * Created by Mahmoud Saed on 2/20/2020.
 */
@Dao
public interface AttractionDao {
    @Insert(onConflict = REPLACE)
    void saveAttractions(List<Attraction> attractions);

    @Query("SELECT * FROM attractions")
    LiveData<List<Attraction>> getAllAttractions();
}
