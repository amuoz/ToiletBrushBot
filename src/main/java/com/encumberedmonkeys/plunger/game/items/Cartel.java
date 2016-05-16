package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Cartel extends Item {

	public Cartel(Game game) {
		super(game);
	}

	@Override
	public String getName() {
		return getMsg("cartel.name");
	}

	@Override
	public void examine() {
		sendPhotoToUser(getMsg("img.cartel"));
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
