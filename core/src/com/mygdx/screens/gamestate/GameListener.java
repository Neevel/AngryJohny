package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.screens.gamestate.entities.Player;

public class GameListener extends InputAdapter {
	
	private Player player;
	private Body body;
	
	public GameListener(Player player) {
		this.player = player;
		body = player.getBody();
	}

	@Override
	public boolean keyDown(int key) {
		body.setLinearDamping(10f);
		
		if((key == Keys.A | key == Keys.LEFT)) {
			body.applyLinearImpulse(new Vector2(-1.5f, -0.4f), body.getWorldCenter(), true);
		}
		
		if((key == Keys.D | key == Keys.RIGHT)) {
			body.applyLinearImpulse(new Vector2(1.5f, -0.4f), body.getWorldCenter(), true);
		}
		
		if(key == Keys.W | key == Keys.UP) {
			if(player.getCanJump()) {
				body.applyLinearImpulse(new Vector2(0, 45f), getBody().getWorldCenter(), true);
				player.setCanJump(false);
			}	
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int key) {
		if(key == Keys.A | key == Keys.LEFT) {
			
		}
		if(key == Keys.D | key == Keys.RIGHT) {
			
		}
		return false;
	}

}
