package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private MyGdxGame myGdxGame;
	
	private Texture pacmanImg;
	
	//private Pacman pacman;
	
	World world;
	
	private WorldRenderer worldRenderer;
	
    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        pacmanImg = new Texture("pacman.png");
        //pacman = new Pacman(100, 100);
        world = new World(myGdxGame);
        worldRenderer = new WorldRenderer(myGdxGame, world);
    }
    
    @Override
    public void render(float delta) {
    	world.update(delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    	/*SpriteBatch batch = myGdxGame.batch;
        batch.begin();
        Vector2 pos = pacman.getPosition();
        batch.draw(pacmanImg, pos.x, pos.y);
        batch.end();*/
        
    }
    
    /*private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
           World.pacman.move(Pacman.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            World.pacman.move(Pacman.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	World.pacman.move(Pacman.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	World.pacman.move(Pacman.DIRECTION_RIGHT);
        }
    }*/
}
