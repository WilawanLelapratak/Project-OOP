package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private MyGdxGame myGdxGame;
	
	private Texture pacmanImg;
	
	private MazeRenderer mazeRenderer;
	
	private Pacman pacman;
	
	public static final int BLOCK_SIZE = 40;
	private BitmapFont font;

	World world;
	
    public WorldRenderer(MyGdxGame myGdxGame, World world) {
        this.myGdxGame = myGdxGame;
        
        mazeRenderer = new MazeRenderer(myGdxGame.batch, world.getMaze());
        
        this.pacman = world.getPacman();
        
        SpriteBatch batch;
        
        batch = myGdxGame.batch;
 
        this.world = world;
 
        pacmanImg = new Texture("pacman.png");
        
        font = new BitmapFont();
    }
	
	public void render(float delta) {
		mazeRenderer.render();
		SpriteBatch batch = myGdxGame.batch;
		Vector2 pos = world.getPacman().getPosition();
		batch.begin();
		batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, MyGdxGame.HEIGHT -pos.y - BLOCK_SIZE/2);
		font.draw(batch,  "" + world.getScore(), 700, 60);
		batch.end();
	}

}
