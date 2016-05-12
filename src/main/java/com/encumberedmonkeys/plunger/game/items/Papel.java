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
<<<<<<< HEAD
		this.name = "papel";

		examineMsg = getExaminePapelMsg();
		useMsg = getUsePapelSucioMsg();
		pickMsg = getPickPapelMsg();
	}

	@Override
	public void examine() {
		ToiletBrushHandler.getInstance().sendMessageToUser(examineMsg);
=======
		this.nombre = gameResources.getString("papel.name");
		this.examinar = gameResources.getString("papel.examine");
		this.usarActivo = gameResources.getString("papel.activeUse");
		this.usarInactivo = gameResources.getString("papel.inactiveUse");
		this.activo = false;
		this.coger = true;
		this.loTengo = false;
>>>>>>> branch 'master' of https://github.com/amuoz/ToiletBrushBot
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
