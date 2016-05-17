package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Gancho extends Item {

	public Gancho(Game game) {
		super(game);
		this.catchable = false;
		this.enInventario = true;
	}

	@Override
	public String getName() {
		return getMsg("gancho.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("gancho.examine"));
	}

	@Override
	public void use() {}

	@Override
	public void use(Item item) {
		if (item.getName().equals(getMsg("manivela.name"))) {
			// me desatasco
			game.getPlayer().setAtascado(false);
			
			game.getPlayer().getInventory().remove(this);
			game.getLevel().getObjects().remove(item);
			sendMessageToUser(getMsg("plunger.desatascado"));
		} else {
			sendMessageToUser(getMsg("item.noMsg"));
		}
	}

	@Override
	public void talk() {}
}
