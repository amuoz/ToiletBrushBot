package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import com.encumberedmonkeys.plunger.game.items.Item;

import lombok.Getter;

public class Player {
	@Getter
	private List<Item> inventory;

	public Player() {
		inventory = new ArrayList<Item>();
	}
}
