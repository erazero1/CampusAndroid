package com.example.campusandroid.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Manga implements Serializable   {
    public static ArrayList<Manga> GLOBAL_MANGA = new ArrayList<Manga>();
    static{
        GLOBAL_MANGA.add(new Manga("One Piece", "Eiichiro Oda", 1997, false));
        GLOBAL_MANGA.add(new Manga("Naruto", "Masashi Kishimoto", 1999, true));
        GLOBAL_MANGA.add(new Manga("Dragon Ball", "Akira Toriyama", 1984, false));
        GLOBAL_MANGA.add(new Manga("Demon Slayer", "Koyoharu Gotoge", 2016, true));
        GLOBAL_MANGA.add(new Manga("Hunter x Hunter", "Yoshihiro Togashi", 1998, false));

    }
    private String title;
    private String author;
    private int publishYear;
    private boolean isFinished;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean getIsFinished(){
        return isFinished;
    }

    public Manga(String title, String author, int publishYear, boolean isFinished) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isFinished = isFinished;
    }

    @NonNull
    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", Published: " + publishYear;
    }
}
