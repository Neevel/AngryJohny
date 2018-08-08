package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AJGame;


public class GameWorld {
	private Texture tex; 
	private SpriteBatch batch; 
	
	public GameWorld() {
		tex = new Texture(Gdx.files.internal("1.png")); 
		batch = ((AJGame) Gdx.app.getApplicationListener()).getBatch(); 
	}

	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 0, 0, 0);
		Gdx.gl20.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
			batch.draw(tex, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}
	
	public void update(float delta) {
		System.out.println("UPDATE");
	}
	public void dispose() {
		
	}
	public void  resize(int width, int height) {
		
	}
}
