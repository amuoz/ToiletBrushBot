package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.services.LocationService;

public class Use extends Action {
	public Use(Game game, Entity first) {
		this.command = LocationService.getInstance().getString("command.use");
		this.first = first;
		this.game = game;
	}

	@Override
	public void execute() {
		first.use();
	}
}
