package com.mygdx.mrnom.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.mrnom.MrNom;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 480;
        config.width = 320;
        config.resizable = true;
		new LwjglApplication(new MrNom(), config);
	}
}
