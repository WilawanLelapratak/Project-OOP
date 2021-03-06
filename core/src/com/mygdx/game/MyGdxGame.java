package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
//public class MyGdxGame extends ApplicationAdapter {
	public SpriteBatch batch;
	
	public static final int HEIGHT = 600;
	
	public static final int WIDTH = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
