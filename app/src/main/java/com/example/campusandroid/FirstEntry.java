package com.example.campusandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstEntry extends AppCompatActivity {

    static boolean flag = false;
    SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();


    public static void passChanger(boolean bool){
        flag = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_entry);


        EditText passInput = findViewById(R.id.passInput);
        Button passButton = findViewById(R.id.passButton);
        if(flag){
            editor.putString("pass",null);
        }

        if(preferences.getString("pass", null) != null){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = String.valueOf(passInput.getText());
                editor.putString("pass", password);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}