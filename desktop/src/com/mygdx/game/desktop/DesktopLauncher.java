package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.AJGame;
import com.mygdx.util.constants.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		// LWGL ist ein Wrapper über OPENGL
		// LibGdx ist ein Wrapper über Lwjgl
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.TITLE;
		config.width = Constants.WIDTH;
		config.height = Constants.HEIGHT;
		new LwjglApplication(new AJGame(), config);
	}
}
