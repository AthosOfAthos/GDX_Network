package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Paddle {
    int x, y;
    Texture paddleTexture;
    Sprite paddleSprite;
    public Paddle(int getX, int getY) {
        x = getX;
        y = getY;
        paddleTexture = new Texture("paddle.png");
    }

    public void setPos(int getX, int getY) {
        x = getX;
        y = getY;
    }

    public void draw(SpriteBatch batch) {

    }
}
