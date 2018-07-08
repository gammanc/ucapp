package com.team.ucapp.ui.home;

import java.util.ArrayList;

public class Section {
    private String sectionLabel;
    private ArrayList<Object> objects;

    public Section(String sectionLabel, ArrayList<Object> objects) {
        this.sectionLabel = sectionLabel;
        this.objects = objects;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }
}
