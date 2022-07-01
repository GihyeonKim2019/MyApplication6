package com.example.myapplication6;
import android.graphics.Path;

public class FingerPath  {
    public int color;
    public int strokeWideth;
    public Path path;

    public FingerPath(int color, int strokeWideth, Path path) {
        this.color = color;
        this.strokeWideth = strokeWideth;
        this.path = path;
    }
}