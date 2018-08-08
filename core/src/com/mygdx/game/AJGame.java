package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screens.gamestate.GameState;


public class AJGame extends Game {
	private SpriteBatch batch;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new GameState());
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	
}