package com.mygdx.screens.gamestate;


import com.badlogic.gdx.ScreenAdapter;


public class GameScreen extends ScreenAdapter{
	private GameWorld gameworld;
	private GameRenderer gamerenderer;
	
	@Override
	public void show() {
		gameworld = new GameWorld();
		gamerenderer = new GameRenderer(gameworld);
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	// Kombiniert update und render
	public void render(float delta) {
		gameworld.update(delta); // update und
		gamerenderer.render(delta); // render werden getrennt 
		
	}

	@Override
	public void resize(int width, int height) {
	}

}
