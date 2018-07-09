package com.team.ucapp.ui.calendar;

public class EventDummy {
    private String title;
    private String day;
    private String month;
    private String description;
    int type;

    public EventDummy(String title, String date, String month, String description, int type) {
        this.title = title;
        this.day = date;
        this.month = month;
        this.description = description;
        this.type = type;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
