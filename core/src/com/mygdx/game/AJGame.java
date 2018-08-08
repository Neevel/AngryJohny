package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screens.gamestate.GameState;


public class AJGame extends Game {
	private SpriteBatch batch;
	
	@Override
	public void create() {
		batch = new SpriteBatch(); // verwaltet einen Buffer 
		setScreen(new GameState()); 
	}
	
	@Override
	public void dispose() {
		batch.dispose(); // nach dem zeichnen wird die batch sozusagen entsorgt 
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	
}