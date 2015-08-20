package com.mazehunter.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by asv on 19-08-2015.
 */
public class Background {

    Texture img;
    int width;
    int height;
    Vector pos;

    Background(Man man) {
        img = new Texture("background2.png");
        width = img.getWidth();
        height = img.getHeight();
        int sw = MazeHunter.screenWidth / 2;
        int diffW = width / 2 - sw;
        int posX = -diffW;
        int sh = MazeHunter.screenHeight;
        int diffH = height - sh;
        int posY = diffH / 2 * -1;
        pos = new Vector(posX + man.width / 2, posY + man.height / 2);
    }

    public int getX() {
        return (int) Math.round(pos.x);
    }

    public int getY() {
        return (int) Math.round(pos.y);
    }
}
