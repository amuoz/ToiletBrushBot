package com.encumberedmonkeys.plunger.game.items;

import java.util.Random;

import com.encumberedmonkeys.plunger.game.Game;

import lombok.Getter;

public class Papel extends Item {

	@Getter
	private final String name = gameResources.getString("papel.name");
	@Getter
	private final String letrinaName = gameResources.getString("letrina.name");
	@Getter
	private final String examinePapelMsg = gameResources.getString("papel.examinePapelMsg");
	@Getter
	private final String usePapelCuloSucioMsg = gameResources.getString("papel.usePapelCuloSucioMsg");
	@Getter
	private final String usePapelCuloLimpioMsg = gameResources.getString("papel.usePapelCuloLimpioMsg");
	@Getter
	private final String usePapelNoInventarioMsg = gameResources.getString("papel.usePapelNoInventarioMsg");
	@Getter
	private final String pickPapelMsg = gameResources.getString("papel.pickPapelMsg");
	@Getter
	private final String pickPapelNoMsg = gameResources.getString("papel.pickPapelNoMsg");
	@Getter
	private final String talk1Msg = gameResources.getString("papel.talk1Msg");
	@Getter
	private final String talk2Msg = gameResources.getString("papel.talk2Msg");
	@Getter
	private final String talk3Msg = gameResources.getString("papel.talk3Msg");
	@Getter
	private final String talk4Msg = gameResources.getString("papel.talk4Msg");
	@Getter
	private final String talk5Msg = gameResources.getString("papel.talk5Msg");
	@Getter
	private final String talkNoMsg = gameResources.getString("papel.talkNoMsg");

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
