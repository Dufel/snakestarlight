package com.dufel.snakes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dufel.snakes.SnakeStarlightGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 570;
		config.height = 600;
		new LwjglApplication( new SnakeStarlightGame(), config );
	}
}
