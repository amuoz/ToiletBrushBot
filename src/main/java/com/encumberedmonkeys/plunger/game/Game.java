package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.game.entities.items.Item;
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
		level = new Cabin(this);
	}

	public Entity getEntity(String name) {
		for (Entity object : player.getInventory()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		for (Entity object : level.getObjects()) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		return null;
	}

	public List<Entity> getAllEntities() {
		List<Entity> result = new ArrayList<>();
		List<Item> inventory = player.getInventory();
		if(inventory != null) result.addAll(inventory);
		List<Entity> objects = level.getObjects();
		if(objects != null) result.addAll(objects);
		return result;
	}

}
