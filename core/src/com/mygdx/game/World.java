package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World {
	
	static Pacman pacman;
	
	private MyGdxGame myGdxGame;
	
	private Maze maze;
	
	private int score;
	
	World(MyGdxGame myGdxGame) {
		this.myGdxGame = myGdxGame;
		
		pacman = new Pacman(60,60,this);
		
		maze = new Maze();
		
		score = 0;
		
		registerDotEattenListener();
	}
	Pacman getPacman() {
		return pacman;
	}
	
	Maze getMaze() {
		return maze;
	}

	void update(float delta) {
		pacman.update();
    }
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore() {
		score += 1;
	}
	
	private void registerDotEattenListener() {
        pacman.registerDotEattenListener(new Pacman.DotEattenListener() {
            @Override
            public void notifyDotEatten() {
                score += 1;
            }
        });
    }

}
