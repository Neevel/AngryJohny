package com.mygdx.screens.gamestate.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Entity {
	
	protected Vector2 position;
	protected Texture tex;
	protected Body body;
	protected float width, height;
	
	public Entity(Body body) {
		this.body = body;
		this.position = body.getPosition();
		body.setUserData(this);
	}
	
	public abstract void update(float delta);
	public abstract void render(float delta, SpriteBatch batch);

	public Vector2 getPosition() {
		return position;
	}

	public Body getBody() {
		return body;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

}
