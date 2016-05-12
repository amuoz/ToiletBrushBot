package com.encumberedmonkeys.plunger.game.items;

import lombok.Getter;

public class Letrina extends Item {

	@Getter
	private final String name = gameResources.getString("letrina.name");
	@Getter
	private final String examineBeforeShitMsg = gameResources.getString("letrina.examineBeforeShitMsg");
	@Getter
	private final String examineAfterShitMsg = gameResources.getString("letrina.examineAfterShitMsg");
	@Getter
	private final String useBeforeShitMsg = gameResources.getString("letrina.useBeforeShitMsg");
	@Getter
	private final String useAfterShitMsg = gameResources.getString("letrina.useAfterShitMsg");
	@Getter
	private final String pickLetrinaMsg = gameResources.getString("letrina.pickLetrinaMsg");
	@Getter
	private final String talkLetrinaMsg = gameResources.getString("letrina.talkLetrinaMsg");

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
