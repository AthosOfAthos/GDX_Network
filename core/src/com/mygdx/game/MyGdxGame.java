package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Paddle playerPaddle;
	
	@Override
	public void create () {
	    batch = new SpriteBatch();
	    playerPaddle = new Paddle(100,100,10);
	}

	private void loop() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            playerPaddle.moveUp();
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            playerPaddle.moveDown();
        }
    }

	@Override
	public void render () {
	    loop();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		playerPaddle.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
