package com.mygdx.screens.gamestateö.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

	private boolean left, right, jump, canJump;

	public Player(Body body) {
		super(body);
	}

	@Override
	public void update(float delta) {
		handleInput(delta);
		
	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
	}
	
	// Methode die unsere Tastatureingaben verarbeitet
	private void handleInput(float delta) {
		// Anweisung wenn der Spieler links läuft
		if (left) {
			body.setLinearDamping(10f);
			body.applyLinearImpulse(new Vector2(-1.5f, -0.4f), body.getWorldCenter(), true);
		}
		// Anweisung wenn der Spieler rechts läuft
		if (right) {
			body.setLinearDamping(10f);
			body.applyLinearImpulse(new Vector2(1.5f, -0.4f), body.getWorldCenter(), true);
		}
		// Anweisung wenn der Spieler springt läuft
		if (jump) {
			body.setLinearDamping(10f);
			body.applyLinearImpulse(new Vector2(0, 45f), getBody().getWorldCenter(), true);
			Jump(false);
		}
		// Anweisung wenn der Spieler im Sprung ist
		if (!canJump) {
			body.applyLinearImpulse(new Vector2(0, -1f), getBody().getWorldCenter(), true);
		}
	}
	
	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public void Jump(boolean isJumping) {
		this.jump = isJumping;
	}

	public void setLeft(boolean direction) {
		this.left = direction;
	}

	public void setRight(boolean direction) {
		this.right = direction;
	}

	public boolean getCanJump() {
		return canJump;
	}

}
