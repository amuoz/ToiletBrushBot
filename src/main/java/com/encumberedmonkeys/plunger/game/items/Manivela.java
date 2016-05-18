package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

import lombok.Getter;
import lombok.Setter;

public class Manivela extends Item {

	@Getter
	@Setter
	private boolean rota;

	public Manivela(Game game) {
		super(game);
		// por defecto la manivela funciona
		rota = false;
	}

	@Override
	public String getName() {
		return getMsg("manivela.name");
	}

	@Override
	public void examine() {
		if (!rota) {
			sendMessageToUser(getMsg("manivela.examine"));
		} else {
			sendMessageToUser(getMsg("manivela.examine2"));
		}

	}

	@Override
	public void use(Item item) {
		if (!rota) {
			if (item.getName().equals(getMsg("gancho.name"))) {
				item.use(this);
			}
		}

	}

}
