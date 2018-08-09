package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AJGame;
import com.mygdx.util.Box2DUtils;
import com.mygdx.util.Constants;


public class GameWorld {
	
	private SpriteBatch batch; 
	private Camera gameCam; 
	private Viewport viewport; 
	private World world; 
	private Box2DDebugRenderer b2renderer; 
	
	private Body player;
	private Body ground;
	
	
	public GameWorld() {
		batch = ((AJGame) Gdx.app.getApplicationListener()).getBatch(); 
		gameCam = new OrthographicCamera(); 
		viewport = new FitViewport(Constants.V_WIDTH , Constants.V_HEIGHT, gameCam); 
		world = new World(Constants.GRAVITY, true); 
		player = Box2DUtils.createPlayer(world, new Vector2(7, 10), 1, 1);
		ground = Box2DUtils.createGround(world, new Vector2(Constants.V_WIDTH/2, 1), Constants.V_WIDTH, 1);
			
		b2renderer = new Box2DDebugRenderer(); 
		
		
	}

	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 0);
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
