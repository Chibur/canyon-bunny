package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {

	private static boolean rebuildAtlas = false;
	private static boolean drawDebugLines = false;

	public static void main(String[] args) {
		if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.debug = drawDebugLines;

			TexturePacker2.process(settings, "assets-raw/images", "../CanyonBunny-android/assets/images", "canyonbunny.pack");
			TexturePacker2.process(settings, "assets-raw/images-ui", "../CanyonBunny-android/assets/images", "canyonbunny-ui.pack");
		}

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CanyonBunny";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 480;

		new LwjglApplication(new CanyonBunnyMain(), cfg);
	}

}
