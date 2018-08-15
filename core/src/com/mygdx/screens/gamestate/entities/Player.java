package com.mygdx.screens.gamestate.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.screens.gamestate.GameListener;

public class Player extends Entity {

	private boolean canJump;
	private GameListener input;

	public Player(Body body, GameListener input) {
		super(body);
		
		tex = new Texture(Gdx.files.internal("textures/player.png"));
		
		this.input = input;
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
				body.applyLinearImpulse(new Vector2(0, 30f), body.getWorldCenter(), true);
				setCanJump(false);
			}	
		}
		body.setLinearDamping(10f);
	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
		batch.draw(tex, position.x - width / 2, position.y - height / 2, width, height);
	}
	
	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public boolean getCanJump() {
		return canJump;
	}
	
}
