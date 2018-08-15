package com.mygdx.screens.gamestate.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.mygdx.screens.gamestate.GameListener;

public class Player extends Entity {

	private boolean canJump;
	private GameListener input;
	private Animation walk;
	private TextureRegion[][] regions_walk;
	private Array<TextureRegion> walkframes;
	private PlayerState playerState;

	private float stateTime;

	public Player(Body body, GameListener input) {
		super(body);
		regions_walk = TextureRegion.split(new Texture(Gdx.files.internal("textures/playerWalk.png")), 250, 281);
		walkframes = new Array<TextureRegion>();
		fillArray();
		walk = new Animation(0.1f,walkframes , Animation.PlayMode.LOOP);
		playerState = PlayerState.RUNRIGHT;

		
		this.input = input;
	}
	public void fillArray(){
		for(int i = 0; i < regions_walk.length; i++){
			for(int j = 0; j < regions_walk[0].length; j++){
				walkframes.add(regions_walk[i][j]);

			}
		}
	}

	@Override
	public void update(float delta) {
		position = body.getPosition();
		
		if(input.getKeys()[Keys.A]) {
			body.applyLinearImpulse(new Vector2(-1.5f, 0f), body.getWorldCenter(), true);
		}
		
		if(input.getKeys()[Keys.D]) {
			body.applyLinearImpulse(new Vector2(1.5f, 0f), body.getWorldCenter(), true);
		}
		
		if(input.getKeys()[Keys.W]) {
			if(getCanJump()) {
				body.applyLinearImpulse(new Vector2(0, 120f), body.getWorldCenter(), true);
				setCanJump(false);
			}	
		}
		body.setLinearDamping(10f);
		stateTime += delta;




	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
		batch.draw(walk.getKeyFrame(stateTime), position.x - width / 2, position.y - height / 2, width, height);
	}
	
	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public boolean getCanJump() {
		return canJump;
	}
	
}
