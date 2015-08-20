package com.mazehunter.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by asv on 19-08-2015.
 */
public class Walls {

    Texture img;
    int width;
    int height;
    ArrayList<Vector> walls;

    Walls() {
        img = new Texture("wall.png");
        width = img.getWidth();
        height = img.getHeight();
        walls = new ArrayList<Vector>();
        walls.add(new Vector(30,30));
        walls.add(new Vector(300,300));
        walls.add(new Vector(700,30));
        walls.add(new Vector(-30,-30));
    }

    public int getX(Vector v) {
        return (int) Math.round(v.x - width / 2);
    }

    public int getY(Vector v) {
        return (int) Math.round(v.y - height / 2);
    }



}
