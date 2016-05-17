package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			List<List<String>> keyboard = new ArrayList<>();
			keyboard.add(Arrays.asList("CAGAR"));
			sendKeyboardMessageToUser(getMsg("letrina.useBeforeShitMsg"), keyboard);
		} else {
			sendMessageToUser(getMsg("letrina.useAfterShitMsg"));
		}
	}

	@Override
	public void pick() {
		sendMessageToUser(getMsg("letrina.pickLetrinaMsg"));
	}

	@Override
	public void talk() {
		sendMessageToUser(getMsg("letrina.talkLetrinaMsg"));
	}

	@Override
	public void use(Item item) {
	}
}
