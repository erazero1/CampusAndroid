package com.example.campusandroid.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.campusandroid.R;
import com.example.campusandroid.models.Manga;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MangaListAdapter extends ArrayAdapter<Manga> {
    private ArrayList<Manga> mangas = new ArrayList<Manga>();
    private final Context context;
    public MangaListAdapter(@NonNull Context context, @NonNull ArrayList<Manga> mangas) {
        super(context, R.layout.manga_item, mangas);
        this.mangas = mangas;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Manga currentManga = this.mangas.get(position);

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = convertView;
        if(v == null) {
            v = inflater.inflate(R.layout.manga_item, parent, false);
        }
        TextView tvTitle = (TextView)v.findViewById(R.id.tvTitle);
        TextView tvAuthor = (TextView)v.findViewById(R.id.tvAuthor);
        TextView tvYear = (TextView)v.findViewById(R.id.tvYear);
        TextView tvIsFinished = (TextView)v.findViewById(R.id.tvIsFinished);

        tvTitle.setText(currentManga.getTitle());
        tvAuthor.setText(currentManga.getAuthor());
        tvYear.setText(currentManga.getPublishYear() + "");
        tvIsFinished.setText(currentManga.getIsFinished()? "Finished" : "Not Finished");

        return v;
    }
}
