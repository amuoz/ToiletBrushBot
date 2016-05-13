package com.encumberedmonkeys.plunger.game.items;

import java.util.Random;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Papel extends Item {

	private boolean enInventario;

	private Game game;

	public Papel() {
		enInventario = false;
	}

	public Papel(Game game) {
		this();
		this.game = game;
	}

	@Override
	public String getName() {
		return LocalisationService.getInstance().getString("papel.name");
	}

	@Override
	public String examine() {
		return LocalisationService.getInstance().getString("papel.examinePapelMsg");
	}

	@Override
	public void use() {
		if (enInventario) {

			Letrina letrina = (Letrina) game.getItem(LocalisationService.getInstance().getString("letrina.name"));
			// si hemos cagado nos limpiamos
			if (letrina.isUsada()) {
				game.getPlayer().getInventory().remove(this);
				sendMessageToUser(LocalisationService.getInstance().getString("papel.usePapelCuloSucioMsg"));
			} else {
				sendMessageToUser(LocalisationService.getInstance().getString("papel.usePapelCuloLimpioMsg"));
			}

		} else {
			sendMessageToUser(LocalisationService.getInstance().getString("papel.usePapelNoInventarioMsg"));
		}
	}

	@Override
	public String pick() {
		if (!enInventario) {
			// insertar en el invetario
			enInventario = true;
			game.getPlayer().getInventory().add(this);
			// quitar del level
			game.getLevel().getObjects().remove(this);

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
