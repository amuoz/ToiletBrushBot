package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.services.LocalisationService;
import lombok.Getter;

public class Letrina extends Item {

	@Getter
	private final String name = LocalisationService.getInstance().getString("letrina.name");
	@Getter
	private final String examineBeforeShitMsg = LocalisationService.getInstance().getString("letrina.examineBeforeShitMsg");
	@Getter
	private final String examineAfterShitMsg = LocalisationService.getInstance().getString("letrina.examineAfterShitMsg");
	@Getter
	private final String useBeforeShitMsg = LocalisationService.getInstance().getString("letrina.useBeforeShitMsg");
	@Getter
	private final String useAfterShitMsg = LocalisationService.getInstance().getString("letrina.useAfterShitMsg");
	@Getter
	private final String pickLetrinaMsg = LocalisationService.getInstance().getString("letrina.pickLetrinaMsg");
	@Getter
	private final String talkLetrinaMsg = LocalisationService.getInstance().getString("letrina.talkLetrinaMsg");

	@Getter
	private boolean usada;

	public Letrina() {
		usada = false;
	}

	@Override
	public String examine() {
		if (!usada)
			return getExamineBeforeShitMsg();
		return getExamineAfterShitMsg();
	}

	@Override
	public String use() {

		// marcamos como usada primera vez
		if (!usada) {
			usada = true;
			return getUseBeforeShitMsg();
		}
		return getUseAfterShitMsg();
	}

	@Override
	public String pick() {
		return getPickLetrinaMsg();
	}

	@Override
	public String talk() {
		return getTalkLetrinaMsg();
	}

}
