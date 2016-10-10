package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World {
	
	static Pacman pacman;
	
	private MyGdxGame myGdxGame;
	
	World(MyGdxGame myGdxGame) {
		this.myGdxGame = myGdxGame;
		
		pacman = new Pacman(100, 100);
	}
	Pacman getPacman() {
		return pacman;
	}

	void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.move(Pacman.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            pacman.move(Pacman.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	pacman.move(Pacman.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	pacman.move(Pacman.DIRECTION_RIGHT);
        }
    }

}
