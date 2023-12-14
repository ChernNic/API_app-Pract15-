package com.example.api_app;

import  com.google.gson.annotations.SerializedName;
import android.os.Parcel;
import android.os.Parcelable;

public class Series {

    @SerializedName("id_Manga")
    private int id_manga;

    @SerializedName("manga_Detail")
    private String detail;

    @SerializedName("manga_Img")
    private String img;

    @SerializedName("manga_Name")
    private String manga_name;

    @SerializedName("student_Fio")
    private String fio;

    @SerializedName("student_Score")
    private int score;

    public Series(int id_manga, String detail, String img, String manga_name, String fio, int score) {
        this.id_manga = id_manga;
        this.manga_name = manga_name;
        this.detail = detail;
        this.img = img;
        this.fio = fio;
        this.score = score;
    }

    public Series(String detail, String img, String manga_name, String fio, int score) {
        this.manga_name = manga_name;
        this.detail = detail;
        this.img = img;
        this.fio = fio;
        this.score = score;
    }

    public int getId_manga() {
        return id_manga;
    }

    public void setId_manga(int id_manga) {
        this.id_manga = id_manga;
    }

    public String getManga_name() {
        return manga_name;
    }

    public void setManga_name(String manga_name) {
        this.manga_name = manga_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}