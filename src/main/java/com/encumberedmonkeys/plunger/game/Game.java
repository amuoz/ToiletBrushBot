package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.game.levels.Cabin;
import com.encumberedmonkeys.plunger.game.levels.Level;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Game {
	@Getter
	private Player player;
	@Getter
	private Level level;

	public Game() {
		player = new Player();
		level = new Cabin();
	}

	public Item getItem(String name) {
		for (Item object : player.getInventory()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		for (Item object : level.getObjects()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		return null;
	}

	public List<Item> getAllItems() {
		List<Item> result = new ArrayList<>();
		List<Item> inventory = player.getInventory();
		if(inventory != null) result.addAll(inventory);
		List<Item> objects = level.getObjects();
		if(objects != null) result.addAll(objects);
		return result;
	}

}
