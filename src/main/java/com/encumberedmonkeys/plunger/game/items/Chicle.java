package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Chicle extends Item {

	public Chicle(Game game) {
		super(game);
		this.catchable = false;
		this.enInventario = true;
	}

	@Override
	public String getName() {
		return getMsg("chicle.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("chicle.examine"));
	}

	@Override
	public void use(Item item) {
		// TODO Auto-generated method stub
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

}