package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import com.encumberedmonkeys.plunger.game.items.Item;

import lombok.Getter;
import lombok.Setter;

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
