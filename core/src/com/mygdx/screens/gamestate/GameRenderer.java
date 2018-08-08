package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameRenderer {
	private GameWorld gameworld;
	
	public GameRenderer(GameWorld gameworld) {
		this.gameworld = gameworld;
	}
	
	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 0, 1, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		System.out.println("RENDER");
	}
	
}
