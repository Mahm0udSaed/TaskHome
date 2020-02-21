package com.example.mahmoudsaed.taskhome.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */
@Entity(tableName = "attractions")
public class Attraction {
    @PrimaryKey
    private int id;
    private String name;
    private List<String> photos;

    public Attraction(int id, String name, List<String> photos) {
        this.id = id;
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
//        List<String> decodedImages=new ArrayList<>();
//        for (int i=0;i<photos.size();i++){
//            try {
//                URL url = new URL(photos.get(i));
//                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                decodedImages.add(BitMapToString(image));
//            } catch(IOException e) {
//                System.out.println(e);
//            }
//        }
//
//        return decodedImages;
        return this.photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
