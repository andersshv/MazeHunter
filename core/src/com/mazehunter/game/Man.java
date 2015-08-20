package com.mazehunter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by asv on 19-08-2015.
 */
public class Man {

    Texture img;
    int width;
    int height;
    Vector pos;
    Vector goalPos;
    Vector centerScreen;
    float speed = 3;

    Man(){
        img = new Texture("man.png");
        width = img.getWidth();
        height = img.getHeight();
        pos = new Vector(MazeHunter.screenWidth / 2, MazeHunter.screenHeight / 2);
        goalPos = new Vector(MazeHunter.screenWidth / 2, MazeHunter.screenHeight / 2);
        centerScreen = new Vector(MazeHunter.screenWidth / 2, MazeHunter.screenHeight / 2);
    }

    void touchDown(int screenX, int screenY) {
        int x = screenX;
        int y = MazeHunter.screenHeight - screenY;
        Vector touch = new Vector(x, y);
        Vector centerToTouch = touch.minus(centerScreen);
        goalPos = pos.plus(centerToTouch);
    }

    public void update() {
//        pos.x = goalPos.x;
//        pos.y = goalPos.y;
        if(!goalPos.equals(pos)) {
            Vector moveDir = goalPos.minus(pos);
            if (moveDir.length() <= speed) {
                pos.x = goalPos.x;
                pos.y = goalPos.y;
            } else {
                Vector moveDirUnit = moveDir.divided(moveDir.length());
                pos = pos.plus(moveDirUnit.times(speed));
            }
        }
    }

    public int getX() {
        return (int) Math.round(pos.x);
    }

    public int getY() {
        return (int) Math.round(pos.y);
    }

    private void log(Vector v) {
        Gdx.app.log("(" + v.x + "," + v.y + ")", "");
    }

}
