package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
    int x, y;
    int startVelX, startVelY;
    int velX,velY;
    float moveSpeed;
    Texture ballTexture;
    Sprite ballSprite;
    public Ball(int getX, int getY, float getSpeed) {
        x = getX;
        y = getY;
        startVelX = -1;
        startVelY = 0;
        velX = -1;
    	velY = 0;
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
    	if(y<-90||y>90){
    		velY = -velY;
    	}
    	if(x<-90||x>90){
    		velX = startVelX;
    		velY = startVelY;
    		x = 0;
    		y = 0;
    	}
	}

	public void collide(float leftY, float rightY) {
        int paddleLength = 25;
        if (x < -77 && x > -80) {
            if (y > leftY - 2 && y < leftY + paddleLength) {
                velX *= -1;
            }
        }
        if (x > 77 && x < 80) {
            if (y > rightY - 2 && y < rightY + paddleLength) {
                velX *= -1;
            }
        }
    }

	public void draw(SpriteBatch batch) {
        ballSprite.setPosition(x,y);
        ballSprite.draw(batch);
    }
}