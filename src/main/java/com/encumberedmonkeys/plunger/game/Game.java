package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.game.items.Letrina;
import com.encumberedmonkeys.plunger.game.items.Papel;

public class Game {

	public static final Game GAME = new Game();

	public static Game getInstance() {
		return GAME;
	}

	private Player player;

	private List<Item> items;

	public Game() {
		player = new Player();

		items = new ArrayList<Item>();
		items.add(new Letrina());
		items.add(new Papel());
	}

	/**
	 * Devuelve el objeto con el nombre pasado como parámetro. Si no existe se
	 * devuelve nulo.
	 * 
	 * @param nombre
	 *            Nombre del objeto.
	 * @return Objeto encontrado o null.
	 */
	public Item getItem(String name) {
		// Recorremos items buscando por nombre
		for (Item item : items) {
			if (item.getNombre().equals(name)) {
				return item;
			}
		}
		return null;
	}

}
