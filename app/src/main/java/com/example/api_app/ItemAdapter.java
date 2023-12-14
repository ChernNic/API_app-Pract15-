package com.example.api_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Series> list;
    private Activity activity;

    public ItemAdapter(Context context, ArrayList<Series> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int id = position;
        Series series = list.get(position);
        holder.title_textView.setText(series.getManga_name());
        holder.description_textView.setText(series.getDetail());
        Picasso.with(context).load(series.getImg()).into(holder.imageView);

        // Добавьте обработчик кликов на элемент RecyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // При нажатии на элемент, открываем активность с подробной информацией
                Intent intent = new Intent(context, SeriesDetailActivity.class);
                intent.putExtra("id", id);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_textView;
        TextView description_textView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cover_imageView);
            title_textView = itemView.findViewById(R.id.title_TextView);
            description_textView = itemView.findViewById(R.id.description_TextView);
        }
    }
}
