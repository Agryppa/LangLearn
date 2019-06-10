package com.example.langlearn;

public class Chapter {
    private String name;
    private  int pos;
    private int icon;

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public int getIcon() {
        return icon;
    }

    public Chapter(String name, int pos, int icon) {
        this.name = name;
        this.pos = pos;
        this.icon = icon;
    }
}
