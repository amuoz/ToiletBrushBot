package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

import lombok.Getter;

public class Letrina extends Item {
	@Getter
	private boolean usada;

	public Letrina(Game game) {
		super(game);
		usada = false;
	}

	@Override
	public String getName() {
		return getMsg("letrina.name");
	}

	@Override
	public void examine() {
		if (!usada) {
			sendMessageToUser(getMsg("letrina.examineBeforeShitMsg"));
		}
		sendMessageToUser(getMsg("letrina.examineAfterShitMsg"));
	}

	@Override
	public void use() {
		if (!usada) {
			usada = true;
			sendKeyboardMessageToUser(getMsg("letrina.useBeforeShitMsg"));
		} else {
			sendMessageToUser(getMsg("letrina.useAfterShitMsg"));
		}
	}

	@Override
	public String pick() {
		return getMsg("letrina.pickLetrinaMsg");
	}

	@Override
	public String talk() {
		return getMsg("letrina.talkLetrinaMsg");
	}

	@Override
	public void use(Item item) {
		// TODO Auto-generated method stub

	}

}
