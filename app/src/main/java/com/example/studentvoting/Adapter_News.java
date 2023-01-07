package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.Shapeable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter_News extends RecyclerView.Adapter<Adapter_News.ViewHolder>{

    Context context;
    ArrayList<News> newsArrayList;

    public Adapter_News(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder
                (LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        News news = newsArrayList.get(position);
        holder.title_news.setText(news.heading);
        holder.imageView.setImageResource(news.imageView);
        holder.desc_news.setText(news.descNews);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }






    public static class ViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView imageView;
        TextView title_news;
        TextView desc_news;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageNews);
            title_news = itemView.findViewById(R.id.title_news);
            desc_news = itemView.findViewById(R.id.desc_news);
        }
    }
}
