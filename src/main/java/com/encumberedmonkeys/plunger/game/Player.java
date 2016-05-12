package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.game.items.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Player {
	@Getter
	private List<Item> inventory;

	public Player() {
		inventory = new ArrayList<>();
	}
}
