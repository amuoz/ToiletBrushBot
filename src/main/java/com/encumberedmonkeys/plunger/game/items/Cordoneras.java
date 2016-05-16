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
		// reutilizar use de escobille
		item.use(this);
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

}
