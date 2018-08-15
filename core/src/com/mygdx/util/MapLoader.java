package com.mygdx.util;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapLoader {
	private static TiledMap map;
	
	public static void loadMap(String level) {
		TmxMapLoader maploader = new TmxMapLoader();
		map = maploader.load(level +".tmx");
	}
	
	public static TiledMap getMap(String level) {
		return map;
	}
	
	public static void mapDispose() {
		map.dispose();
	}
	
}
