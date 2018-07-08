package com.team.ucapp.ui.home;

public class EventDummy {
    private String title;
    private String date;
    private String description;
    int type;

    public EventDummy(String title, String date, String description, int type) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
