package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.services.LocationService;

public class Speaking extends Action {

	private Integer dialog;

	public Speaking(Game game, Entity first, Integer dialog) {
		this.command = LocationService.getInstance().getString("command.talk");
		this.first = first;
		this.game = game;
		this.dialog = dialog;
	}

	@Override
	public void execute() {
		first.talk(dialog);
	}
}
