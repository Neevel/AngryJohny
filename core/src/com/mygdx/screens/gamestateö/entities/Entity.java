package com.mygdx.screens.gamestateö.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Entity {
	
	protected Vector2 position;
	protected Texture tex;
	protected Body body;
	
	public Entity(Body body) {
		this.body = body;
		this.position = body.getPosition();
		body.setUserData(this);
	}
	
	protected abstract void update(float delta);
	protected abstract void render(float delta, SpriteBatch batch);

	public Vector2 getPosition() {
		return position;
	}

	public Texture getTex() {
		return tex;
	}

	public Body getBody() {
		return body;
	}


}
