package com.team.ucapp.ui.home;

import java.util.ArrayList;

public class Section {
    int type;
    private String sectionLabel;
    private ArrayList<Object> objects;

    public Section(int type, String sectionLabel, ArrayList<Object> objects) {
        this.type = type;
        this.sectionLabel = sectionLabel;
        this.objects = objects;
    }

    public int getType() {
        return type;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }
}
