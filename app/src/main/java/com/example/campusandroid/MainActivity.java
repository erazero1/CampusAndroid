package com.example.campusandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Save");
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", null);
        builder.setNeutralButton("Cancel", null);
        builder.setNegativeButton("No", null);
        builder.create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CampusAndroid);
        setContentView(R.layout.activity_main);

        Button saveBtn = findViewById(R.id.saveButton);
        Button delBtn = findViewById(R.id.deleteButton);
        EditText inputField = findViewById(R.id.inputField);
        ScrollView scrollView = findViewById(R.id.scrollView);
        TextView TVinScroll = findViewById(R.id.TVinScroll);


        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Delete all?");
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TVinScroll.setText(null);
                        Toast.makeText(getApplicationContext(), "All notes deleted", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.setNeutralButton("Cancel", null);
                builder.create().show();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Save");
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);
                // builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (inputField.getText() == null) {
                            Toast.makeText(getApplicationContext(), "There's no text", Toast.LENGTH_LONG).show();
                        } else {
                            String content = (String) TVinScroll.getText();
                            content += "\n\n" + inputField.getText();
                            TVinScroll.setText(content);
                            inputField.setText(null);
                        }
                    }
                });

                builder.setNegativeButton("No", null);
                builder.setNeutralButton("Cancel", null);


                builder.create().show();
            }
        });

    }


}
