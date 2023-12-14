package com.example.api_app;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiDataManager {
    private ApiInterface apiInterface;

    public ApiDataManager() {
        // Инициализируем Retrofi
        apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
    }

    public void uploadSeries(Series series) {
//        // объект Call для отправки данных
//        Call<Series> call = apiInterface.uploadSeries(series);
//
//        // асинхронный метод для выполнения запроса
//        call.enqueue(new Callback<Series>() {
//            @Override
//            public void onResponse(Call<Series> call, Response<Series> response) {
//                if (response.isSuccessful()) {
//                    Series uploadedSeries = response.body();
//
//                } else {
//                    Log.e("API", "Error: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Series> call, Throwable t) {
//                Log.e("API", "Failure: " + t.getMessage());
//            }
//        });
    }

    public void deleteSeries(Series series) {
        // объект Call для отправки данных
        Call<String> call = apiInterface.deleteManga(series.getId_manga());

        // асинхронный метод для выполнения запроса
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String message = response.body();

                } else {
                    Log.e("API", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("API", "Failure: " + t.getMessage());
            }
        });
    }
}
