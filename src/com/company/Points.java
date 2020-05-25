package com.company;

import java.io.Serializable;

public class Points implements Serializable {
    int x,x1,x2;
    int y,y1,y2;
    int counter = 0;
    String shapeName;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Points(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

}
