package com.example.mahmoudsaed.taskhome.data.local.entity;

import android.arch.persistence.room.Entity;

import java.util.List;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Entity
public class DataContainer {
    private String name;
    private List<String> photos;

    public DataContainer(String name, List<String> photos) {
        this.name = name;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
