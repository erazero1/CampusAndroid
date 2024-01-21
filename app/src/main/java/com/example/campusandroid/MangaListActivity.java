package com.example.campusandroid;

import static com.example.campusandroid.models.Manga.GLOBAL_MANGA;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.campusandroid.adapters.MangaListAdapter;
import com.example.campusandroid.models.Manga;


public class MangaListActivity extends AppCompatActivity {
    MangaListAdapter adapter;

    public void exitConfirming() {
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Manga manga = (Manga) data.getExtras().get("Manga");
                GLOBAL_MANGA.add(manga);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MangaListActivity.this, MangaAddingActivity.class);
        startActivityForResult(intent, 1);

        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.options_menu, menu);

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CampusAndroid);
        setContentView(R.layout.activity_mangalist);

        ListView listView = findViewById(R.id.listView);
        adapter = new MangaListAdapter(MangaListActivity.this, GLOBAL_MANGA);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MangaListActivity.this);
            builder.setTitle("Delete?");
            builder.setTitle("Do you want to delete this item?");
            builder.setPositiveButton("Yes", ((dialogInterface, i) -> {
                GLOBAL_MANGA.remove(position);
                adapter.notifyDataSetChanged();
                listView.smoothScrollToPosition(GLOBAL_MANGA.size());
            }));
            builder.setNegativeButton("No", null);
            builder.create().show();
            return true;
        });


    }


}
