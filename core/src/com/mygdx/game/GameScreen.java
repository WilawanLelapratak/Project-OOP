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
	
	private Pacman pacman;
	
	World world;
	
	private WorldRenderer worldRenderer;
	
    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        
        pacmanImg = new Texture("pacman.png");
        
        pacman = new Pacman(100, 100,world);
        
        world = new World(myGdxGame);
        
        worldRenderer = new WorldRenderer(myGdxGame, world);
    }
    
    @Override
    public void render(float delta) {
    	world.update(delta);
    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    	worldRenderer.render(delta);
    }
    
    public void update(float delta) {
    	updatePacmanDirection();
    	
    	world.update(delta);
    }
    
    private void updatePacmanDirection() {
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }
    }
}
