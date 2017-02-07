package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MyGdxGame extends ApplicationAdapter {
    int state;
    //1 = in 2player game
    int width, height;
    OrthographicCamera camera;
    StretchViewport viewport;

	SpriteBatch batch;

	//Ui
    Texture UITwoTexture;
    Sprite UITwo;

	//gameSprites
	Texture zero;
	Sprite leftZero;
	Sprite rightZero;
	Texture one;
	Sprite leftOne;
	Sprite rightOne;
	Texture two;
	Sprite leftTwo;
	Sprite rightTwo;
	Paddle leftPaddle;
	Paddle rightPaddle;
	Ball ball;
	
	@Override
	public void create () {
	    state = 1;
	    width = 200;
	    height = 200;
	    zero = new Texture("0.png");
	    leftZero = new Sprite(zero);
	    leftZero.setPosition(-10,90);
	    rightZero = new Sprite(zero);
	    rightZero.setPosition(10,90);
	    one = new Texture("1.png");
	    leftOne = new Sprite(one);
	    leftOne.setPosition(-10,90);
	    rightOne = new Sprite(one);
	    rightOne.setPosition(10,90);
	    two = new Texture("2.png");
	    leftTwo = new Sprite(two);
	    leftTwo.setPosition(-10,90);
	    rightTwo = new Sprite(two);
	    rightTwo.setPosition(10,90);
	    camera = new OrthographicCamera(width,height);
	    viewport = new StretchViewport(width, height, camera);
	    batch = new SpriteBatch();
	    leftPaddle = new Paddle(-80,0,200, "paddleRed.png");
	    rightPaddle = new Paddle(80, 0, 200, "paddleBlu.png");
	    ball = new Ball(0,0,75);
	}

	private void loop() {

	    switch (state) {
            case 0:
                //Titlescreen
                break;
            case 1:
                //Two player game
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
                ball.collide(leftPaddle.y, rightPaddle.y);
                break;
            case 2:
                //host
                break;
            case 3:
                //client
                break;
        }

    }

    private void drawScore() {

	    switch (ball.scoreLeft) {
            case 0:
                leftZero.draw(batch);
                break;
            case 1:
                leftOne.draw(batch);
                break;
            case 2:
                leftTwo.draw(batch);
                break;
            default:
                if (ball.scoreLeft > 2) {
                    ball.scoreLeft = 0;
                }
                break;
        }

        switch (ball.scoreRight) {
            case 0:
                rightZero.draw(batch);
                break;
            case 1:
                rightOne.draw(batch);
                break;
            case 2:
                rightTwo.draw(batch);
                break;
            default:
                if (ball.scoreRight > 2) {
                    ball.scoreRight = 0;
                }
                break;
        }
    }



	@Override
	public void render () {

	    switch (state) {
            case 1:
                loop();
                Gdx.gl.glClearColor(0, 0, 0, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                camera.update();
                batch.setProjectionMatrix(camera.combined);
                batch.begin();
                leftPaddle.draw(batch);
                rightPaddle.draw(batch);
                ball.draw(batch);
                drawScore();
                batch.end();
                break;
        }



	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
