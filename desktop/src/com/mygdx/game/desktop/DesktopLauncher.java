package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void  main  (String[] arg) {

		//Borderless Window
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

		//Configurations for Desktop Version



		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.resizable=false;
		cfg.height = 720;
		cfg.width = 1280;
		cfg.foregroundFPS=60;
		cfg.vSyncEnabled=true;
		cfg.fullscreen=true;
		cfg.title="Danky Qazi";
        cfg.addIcon("dankyicon.jpg", Files.FileType.Internal);
		new LwjglApplication(new MyGdxGame(), cfg);

	}
}