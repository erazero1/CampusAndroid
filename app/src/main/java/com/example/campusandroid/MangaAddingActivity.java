package com.example.campusandroid;

import static com.example.campusandroid.models.Manga.GLOBAL_MANGA;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.campusandroid.models.Manga;

import java.io.Serializable;

public class MangaAddingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_adding);

        EditText titleInput = findViewById(R.id.titleInput);
        EditText authorInput = findViewById(R.id.authorInput);
        EditText publishYearInput = findViewById(R.id.publishYearInput);
        CheckBox isFinishedInput = findViewById(R.id.isFinishedCheckBox);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(view -> {
            String title = String.valueOf(titleInput.getText());
            String author = String.valueOf(authorInput.getText());
            int publishYear = Integer.parseInt(String.valueOf(publishYearInput.getText()));
            boolean isFinished = isFinishedInput.isChecked();

            Manga manga = new Manga(title, author, publishYear, isFinished);
            Intent i = new Intent();
            i.putExtra("Manga", manga);
            setResult(RESULT_OK, i);
            finish();
        });


    }
}