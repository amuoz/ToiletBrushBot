package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.Getter;

public class Papel extends Item {

	@Getter
	private final String examinePapelMsg = gameResources.getString("papel.examinePapelMsg");
	@Getter
	private final String usePapelSucioMsg = gameResources.getString("papel.usePapelSucioMsg");
	@Getter
	private final String usePapelLimpioMsg = gameResources.getString("papel.usePapelLimpioMsg");
	@Getter
	private final String pickPapelMsg = gameResources.getString("papel.pickPapelMsg");

	private boolean usado = false;
	private boolean cogido = false;

	public Papel() {
		this.name = gameResources.getString("papel.name");

		examineMsg = getExaminePapelMsg();
		useMsg = getUsePapelSucioMsg();
		pickMsg = getPickPapelMsg();
	}

	@Override
	public void examine() {
		ToiletBrushHandler.getInstance().sendMessageToUser(examineMsg);
	}

	@Override
	public void use() {
		ToiletBrushHandler.getInstance().sendMessageToUser(useMsg);
		if (!usado) {
			useMsg = getUsePapelLimpioMsg();
			usado = true;
		}
	}

	@Override
	public void pick() {
		Game.getInstance().getPlayer().getInventory().add(this);
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub

	}

}
