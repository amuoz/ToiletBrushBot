package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.game.levels.Cabin;
import com.encumberedmonkeys.plunger.game.levels.Level;

public class Game {

	public static final Game GAME = new Game();

	public static Game getInstance() {
		return GAME;
	}

	private Player player;

	private Level level;

	public Game() {
		player = new Player();
		level = new Cabin();
	}

	public Item getItem(String name) {
		for (Item object : level.getObjects()) {
			if (object.getNombre().equals(name)) {
				return object;
			}
		}
		return null;
	}

}
