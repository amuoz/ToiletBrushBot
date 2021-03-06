package com.encumberedmonkeys.plunger.game.entities.items;

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

}
