package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AJGame;

public class HUD {
	
	private GameWorld gameworld;
	private Viewport viewport;
	
	private Stage stage;
	
	public HUD(GameWorld gameworld) {
		this.gameworld = gameworld;
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(viewport, ((AJGame) Gdx.app.getApplicationListener()).getBatch());
		
		createHUD();
	}
	
	public void dispose() {
		
	}

	public void update(float delta) {
		stage.act(delta);
	}

	public void render() {
		stage.draw();
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	private void createHUD() {
		//penis
	}

}
