package com.mygdx.screens.gamestateö.entities;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameListener extends InputAdapter {
	
	private Player player;
	
	public GameListener(Player player) {
		this.player = player;
	}

	@Override
	public boolean keyDown(int key) {
		if(key == Keys.A) {
			player.setLeft(true);
		}
		if(key == Keys.D) {
			player.setRight(true);
		}
		return false;
	}

	@Override
	public boolean keyUp(int key) {
		if(key == Keys.A) {
			player.setLeft(false);
		}
		if(key == Keys.D) {
			player.setRight(false);
		}
		return false;
	}

}
