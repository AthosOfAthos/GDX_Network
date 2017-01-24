package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    int state;
    //1 = in 2player game
    int width, height;
    OrthographicCamera camera;
    StretchViewport viewport;

    World world;//BOX2d world
    Box2DDebugRenderer debugView;//makes debuging things ez
    BodyDef theThing;
    Body notAWHore;
    CircleShape veryCircle;

	SpriteBatch batch;
	Paddle leftPaddle;
	Paddle rightPaddle;
	Ball ball;
	
	@Override
	public void create () {
	    state = 1;
	    width = 200;
	    height = 200;
	    Box2D.init();
	    world = new World(new Vector2(0,0), false);//create world with no gravity and no sleep
	    debugView = new Box2DDebugRenderer();
	    theThing = new BodyDef();
	    theThing.type = BodyType.DynamicBody;
	    theThing.position.set(0,0);
	    notAWHore = world.createBody(theThing);
	    camera = new OrthographicCamera(width,height);
	    viewport = new StretchViewport(width, height, camera);
	    batch = new SpriteBatch();
	    leftPaddle = new Paddle(-80,0,100);
	    rightPaddle = new Paddle(80, 0, 100);
	    ball = new Ball(0,0,10);
	}

	private void loop() {

	    switch (state) {
            case 1:
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
                batch.end();
                debugView.render(world, camera.combined);
                break;
        }



	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
