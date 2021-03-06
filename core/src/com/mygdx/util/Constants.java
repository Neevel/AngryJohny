package com.mygdx.util;

import com.badlogic.gdx.math.Vector2;

public class Constants {
	// Fensterkonstanten
	public static final String TITLE = "AngryJohny 0.1v deltacool";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	// Virtuellesfenster
	public static final float V_WIDTH = 20;
	public static final float V_HEIGHT = 15;
	public static final float PPM = WIDTH/V_WIDTH;
	
	// Box2D
	public static final float TIME_STEP = 1 / 60f; 
	public static final Vector2 GRAVITY = new Vector2(0, -9.81f*PPM); // ist im reallife auch so stark :D
	
}
