package com.mazehunter.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeHunter extends ApplicationAdapter implements InputProcessor {

    SpriteBatch batch;

    static int screenWidth;
    static int screenHeight;

    // Model
    Man man;
    Walls walls;
    Background background;
    OrthographicCamera cam;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
        man = new Man();
        walls = new Walls();
        background = new Background(man);
        cam = new OrthographicCamera(screenWidth, screenHeight);
        cam.position.set(screenWidth / 2, screenHeight / 2, 0);
        cam.update();
    }

	@Override
	public void render() {
        cam.position.set(man.getX() + man.width / 2, man.getY() + man.height / 2, 0);
        cam.update();

        batch.setProjectionMatrix(cam.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background.img, background.getX(), background.getY());
        for (Vector v : walls.walls) {
            batch.draw(walls.img, walls.getX(v), walls.getY(v));
        }
        batch.draw(man.img, man.getX(), man.getY());
        batch.end();

        man.update();
	}

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        man.touchDown(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void log(Vector v) {
        Gdx.app.log("(" + v.x + "," + v.y + ")", "");
    }

}
