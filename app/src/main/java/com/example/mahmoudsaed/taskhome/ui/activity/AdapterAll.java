package com.example.mahmoudsaed.taskhome.ui.activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mahmoudsaed.taskhome.R;
import com.example.mahmoudsaed.taskhome.data.local.entity.Attraction;
import com.example.mahmoudsaed.taskhome.data.local.entity.Event;
import com.example.mahmoudsaed.taskhome.data.local.entity.Hotspot;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mahmoud Saed on 2/20/2020.
 */

public class AdapterAll extends RecyclerView.Adapter<AdapterAll.ItemHolder> {
    private List<Object> containers;
    Context context;
    public AdapterAll(Context context){
        this.context=context;
        containers=new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        String name,image=null;
        if (containers.get(0) instanceof Attraction){
         name=((Attraction)containers.get(position)).getName();
            if (((Attraction) containers.get(position)).getPhotos().size()!=0)
                image=((Attraction)containers.get(position)).getPhotos().get(0);
        }else if(containers.get(0) instanceof Event){
            Log.d("HomeActivity",((Event)containers.get(position)).getName()+"name");

            name=((Event)containers.get(position)).getName();
            if (((Event) containers.get(position)).getPhotos().size()!=0)
                image=((Event)containers.get(position)).getPhotos().get(0);
        }else{
            name=((Hotspot)containers.get(position)).getName();
            if (((Hotspot) containers.get(position)).getPhotos().size()!=0)
                image=((Hotspot)containers.get(position)).getPhotos().get(0);
        }
        holder.nameTv.setText(name);
        GlideApp.with(context).load(image)
                .error(R.drawable.ic_broken_image)
                .placeholder(R.drawable.ic_image)
                .into(holder.placeIv);
    }

    @Override
    public int getItemCount() {
        return containers.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.name_tv)
        TextView nameTv;
        @BindView(R.id.place_image)
        ImageView placeIv;
        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public void setData(List<Object> containers){
        this.containers.addAll(containers);
        notifyDataSetChanged();
    }
}
