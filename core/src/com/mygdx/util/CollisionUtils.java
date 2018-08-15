package com.mygdx.util;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.screens.gamestate.entities.Ground;
import com.mygdx.screens.gamestate.entities.Player;

public class CollisionUtils implements ContactListener{
	private Player player;
	
	public CollisionUtils(Player player) {
		this.player = player;
	}
	
	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();	

		if(fixA.getBody().getUserData() instanceof Player) {
			if(fixB.getBody().getUserData() instanceof Ground) {
				player.setCanJump(true);
			}
		}
		
		if(fixB.getBody().getUserData() instanceof Ground) {
			if(fixA.getBody().getUserData() instanceof Player) {
				player.setCanJump(true);
			}
		}
			
		
	}

	@Override
	public void endContact(Contact contact) {
		
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();	
		
		
		if(fixA.getBody().getUserData() instanceof Player) {
			if(fixB.getBody().getUserData() instanceof Ground) {
				player.setCanJump(false);
			}
		}
		
		if(fixB.getBody().getUserData() instanceof Ground) {
			if(fixA.getBody().getUserData() instanceof Player) {
				player.setCanJump(false);
			}
		}
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {	
	}

	@Override
	public void preSolve(Contact contact, Manifold manifold) {	
	}

}
