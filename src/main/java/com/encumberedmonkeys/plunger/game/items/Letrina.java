package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.Getter;

public class Letrina extends Item {

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

	private boolean usada;

	public Letrina() {
		name = gameResources.getString("letrina.name");

		useMsg = getUseBeforeShitMsg();
		examineMsg = getExamineBeforeShitMsg();
		pickMsg = getPickLetrinaMsg();

		usada = false; // inicialmente al usar letrina caga
	}

	@Override
	public void examine() {
		ToiletBrushHandler.getInstance().sendMessageToUser(examineMsg);
	}

	@Override
	public void use() {
		ToiletBrushHandler.getInstance().sendMessageToUser(useMsg);

		// La primera vez que se usa
		if (!usada) {
			useMsg = getUseAfterShitMsg();
			examineMsg = getExamineAfterShitMsg();
			usada = true;
		}
	}

	@Override
	public void pick() {
		ToiletBrushHandler.getInstance().sendMessageToUser(pickMsg);
	}

	public void talk() {
		ToiletBrushHandler.getInstance().sendMessageToUser(getTalkLetrinaMsg());
	}

}
