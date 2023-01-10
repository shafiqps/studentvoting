package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManifestoAdapter extends RecyclerView.Adapter<ManifestoAdapter.MyViewHolder>{

    Context context;
    ArrayList<Manifesto> manifestoArrayList;
    public ManifestoAdapter (Context context, ArrayList<Manifesto> manifestoArrayList){
        this.context = context;
        this.manifestoArrayList = manifestoArrayList;
    }

    @NonNull
    @Override
    public ManifestoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_manifesto_party,parent,false);

        return new ManifestoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManifestoAdapter.MyViewHolder holder, int position) {

        holder.manifesto.setText(manifestoArrayList.get(position).getManifesto());
    }

    @Override
    public int getItemCount() {
        return manifestoArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView manifesto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            manifesto = itemView.findViewById(R.id.manifestoTV);
        }
    }
}