package com.example.api_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesDetailActivity extends AppCompatActivity {

    private int id;
    private Series series;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);

        ImageView seriesImageView = findViewById(R.id.seriesImageView);
        TextView mangaNameTextView = findViewById(R.id.mangaNameTextView);
        TextView mangaDetailTextView = findViewById(R.id.mangaDetailTextView);
        TextView floTextView = findViewById(R.id.floTextView);
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        ImageButton deleteButton = findViewById(R.id.DeleteBtn);

        // Получаем объект Series из Intent
        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            id = intent.getIntExtra("id", 0);

            apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);

            Call<ArrayList<Series>> getList = apiInterface.getSeriesList();

            getList.enqueue(new Callback<ArrayList<Series>>() {
                @Override
                public void onResponse(Call<ArrayList<Series>> call, Response<ArrayList<Series>> response) {
                    if(response.isSuccessful()){
                        ArrayList<Series> list = response.body();

                        series = list.get(id);

                        // Устанавливаем значения полей в соответствующие TextView и ImageView
                        mangaNameTextView.setText(series.getManga_name());
                        mangaDetailTextView.setText(series.getDetail());
                        floTextView.setText(series.getFio());
                        scoreTextView.setText(String.valueOf(series.getScore()));

                        // Используйте библиотеку Picasso или другие средства для загрузки изображения
                        Picasso.with(SeriesDetailActivity.this).load(series.getImg()).into(seriesImageView);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Series>> call, Throwable t) {

                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ApiDataManager apiDataManager = new ApiDataManager();
                    apiDataManager.deleteSeries(series);
                    Intent intent = new Intent(SeriesDetailActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}