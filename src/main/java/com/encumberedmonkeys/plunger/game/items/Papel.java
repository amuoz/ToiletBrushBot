package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocalisationService;
import lombok.Getter;

import java.util.Random;

public class Papel extends Item {

	@Getter
	private final String name = LocalisationService.getInstance().getString("papel.name");
	@Getter
	private final String letrinaName = LocalisationService.getInstance().getString("letrina.name");
	@Getter
	private final String examinePapelMsg = LocalisationService.getInstance().getString("papel.examinePapelMsg");
	@Getter
	private final String usePapelCuloSucioMsg = LocalisationService.getInstance().getString("papel.usePapelCuloSucioMsg");
	@Getter
	private final String usePapelCuloLimpioMsg = LocalisationService.getInstance().getString("papel.usePapelCuloLimpioMsg");
	@Getter
	private final String usePapelNoInventarioMsg = LocalisationService.getInstance().getString("papel.usePapelNoInventarioMsg");
	@Getter
	private final String pickPapelMsg = LocalisationService.getInstance().getString("papel.pickPapelMsg");
	@Getter
	private final String pickPapelNoMsg = LocalisationService.getInstance().getString("papel.pickPapelNoMsg");
	@Getter
	private final String talk1Msg = LocalisationService.getInstance().getString("papel.talk1Msg");
	@Getter
	private final String talk2Msg = LocalisationService.getInstance().getString("papel.talk2Msg");
	@Getter
	private final String talk3Msg = LocalisationService.getInstance().getString("papel.talk3Msg");
	@Getter
	private final String talk4Msg = LocalisationService.getInstance().getString("papel.talk4Msg");
	@Getter
	private final String talk5Msg = LocalisationService.getInstance().getString("papel.talk5Msg");
	@Getter
	private final String talkNoMsg = LocalisationService.getInstance().getString("papel.talkNoMsg");

	private boolean enInventario;

	public Papel() {
		enInventario = false;
	}

	@Override
	public String examine() {
		return getExaminePapelMsg();
	}

	@Override
	public String use() {
		if (enInventario) {

			Letrina letrina = (Letrina) Game.getInstance().getItem(letrinaName);
			// si hemos cagado nos limpiamos
			if (letrina.isUsada()) {
				Game.getInstance().getPlayer().getInventory().remove(this);
				return getUsePapelCuloSucioMsg();
			} else {
				return getUsePapelCuloLimpioMsg();
			}

		} else {
			return getUsePapelNoInventarioMsg();
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

			return getPickPapelMsg();
		}
		return getPickPapelNoMsg();

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
			return getTalk1Msg();
		case 2:
			return getTalk2Msg();
		case 3:
			return getTalk3Msg();
		case 4:
			return getTalk4Msg();
		case 5:
			return getTalk5Msg();
		default:
			return getTalkNoMsg();
		}
	}

}
