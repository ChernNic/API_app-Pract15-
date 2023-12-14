package com.example.api_app;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("manga")
    Call<ArrayList<Series>> getSeriesList();

    @POST("manga/create")
    Call<Series> uploadSeries(@Body Series series);

    @DELETE("manga/delete/{id}")
    Call<String> deleteManga(@Path("id") int id);

}
