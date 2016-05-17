package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Cordoneras extends Item {

	public Cordoneras(Game game) {
		super(game);
		this.catchable = true;
	}

	@Override
	public String getName() {
		return getMsg("cordoneras.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("cordoneras.examine"));
	}

	@Override
	public void use() {
		sendMessageToUser(getMsg("item.noMsg"));
	}

	@Override
	public void use(Item item) {
		item.use(this);
	}

	@Override
	public void talk() {}
}
