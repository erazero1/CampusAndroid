package com.example.campusandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Back");
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
        builder.create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CampusAndroid);
        setContentView(R.layout.activity_main);

        Button saveButton = findViewById(R.id.saveButton);
        EditText inputField = findViewById(R.id.inputField);
        ListView listView = findViewById(R.id.listView);

        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        data.addAll(Arrays.asList(preferences.getString("data", "").split("___")));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);



        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                builder.setTitle("Save");
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String input = String.valueOf(inputField.getText());
                        if (input.matches("")) {
                            Toast.makeText(getApplicationContext(), "There's no text", Toast.LENGTH_LONG).show();
                        } else {
                            data.add(input);
                            adapter.notifyDataSetChanged();
                            editor.putString("data", String.join("___", data)).apply();
                            listView.smoothScrollToPosition(data.size());
                            inputField.setText(null);
                        }
                    }
                });

                builder.setNegativeButton("No", null);


                builder.create().show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        editor.putString("data", String.join("___", data)).apply();
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Note have been deleted", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No", null);


                builder.create().show();
                return true;
            }
        });

    }


}
