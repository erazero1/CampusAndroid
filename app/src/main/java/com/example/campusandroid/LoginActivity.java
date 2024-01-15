package com.example.campusandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.campusandroid.FirstEntry;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

      return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.passwordChanger){
            FirstEntry.passChanger(true);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        EditText passInput = findViewById(R.id.passInput);
        Button passButton = findViewById(R.id.passButton);


        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = preferences.getString("pass", "Nothing");
                if(password.matches(String.valueOf(passInput.getText()))){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}