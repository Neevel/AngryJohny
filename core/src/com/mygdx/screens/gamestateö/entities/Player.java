package com.mygdx.screens.gamestateö.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {
	
	private boolean left, right;
	
	public Player(Body body) {
		super(body);
	}

	@Override
	public void update(float delta) {
		// bewegung
		if(left) {
			body.setLinearVelocity(-.75f, 0f);
		}
		if(right) {
			body.setLinearVelocity(.75f, 0f);
		}
	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
	}
	
	public void setLeft(boolean direction) {
		this.left = direction;
	}
	
	public void setRight(boolean direction) {
		this.right = direction;
	}
}
