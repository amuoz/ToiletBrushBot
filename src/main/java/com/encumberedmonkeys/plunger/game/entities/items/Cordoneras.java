package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

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
	public void use(Entity entity) {
		entity.use(this);
	}

}
