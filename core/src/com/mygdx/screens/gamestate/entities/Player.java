package com.mygdx.screens.gamestate.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.mygdx.screens.gamestate.GameListener;

public class Player extends Entity { 

	private boolean canJump;
	private GameListener input;

	private Animation walk;
	private Animation shoot;

	private TextureRegion[][] regions_walk;
	private TextureRegion[][] regions_Shoot;

	private Array<TextureRegion> walkframes;
	private Array<TextureRegion> shootframes;





	private boolean isShoot;

	private float stateTime;

	public Player(Body body, GameListener input) {
		super(body);
		tex = new Texture(Gdx.files.internal("textures/playerWalk.png"));
		regions_walk = TextureRegion.split(tex, 250, 281);
		walkframes = new Array<TextureRegion>();

		fillArray(regions_walk, walkframes);
		walk = new Animation(0.1f,walkframes , Animation.PlayMode.LOOP);



		tex = new Texture(Gdx.files.internal("textures/playerShoot.png"));
		regions_Shoot = TextureRegion.split(tex, 250, 281);
		shootframes = new Array<TextureRegion>();
		fillArray(regions_Shoot, shootframes);
		shoot = new Animation(0.1f,shootframes , Animation.PlayMode.NORMAL);
		
		this.input = input;

    }
	
	public void fillArray(TextureRegion[][] regions, Array<TextureRegion> frames){
		for(int i = 0; i < regions.length; i++){
			for(int j = 0; j < regions[0].length; j++){
				frames.add(regions[i][j]);
			}
		}

	}

	@Override
	public void update(float delta) {
		position = body.getPosition();
		
		if(input.getKeys()[Keys.A]) {
			walk.setPlayMode(Animation.PlayMode.LOOP);
			body.applyLinearImpulse(new Vector2(-2.5f, 0f), body.getWorldCenter(), true);

			if(!(walk.getKeyFrame(stateTime)).isFlipX()) {
				(walk.getKeyFrame(stateTime)).flip(true, false);

							}

		}else if(!input.getKeys()[Keys.A] ){
			walk.setPlayMode(Animation.PlayMode.NORMAL);
		}else if(!input.getKeys()[Keys.D]) {
			walk.setPlayMode(Animation.PlayMode.NORMAL);

		}
		
		if(input.getKeys()[Keys.D]) {

			walk.setPlayMode(Animation.PlayMode.LOOP);
			body.applyLinearImpulse(new Vector2(2.5f, 0f), body.getWorldCenter(), true);
			if ((walk.getKeyFrame(stateTime)).isFlipX()) {
				(walk.getKeyFrame(stateTime)).flip(true, false);

			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			if(getCanJump()) {
				body.applyLinearImpulse(new Vector2(0, 70f), body.getWorldCenter(), true);

				setCanJump(false);
			}	
		}
		body.setLinearDamping(5f);


				if (input.getKeys()[Keys.E]) {
					if((shoot.getKeyFrame(stateTime)).isFlipX()) {
						(shoot.getKeyFrame(stateTime)).flip(true, false);
					}else
					if(!(shoot.getKeyFrame(stateTime)).isFlipX()) {
						(shoot.getKeyFrame(stateTime)).flip(false, false);
					}


					isShoot = true;
					shoot.setPlayMode(Animation.PlayMode.LOOP);
				}else
				isShoot = false;
				stateTime += delta;


	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
		if(!isShoot) {
			batch.draw(walk.getKeyFrame(stateTime), position.x - width / 2, position.y - height / 2, width, height);
		}else

		batch.draw(shoot.getKeyFrame(stateTime), position.x - width / 2, position.y - height / 2, width, height);
	}
	
	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public boolean getCanJump() {
		return canJump;
	}
	
}
