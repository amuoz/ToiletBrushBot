package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.entities.items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Player {

	@Getter
	private List<Item> inventory;

	@Getter
	@Setter
	private boolean atascado;

	public Player() {
		inventory = new ArrayList<Item>();
		atascado = true;
	}

}
