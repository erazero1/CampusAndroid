package com.example.campusandroid;

import static com.example.campusandroid.models.Manga.GLOBAL_MANGA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.campusandroid.models.Manga;

public class MangaEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_edit);

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
            Intent i = getIntent();
            if (i.getIntExtra("position", -1) != -1) {
                GLOBAL_MANGA.set(i.getIntExtra("position", GLOBAL_MANGA.size() - 1), manga);
            }
            setResult(RESULT_OK, i);
            finish();

        });


    }
}