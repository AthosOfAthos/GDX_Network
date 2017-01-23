package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
    int x, y;
    int nx,ny;
    float moveSpeed;
    Texture ballTexture;
    Sprite ballSprite;
    public Ball(int getX, int getY, float getSpeed) {
        x = getX;
        y = getY;
        nx = (int)(Math.random()*10);
    	ny = (int)(Math.random()*10);
        moveSpeed = getSpeed;
        ballTexture = new Texture("ball.png");
        ballSprite = new Sprite(ballTexture);
    }

    public void setPos(int getX, int getY) {
        x = getX;
        y = getY;
    }

    public void  loop(){
    	setPos(nx+x,ny+y);
    	offscreen();
    }

    private void offscreen() {
    	//checks if offscreen and updates nx like a bouncce		
	}

	public void draw(SpriteBatch batch) {
        ballSprite.setPosition(x,y);
        ballSprite.draw(batch);
    }
}