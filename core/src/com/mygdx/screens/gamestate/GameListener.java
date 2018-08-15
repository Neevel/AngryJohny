package com.mygdx.screens.gamestate;

import com.badlogic.gdx.InputAdapter;

public class GameListener extends InputAdapter {
	
	private boolean[] keys;
	
	public GameListener() {
		keys = new boolean[256];
	}

	@Override
	public boolean keyDown(int key) {
		keys[key] = true;
		
		return false;
	}

	@Override
	public boolean keyUp(int key) {
		keys[key] = false;
		return false;
	}
	
	public boolean[] getKeys() {
		return keys;
	}

}
