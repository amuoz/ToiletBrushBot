package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Foto extends Item {

	public Foto(Game game) {
		super(game);
		this.catchable = true;
	}

	@Override
	public String getName() {
		return getMsg("foto.name");
	}

	@Override
	public String examine() {
		return getMsg("foto.examine");
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
