package com.mygdx.screens.gamestate;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class GameState extends ScreenAdapter{
	
	private GameWorld gameworld;
	private HUD hud;


	
	
	@Override
	public void show() {
		gameworld = new GameWorld();
		hud = new HUD(gameworld);
	}
	
	@Override
	public void dispose() {
		gameworld.dispose();
		hud.dispose();
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
		
		hud.update(delta);
		hud.render();
	}

	@Override
	public void resize(int width, int height) {
		gameworld.resize(width, height);
		hud.resize(width, height);
		
	}

}
