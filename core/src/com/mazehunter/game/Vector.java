package com.mazehunter.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by asv on 19-08-2015.
 */
public class Vector {

    double x;
    double y;

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vector minus(Vector v) {
        return new Vector(x-v.x, y-v.y);
    }

    double length() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector divided(double d) {
        return new Vector(x/d, y/d);
    }

    public Vector plus(Vector v) {
        return new Vector(x+v.x, y+v.y);
    }

    public Vector times(double d) {
        return new Vector(x*d, y*d);
    }

    public boolean equals(Vector v) {
        if(x == v.x && y == v.y) {
            return true;
        }
        return false;
    }


}
