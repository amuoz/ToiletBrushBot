package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Puerta extends Item {

	public Puerta(Game game) {
		super(game);
	}

	@Override
	public String getName() {
		return getMsg("puerta.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("puerta.examine"));
	}

	@Override
	public void use() {
		sendMessageToUser(getMsg("puerta.use"));
	}

	@Override
	public void use(Item item) {}

	@Override
	public void talk() {}
}
