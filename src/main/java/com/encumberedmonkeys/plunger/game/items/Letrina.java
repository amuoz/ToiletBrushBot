package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.services.LocalisationService;

import lombok.Getter;

public class Letrina extends Item {
	@Getter
	private boolean usada;

	public Letrina() {
		usada = false;
	}

	@Override
	public String getName() {
		return LocalisationService.getInstance().getString("letrina.name");
	}

	@Override
	public String examine() {
		if (!usada) {
			return LocalisationService.getInstance().getString("letrina.examineBeforeShitMsg");
		}
		return LocalisationService.getInstance().getString("letrina.examineAfterShitMsg");
	}

	@Override
	public void use() {
		if (!usada) {
			usada = true;
			sendKeyboardMessageToUser(LocalisationService.getInstance().getString("letrina.useBeforeShitMsg"));
		} else {
			sendMessageToUser(LocalisationService.getInstance().getString("letrina.useAfterShitMsg"));
		}
	}

	@Override
	public String pick() {
		return LocalisationService.getInstance().getString("letrina.pickLetrinaMsg");
	}

	@Override
	public String talk() {
		return LocalisationService.getInstance().getString("letrina.talkLetrinaMsg");
	}

}
