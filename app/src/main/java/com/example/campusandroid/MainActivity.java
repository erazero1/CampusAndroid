package com.example.campusandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    public void exitConfirming(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            finish();
        });
        builder.setNeutralButton("Cancel", null);
        builder.setCancelable(false);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        exitConfirming();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CampusAndroid);
        setContentView(R.layout.activity_main);

        TextView titleOfGame = findViewById(R.id.titleOfGame);
        Button playButton = findViewById(R.id.playButton);
        Button exitButton = findViewById(R.id.exitButton);

        // If user touched the Play button, starts the Play Activity
        playButton.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
            startActivity(intent);
        });

        exitButton.setOnClickListener((View view) -> {
            exitConfirming();
        });
    }


}
