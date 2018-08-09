package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AJGame;
import com.mygdx.util.Constants;


public class GameWorld {
	
	private SpriteBatch batch; 
	private Camera gameCam; 
	private Viewport viewport; 
	private World world; 
	private Box2DDebugRenderer b2renderer; 
	
	private Body player;
	
	
	public GameWorld() {
		batch = ((AJGame) Gdx.app.getApplicationListener()).getBatch(); 
		gameCam = new OrthographicCamera(); 
		viewport = new FitViewport(Constants.V_WIDTH , Constants.V_HEIGHT, gameCam); 
		world = new World(Constants.GRAVITY, true); 
		b2renderer = new Box2DDebugRenderer(); 
		
		//player = Box2DUtils.createPlayer();
	}

	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 0, 0, 0);
		Gdx.gl20.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);
		
		gameCam.update();
		
		world.step(Constants.TIME_STEP, 8, 3); // 
		
		b2renderer.render(world, viewport.getCamera().combined);
		
//		batch.setProjectionMatrix(viewport.getCamera().combined);
//		batch.begin();
//			
//		batch.end();
	}
	
	public void update(float delta) {
		
	}
	
	public void dispose() {
				
	}
	public void  resize(int width, int height) {
		viewport.update(width, height, true);
		
		
	}
}
