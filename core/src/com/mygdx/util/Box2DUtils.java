package com.mygdx.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DUtils {
	
	public static Body createPlayer(World world, Vector2 position, float width, float height) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(position);
		bdef.type = BodyDef.BodyType.DynamicBody;
		
		Body body = world.createBody(bdef);
		createBox(body, width, height, 0.5f, 0, 0);
		
		return body;
	}
	
	public static void createBox(Body body, float width, float height, float density, float restitution, float friction) {
		FixtureDef fdef = new FixtureDef();
		PolygonShape shape = new PolygonShape();

		shape.setAsBox(width/2, height/2);
		fdef.shape = shape;
		fdef.density = density;
		fdef.restitution = restitution;
		fdef.friction = friction;
		
		body.createFixture(fdef);
		shape.dispose();
	}
	
	public static void createCircle(Body body, float radius, float density, float restitution, float friction) {
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		
		shape.setRadius(radius);
		fdef.shape = shape;
		fdef.density = density;
		fdef.restitution = restitution;
		fdef.friction = friction;
		
		body.createFixture(fdef);
		shape.dispose();
	}
	
	public static Body createGround(World world, Vector2 position, float width, float height, float friction) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(position);
		bdef.type = BodyDef.BodyType.StaticBody;
		
		Body body = world.createBody(bdef);
		createBox(body, width, height, 1, 0, friction);

		return body;
	}

	
}
