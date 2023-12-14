package com.example.api_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    ImageButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        addBtn = findViewById(R.id.AddBtn);

        apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);

        Call<ArrayList<Series>> getList = apiInterface.getSeriesList();

        getList.enqueue(new Callback<ArrayList<Series>>() {

            
            @Override
            public void onResponse(Call<ArrayList<Series>> call, Response<ArrayList<Series>> response) {
                if(response.isSuccessful()){
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setHasFixedSize(true);
                    ArrayList<Series> list = response.body();

                    ItemAdapter adapter = new ItemAdapter(getApplicationContext(), list, MainActivity.this);

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Series>> call, Throwable t) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateSeriesActivity.class);
                startActivity(intent);
            }
        });
    }
}