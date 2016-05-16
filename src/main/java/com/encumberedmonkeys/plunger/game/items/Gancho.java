package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Gancho extends Item {

	public Gancho(Game game) {
		super(game);
		this.catchable = true;
	}

	@Override
	public String getName() {
		return getMsg("gancho.name");
	}

	@Override
	public String examine() {
		return getMsg("gancho.examine");
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
