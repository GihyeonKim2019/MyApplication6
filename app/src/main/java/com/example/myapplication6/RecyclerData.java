package com.example.myapplication6;

public class RecyclerData {
    private String title;
    private String content;
    private int resId;

    public RecyclerData(int resourceId, String title, String content) {
        this.resId = resourceId;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}