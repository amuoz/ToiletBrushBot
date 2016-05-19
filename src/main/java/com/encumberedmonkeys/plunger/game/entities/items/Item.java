package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

public abstract class Item extends Entity {

	protected boolean enInventario;
	protected boolean catchable;

	public Item(Game game) {
		this.game = game;
		this.catchable = false;
		this.enInventario = false;
	}

	public void pick() {
		// si el objeto es cogible
		if (catchable) {
			if (!enInventario) {
				// insertar en el invetario
				enInventario = true;
				game.getPlayer().getInventory().add(this);
				// quitar del level
				game.getLevel().getObjects().remove(this);

				sendMessageToUser(getPickMsg());
			} else {
				sendMessageToUser(getNoPickInventoryMsg());
			}
		} else {
			sendMessageToUser(getImpossibleMsg());
		}
	}

	public void examine() {
		sendMessageToUser(getImpossibleMsg());
	}

	public void use() {
		sendMessageToUser(getImpossibleMsg());
	}

	public void use(Entity entity) {
		sendMessageToUser(getImpossibleMsg());
	}

	public void talk() {
		sendMessageToUser(getNoMsg());
	}

	public void talk(Integer dialog) {
		sendMessageToUser(getNoMsg());
	}
}
