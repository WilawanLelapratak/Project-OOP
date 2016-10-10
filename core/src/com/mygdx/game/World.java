package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World {
	
	static Pacman pacman;
	
	private MyGdxGame myGdxGame;
	
	private Maze maze;
	
	World(MyGdxGame myGdxGame) {
		this.myGdxGame = myGdxGame;
		
		pacman = new Pacman(60,60);
		
		maze = new Maze();
	}
	Pacman getPacman() {
		return pacman;
	}
	
	Maze getMaze() {
		return maze;
	}

	void update(float delta) {
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
		pacman.update();
    }

}
