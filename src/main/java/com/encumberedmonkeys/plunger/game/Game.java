package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.game.levels.Cabin;
import com.encumberedmonkeys.plunger.game.levels.Level;

import lombok.Getter;

public class Game {

	public static final Game GAME = new Game();

	public static Game getInstance() {
		return GAME;
	}

	@Getter
	private Player player;

	@Getter
	private Level level;

	private Game() {
		player = new Player();
		level = new Cabin();
	}

	public Item getItem(String name) {
		// podemos interactuar con objetos del nivel
		for (Item object : level.getObjects()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}

		// transparentemente podemos interactuar con objetos del inventario
		for (Item object : player.getInventory()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}

		return null;
	}

}
