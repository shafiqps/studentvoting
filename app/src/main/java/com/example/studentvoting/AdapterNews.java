package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder>{

    News[] news;
    Context context;
    private final RecyclerViewInterface recyclerViewInterface;

    public AdapterNews(News[] news, Home home, RecyclerViewInterface recyclerViewInterface) {
        this.news = news;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_news,parent, false);
        ViewHolder viewHolder = new ViewHolder(view, recyclerViewInterface);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final News newsList = news[position];
        holder.title_news.setText(newsList.getTitle_news());
        holder.desc_news.setText(newsList.getDescNews());
        holder.imageNews.setImageResource(newsList.getImageNews());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, newsList.getTitle_news(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return news.length;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageNews;
        TextView title_news;
        TextView desc_news;


        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageNews = itemView.findViewById(R.id.imageNews);
            title_news = itemView.findViewById(R.id.title_news);
            desc_news = itemView.findViewById(R.id.desc_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }
                }
            });
        }
    }

}
