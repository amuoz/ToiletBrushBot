package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Manivela extends Item {

	public Manivela(Game game) {
		super(game);
	}

	@Override
	public String getName() {
		return getMsg("manivela.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("manivela.examine"));
	}

	@Override
	public void use() {}

	@Override
	public void use(Item item) {
		if (item.getName().equals(getMsg("gancho.name"))) {
			item.use(this);
		}
	}

	@Override
	public void talk() {}
}
