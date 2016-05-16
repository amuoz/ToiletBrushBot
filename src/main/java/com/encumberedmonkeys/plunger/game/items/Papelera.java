package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Papelera extends Item {

	private boolean examinada;

	public Papelera(Game game) {
		super(game);
		examinada = false;
	}

	@Override
	public String getName() {
		return getMsg("papelera.name");
	}

	@Override
	public void examine() {
		if (game.getPlayer().isAtascado()) {
			sendMessageToUser(getMsg("papelera.examine1"));
		} else {
			if (!examinada) {
				examinada = true;
				game.getPlayer().getInventory().add(new Foto(game));
				sendMessageToUser(getMsg("papelera.examine2"));
			} else {
				sendMessageToUser(getMsg("papelera.examine3"));
			}

		}
	}

	@Override
	public void use(Item item) {
		// TODO Auto-generated method stub
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

}
