package com.company;

import java.io.Serializable;
//Using this class, we can exchange data between server and client
public class Informations implements Serializable {
    int x, x1, x2;
    int y, y1, y2;
    int min, sec;
    String shapeName;
    String message;

    public Informations(String shapeName) {
        this.shapeName = shapeName;
    }

    public Informations(String message, String shapeName) {
        this.message = message;
        this.shapeName = shapeName;
    }

    public Informations(int min, int sec, String shapeName) {
        this.min = min;
        this.sec = sec;
        this.shapeName = shapeName;
    }

    public Informations(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Informations(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

}
