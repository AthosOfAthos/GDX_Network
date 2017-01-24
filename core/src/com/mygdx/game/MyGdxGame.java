package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    int width, height;
    OrthographicCamera camera;
    StretchViewport viewport;

	SpriteBatch batch;
	Paddle leftPaddle;
	Paddle rightPaddle;
	Ball ball;
	
	@Override
	public void create () {
	    width = 200;
	    height = 200;
	    camera = new OrthographicCamera(width,height);
	    viewport = new StretchViewport(width, height, camera);
	    batch = new SpriteBatch();
	    leftPaddle = new Paddle(-50,0,100);
	    rightPaddle = new Paddle(50, 0, 100);
	    ball = new Ball(0,0,10);
	}

	@Override
    public void resize(int getWidth, int getHeight) {
	    width = getWidth;
	    height = getHeight;
    }

	private void loop() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            leftPaddle.moveUp();
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            leftPaddle.moveDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rightPaddle.moveUp();
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rightPaddle.moveDown();
        }
        ball.loop();
    }

	@Override
	public void render () {
	    loop();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		leftPaddle.draw(batch);
		rightPaddle.draw(batch);
		ball.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
