package com.example.api_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateSeriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_series);

        EditText editTextMangaName = findViewById(R.id.editTextMangaName);
        EditText editTextDetail = findViewById(R.id.editTextDetail);
        EditText editTextImg = findViewById(R.id.editTextImg);
        EditText editTextFlo = findViewById(R.id.editTextFlo);
        EditText editTextScore = findViewById(R.id.editTextScore);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получите текст из всех полей EditText
                String mangaName = editTextMangaName.getText().toString();
                String detail = editTextDetail.getText().toString();
                String img = editTextImg.getText().toString();
                String fio = editTextFlo.getText().toString();
                int score = Integer.parseInt(editTextScore.getText().toString());

                if (mangaName.isEmpty() || detail.isEmpty() || img.isEmpty() || fio.isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {

                    // Создаем экземпляр ApiDataUploader
                    ApiDataManager dataUploader = new ApiDataManager();

                    // Создаем экземпляр Series с данными, которые вы хотите отправить
                    Series seriesData = new Series("detail", "https://i.redd.it/ybshgffryhd91.jpg", "mangaName", "fio" , 10);
                    seriesData.setDetail(detail);
                    seriesData.setFio(fio);
                    seriesData.setImg(img);
                    seriesData.setManga_name(mangaName);
                    seriesData.setScore(score);
                    // Вызываем метод uploadSeries для отправки данных на сервер
                    dataUploader.uploadSeries(seriesData);

                }

                Intent intent = new Intent(CreateSeriesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
