package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private MyGdxGame myGdxGame;
	
	private Texture pacmanImg;
	
	private Pacman pacman;

	World world;
	
    public WorldRenderer(MyGdxGame myGdxGame, World world) {
        this.myGdxGame = myGdxGame;
        
        this.pacman = world.getPacman();
        
        SpriteBatch batch;
        
        batch = myGdxGame.batch;
 
        this.world = world;
 
        pacmanImg = new Texture("pacman.png");
    }
	
	public void render(float delta) {
		SpriteBatch batch = myGdxGame.batch;
		batch.begin();
		Vector2 pos = pacman.getPosition();
		batch.draw(pacmanImg, pos.x, pos.y);
		batch.end();
	}

}
