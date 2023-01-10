package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class featuredInfoAdapter extends RecyclerView.Adapter<featuredInfoAdapter.MyViewHolder> {

    Context context;
    ArrayList<featuredInfo> featuredInfoArrayList;

    public featuredInfoAdapter (Context context, ArrayList<featuredInfo> featuredInfoArrayList){
        this.context = context;
        this.featuredInfoArrayList = featuredInfoArrayList;
    }
    @NonNull
    @Override
    public featuredInfoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_featured_info,parent,false);

        return new featuredInfoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull featuredInfoAdapter.MyViewHolder holder, int position) {

        holder.info.setText(featuredInfoArrayList.get(position).getInfo());
        Picasso.get().load(featuredInfoArrayList.get(position).getImage()).into(holder.imageInfo);

//        holder.imageInfo.setImageResource(featuredInfoArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return featuredInfoArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView info;
        ImageView imageInfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageInfo = itemView.findViewById(R.id.imageViewinfo);
            info = itemView.findViewById(R.id.info1);
        }
    }
}
