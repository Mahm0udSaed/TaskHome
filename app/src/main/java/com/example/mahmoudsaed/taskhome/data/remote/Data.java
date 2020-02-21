package com.example.mahmoudsaed.taskhome.data.remote;
import com.example.mahmoudsaed.taskhome.data.local.entity.Attraction;
import com.example.mahmoudsaed.taskhome.data.local.entity.DataContainer;
import com.example.mahmoudsaed.taskhome.data.local.entity.Event;
import com.example.mahmoudsaed.taskhome.data.local.entity.Hotspot;

import java.util.List;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */

public class Data {
    private List<Attraction> attractions;
    private List<Event> events;
    private List<Hotspot> hot_spots;

    public Data(List<Attraction> attractions, List<Event> events, List<Hotspot> hot_spots) {
        this.attractions = attractions;
        this.events = events;
        this.hot_spots = hot_spots;
    }
    public Data(){

    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Hotspot> getHot_spots() {
        return hot_spots;
    }

    public void setHot_spots(List<Hotspot> hot_spots) {
        this.hot_spots = hot_spots;
    }
}
