package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
    int x, y;
    int velX,velY;
    float moveSpeed;
    Texture ballTexture;
    Sprite ballSprite;
    public Ball(int getX, int getY, float getSpeed) {
        x = getX;
        y = getY;
        velX = -1;//(int)(Math.random()*10);
    	velY = 0;//(int)(Math.random()*10);
        moveSpeed = getSpeed;
        ballTexture = new Texture("ball.png");
        ballSprite = new Sprite(ballTexture);
    }

    public void setPos(int getX, int getY) {
        x = getX;
        y = getY;
    }

    public void  loop(){
    	setPos(velX+x,velY+y);
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