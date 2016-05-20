package com.encumberedmonkeys.plunger.game.entities.character;

import java.util.HashMap;

import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Character {

	public Pelo(Game game) {
		super(game);

		dialogs = new HashMap<String, Dialog>();
		Dialog dPelo1 = this.dialogMapper("dialog/dPelo1.md");
		dialogs.put(dPelo1.getName(), dPelo1);
		Dialog dPelo2 = this.dialogMapper("dialog/dPelo2.md");
		dialogs.put(dPelo2.getName(), dPelo2);

		start = dPelo1.getName();
	}

	@Override
	public String getName() {
		return getMsg("pelo.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("pelo.examine"));
	}
}
