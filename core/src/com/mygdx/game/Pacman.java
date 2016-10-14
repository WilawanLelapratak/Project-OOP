package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Pacman {
	
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    private int currentDirection;
    private int nextDirection;
    private World world;
	
	private Vector2 position;
	
	public Pacman(int x, int y, World world) {
		position = new Vector2(x,y);
		currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        this.world = world;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
	
	public void move(int dir) { 
        switch(dir) {
        case DIRECTION_UP:
            position.y += 10 * DIR_OFFSETS[dir][1];
            break;
        case DIRECTION_RIGHT:
            position.x += 10 * DIR_OFFSETS[dir][0];
            break;
        case DIRECTION_DOWN:
            position.y += 10 * DIR_OFFSETS[dir][1];
            break;
        case DIRECTION_LEFT:
            position.x += 10 * DIR_OFFSETS[dir][0];
            break;
        }
    }
	
	public void update() {
		Maze maze = world.getMaze();
		this.setNextDirection(Pacman.DIRECTION_STILL);
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			this.setNextDirection(Pacman.DIRECTION_UP);
        }
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            this.setNextDirection(Pacman.DIRECTION_DOWN);
        }
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	this.setNextDirection(Pacman.DIRECTION_LEFT);
        }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	this.setNextDirection(Pacman.DIRECTION_RIGHT);
        }
        
		if(isAtCenter()) {
			
            if(canMoveInDirection(nextDirection)) {
            	if(Maze.hasDotAt(getRow(),getColumn())) {
                	Maze.removeDotAt(getRow(),getColumn());
                	world.increaseScore();
            	}
                currentDirection = nextDirection;
                //world.increaseScore();
                
            }else {
                currentDirection = DIRECTION_STILL;    
            }
        }
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
        position.y += SPEED * DIR_OFFSETS[currentDirection][1];
    }
	
	public boolean isAtCenter() {
        int blockSize = WorldRenderer.BLOCK_SIZE;
 
        return ((((int)position.x - blockSize/2) % blockSize) == 0) && ((((int)position.y - blockSize/2) % blockSize) == 0);
    }
	
	private boolean canMoveInDirection(int dir) {
		Maze maze = world.getMaze();
		int newRow = getRow() + DIR_OFFSETS[dir][1];
		int newCol = getColumn() + DIR_OFFSETS[dir][0];
		if(Maze.hasWallAt(newRow,newCol)){
			return false;
		}
		
        return true;   // ยอมหมดไปก่อน เดี๋ยวเราจะทยอยเขียน
    }
	
	private int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
 
    private int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
}

