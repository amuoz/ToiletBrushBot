package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocalisationService;
import lombok.Getter;

import java.util.Random;

public class Papel extends Item {

	private boolean enInventario;

	public Papel() {
		enInventario = false;
	}

	@Override
	public String getName(){
		return LocalisationService.getInstance().getString("papel.name");
	}

	@Override
	public String examine() {
		return LocalisationService.getInstance().getString("papel.examinePapelMsg");
	}

	@Override
	public String use() {
		if (enInventario) {

			Letrina letrina = (Letrina) Game.getInstance().getItem(LocalisationService.getInstance().getString("letrina.name"));
			// si hemos cagado nos limpiamos
			if (letrina.isUsada()) {
				Game.getInstance().getPlayer().getInventory().remove(this);
				return LocalisationService.getInstance().getString("papel.usePapelCuloSucioMsg");
			} else {
				return LocalisationService.getInstance().getString("papel.usePapelCuloLimpioMsg");
			}

		} else {
			return LocalisationService.getInstance().getString("papel.usePapelNoInventarioMsg");
		}
	}

	@Override
	public String pick() {
		if (!enInventario) {
			// insertar en el invetario
			enInventario = true;
			Game.getInstance().getPlayer().getInventory().add(this);
			// quitar del level
			Game.getInstance().getLevel().getObjects().remove(this);

			return LocalisationService.getInstance().getString("papel.pickPapelMsg");
		}
		return LocalisationService.getInstance().getString("papel.pickPapelNoMsg");

	}

	@Override
	public String talk() {
		return getTalkMsg();
	}

	private String getTalkMsg() {
		int max = 6;
		int min = 1;
		Random rand = new Random();
		Integer result = rand.nextInt(max - min + 1) + min;
		switch (result) {
		case 1:
			return LocalisationService.getInstance().getString("papel.talk1Msg");
		case 2:
			return LocalisationService.getInstance().getString("papel.talk2Msg");
		case 3:
			return LocalisationService.getInstance().getString("papel.talk3Msg");
		case 4:
			return LocalisationService.getInstance().getString("papel.talk4Msg");
		case 5:
			return LocalisationService.getInstance().getString("papel.talk5Msg");
		default:
			return LocalisationService.getInstance().getString("papel.talkNoMsg");
		}
	}

}
