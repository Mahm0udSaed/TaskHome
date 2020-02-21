package com.example.mahmoudsaed.taskhome.ui.activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mahmoudsaed.taskhome.R;
import com.example.mahmoudsaed.taskhome.TaskHomeApp;
import com.example.mahmoudsaed.taskhome.data.remote.Data;
import com.example.mahmoudsaed.taskhome.data.utils.SlideInAnimationHandler;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
   HomeViewModel homeViewModel=null;
   @Inject
   ViewModelProvider.Factory  factory;
   AdapterAll attractionsAdapterAll;
    AdapterAll eventsAdapterAll;
    AdapterAll hotspotsAdapterAll;
    @BindView(R.id.attractions_layout)
    RelativeLayout attractions;
    @BindView(R.id.events_layout)
    RelativeLayout events;
    @BindView(R.id.hotspots_layout)
    RelativeLayout hotspots;
    @BindView(R.id.home_iv)
    ImageView home;
    @BindView(R.id.search_iv)
    ImageView search;
    @BindView(R.id.notification_iv)
    ImageView notificationIcon;
    @BindView(R.id.profile_iv)
    ImageView profile;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
   @BindView(R.id.attractions_rv)
    RecyclerView attractionsRv;
   @BindView(R.id.events_rv)
   RecyclerView eventsRv;
    @BindView(R.id.hotspots_rv)
    RecyclerView hotspotsRv;
    @BindView(R.id.bellman_iv)
    ImageView bellManIv;
    @OnClick({R.id.home_iv,R.id.search_iv,R.id.notification_iv,R.id.profile_iv})
    public void changeView(ImageView imageView){
        switch (imageView.getId()){
            case R.id.home_iv:
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_bottom_icon));
                search.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.search_grey_bottom_icon));
                notificationIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.notification_grey_bottom_icon));
                profile.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.profile_grey_bottom_icon));
                break;
            case R.id.search_iv:
                home.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_grey_bottom_icon));
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.search_bottom_icon));
                notificationIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.notification_grey_bottom_icon));
                profile.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.profile_grey_bottom_icon));
                break;
            case R.id.notification_iv:
                home.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_grey_bottom_icon));
                search.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.search_grey_bottom_icon));
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.notification_bottom_icon));
                profile.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.profile_grey_bottom_icon));
                break;
            case R.id.profile_iv:
                home.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_grey_bottom_icon));
                search.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.search_grey_bottom_icon));
                notificationIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.notification_grey_bottom_icon));
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.profile_bottom_icon));
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        home.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_bottom_icon));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setUpViewModel();
        setUpRecyclers();
        setUpActiomMenu();

    }

    private void setUpActiomMenu() {
        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this)
                .setTheme(SubActionButton.THEME_LIGHT);

        ImageView imageView1=new ImageView(this);
        FrameLayout.LayoutParams layoutParams1=new FrameLayout.LayoutParams(200,200);
        imageView1.setMinimumHeight(50);
        imageView1.setMinimumWidth(50);
        imageView1.setLayoutParams(layoutParams1);
        ImageView imageView2=new ImageView(this);
        imageView2.setMinimumHeight(50);
        imageView2.setMinimumWidth(50);
        ImageView imageView3=new ImageView(this);
        imageView3.setMinimumHeight(50);
        imageView3.setMinimumWidth(50);
        ImageView imageView4=new ImageView(this);
        imageView4.setMinimumHeight(50);
        imageView4.setMinimumWidth(50);
        imageView4.setColorFilter(ContextCompat.getColor(this,R.color.black));
        imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hotspot_icon));
        imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.events_icon));
        imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.attarctions_icon));
        imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.map_icon_small));
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(150,150);
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .setStartAngle(-20)
                .setEndAngle(-160)
                .setAnimationHandler(new SlideInAnimationHandler())
                .addSubActionView(rLSubBuilder.setContentView(imageView4).setLayoutParams(layoutParams).build())
                .addSubActionView(rLSubBuilder.setContentView(imageView3).build())
                .addSubActionView(rLSubBuilder.setContentView(imageView2).build())
                .addSubActionView(rLSubBuilder.setContentView(imageView1).build())
                .setRadius(200)
                // ...
                .attachTo(bellManIv)
                .build();
    }

    private void setUpRecyclers() {
        attractionsAdapterAll =new AdapterAll(this);
        eventsAdapterAll =new AdapterAll(this);
        hotspotsAdapterAll =new AdapterAll(this);
        LinearLayoutManager attractionslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager eventslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager hotspotslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        attractionsRv.setLayoutManager(attractionslayoutManager);
        eventsRv.setLayoutManager(eventslayoutManager);
        hotspotsRv.setLayoutManager(hotspotslayoutManager);
        attractionsRv.setAdapter(attractionsAdapterAll);
        eventsRv.setAdapter(eventsAdapterAll);
        hotspotsRv.setAdapter(hotspotsAdapterAll);
        setUpObserver();
    }

    private void setUpObserver() {
        homeViewModel.getRemote().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data data) {

                List<Object> attractionObject = new ArrayList<>();
                List<Object> eventObject = new ArrayList<>();
                List<Object> hotspotObject = new ArrayList<>();
                attractionObject.addAll(data.getAttractions());
                eventObject.addAll(data.getEvents());
                hotspotObject.addAll(data.getHot_spots());
                attractionsAdapterAll.setData(attractionObject);
                eventsAdapterAll.setData(eventObject);
                hotspotsAdapterAll.setData(hotspotObject);
            }
        });
    }


    private void setUpViewModel() {
        ((TaskHomeApp) getApplication()).getmApplicationComponent().inject(this);
        homeViewModel= ViewModelProviders.of(this,factory).get(HomeViewModel.class);
    }
}
