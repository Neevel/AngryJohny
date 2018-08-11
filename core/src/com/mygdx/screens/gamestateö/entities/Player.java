package com.mygdx.screens.gamestateö.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {
	
	public Player(Body body) {
		super(body);
	}

	@Override
	protected void update(float delta) {
		
	}

	@Override
	protected void render(float delta, SpriteBatch batch) {
	}
	
	public void setX(float xPosition) {
		position.x = xPosition;
		body.setTransform(position, 0f);
	}

}
