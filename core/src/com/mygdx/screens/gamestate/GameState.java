package com.mygdx.screens.gamestate;


import com.badlogic.gdx.ScreenAdapter;


public class GameState extends ScreenAdapter{
	private GameWorld gameworld;
	
	
	@Override
	public void show() {
		gameworld = new GameWorld();
		
	}
	
	@Override
	public void dispose() {
		gameworld.dispose();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	// Kombiniert update und render
	public void render(float delta) {
		gameworld.update(delta); 
		gameworld.render(delta);
		
		
	}

	@Override
	public void resize(int width, int height) {
		gameworld.resize(width, height);
		
	}

}
