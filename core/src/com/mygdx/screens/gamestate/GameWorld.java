package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AJGame;
import com.mygdx.screens.gamestateö.entities.GameListener;
import com.mygdx.screens.gamestateö.entities.Ground;
import com.mygdx.screens.gamestateö.entities.Player;
import com.mygdx.util.Box2DUtils;
import com.mygdx.util.CollisionUtils;
import com.mygdx.util.Constants;

public class GameWorld {
	
	private SpriteBatch batch;
	private Camera gameCam; 
	private Viewport viewport; 
	private World world; 
	private Box2DDebugRenderer b2renderer; 
	
	private Player player;
	private Ground ground;
	
	private GameListener input;
	
	public GameWorld() {
		batch = ((AJGame) Gdx.app.getApplicationListener()).getBatch(); 
		gameCam = new OrthographicCamera(); 
		viewport = new FitViewport(Constants.V_WIDTH , Constants.V_HEIGHT, gameCam); 
		world = new World(Constants.GRAVITY, true); 
		player = new Player(Box2DUtils.createPlayer(world, new Vector2(3, 5), 1, 1));
		ground = new Ground(Box2DUtils.createGround(world, new Vector2(Constants.V_WIDTH/2, 2), Constants.V_WIDTH, 1));
			
		b2renderer = new Box2DDebugRenderer(); 
		
		input = new GameListener(player);
		
		world.setContactListener(new CollisionUtils(player));
		Gdx.input.setInputProcessor(input);
	}

	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 0);
		Gdx.gl20.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);
		
		gameCam.position.set(player.getPosition(), 0);
		gameCam.update();
		
		b2renderer.render(world, viewport.getCamera().combined);
		
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();

		batch.end();
	}
	
	public void update(float delta) {
		player.update(delta);
		world.step(Constants.TIME_STEP, 8, 3);
	}
	
	public void dispose() {
				
	}
	public void  resize(int width, int height) {
		viewport.update(width, height, true);
		
		
	}
}
