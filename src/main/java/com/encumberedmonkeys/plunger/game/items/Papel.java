package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.Getter;

public class Papel extends Item {

	@Getter
	private final String examinePapelMsg = "Un rollo de papel sagrado, como el que usa ZEUS para cagar.";
	@Getter
	private final String usePapelSucioMsg = "¡OOhhh si, culito limpito!\n\n¡LO LOGRASTE! HAS FINALIZADO LA VERSIÓN DE PRUEBA DE SUPER ESCOBILLA.\n\nGracias por jugar.";
	@Getter
	private final String usePapelLimpioMsg = "¿Por qué? Mi culete ya está limpio.";
	@Getter
	private final String pickPapelMsg = "Ugggh, está un poco pringado.";

	private boolean usado = false;
	private boolean cogido = false;

	public Papel() {
		this.name = "papel";

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
