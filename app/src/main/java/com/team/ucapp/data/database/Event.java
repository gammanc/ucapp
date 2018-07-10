package com.team.ucapp.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity(tableName = "events")
public class Event {
    @PrimaryKey
    @NonNull
    private int id;
    private String title;
    private Date date;
    private String description;
    int type;

    public Event(@NonNull int id, String title, Date date, String description, int type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDay(){
        SimpleDateFormat f = new SimpleDateFormat("dd", Locale.getDefault());
        return f.format(date);
    }

    public String getMonth(){
        return String.format(Locale.getDefault(),"%tB",date);
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
