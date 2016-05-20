package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

import lombok.Data;

@Data
public abstract class Action {
	protected String command;
	protected Entity first;
	protected Entity second;
	protected Game game;

	public abstract void execute();
}
