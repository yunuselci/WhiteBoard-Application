package com.company;

import java.io.Serializable;

public class Points implements Serializable {
    int x,x1,x2;
    int y,y1,y2;
    String shapeName;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
