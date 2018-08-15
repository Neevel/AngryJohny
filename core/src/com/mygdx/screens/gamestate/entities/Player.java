package com.mygdx.screens.gamestate.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

	private boolean canJump;

	public Player(Body body) {
		super(body);
	}

	@Override
	public void update(float delta) {
				
	}

	@Override
	public void render(float delta, SpriteBatch batch) {
		// player zeichnen
	}
	
	// Methode die unsere Tastatureingaben verarbeitet
	private void handleInput(float delta) {
		// Anweisung wenn der Spieler links läuft
		if (left) {
			
		}
		// Anweisung wenn der Spieler rechts läuft
		if (right) {
			body.setLinearDamping(10f);
			
		}
		// Anweisung wenn der Spieler springt läuft
		if (jump) {
			body.setLinearDamping(10f);
			
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

	public boolean getCanJump() {
		return canJump;
	}

}
