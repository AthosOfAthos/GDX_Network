package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Paddle {
    float x, y, moveSpeed;
    Texture paddleTexture;
    Sprite paddleSprite;
    public Paddle(int getX, int getY, float getSpeed, String getFile) {
        x = getX;
        y = getY;
        moveSpeed = getSpeed;
        paddleTexture = new Texture(getFile);
        paddleSprite = new Sprite(paddleTexture);
    }

    public void setPos(int getX, int getY) {
        x = getX;
        y = getY;
    }

    public void moveUp() {
        y += moveSpeed * Gdx.graphics.getDeltaTime();
        if (y > 75) {
            y = 75;
        }
    }

    public void moveDown() {
        y -= moveSpeed * Gdx.graphics.getDeltaTime();
        if (y < -100) {
            y = -100;
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.SpriteBatch batch) {
        paddleSprite.setPosition(x,y);
        paddleSprite.draw(batch);
    }
}
