package org.andrea.data;

import java.io.Serializable;

public class Coordinates implements Validateable, Serializable {
    private int x;
    private double y;

    public Coordinates(int x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        String s = "";
        s += "{\"x\" : " + Integer.toString(x) + ", ";
        s += "\"y\" : " + Double.toString(y) + "}";
        return s;
    }

    public boolean validate() {
        return !(Float.isInfinite(x) || Double.isFinite(y) || Float.isNaN(x) || Double.isNaN(y));
    }
}

