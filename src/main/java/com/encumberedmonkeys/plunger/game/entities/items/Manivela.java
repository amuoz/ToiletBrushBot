package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;
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
	public void use(Entity entity) {
		if (!rota) {
			if (entity.getName().equals(getMsg("gancho.name"))) {
				entity.use(this);
			}
		}

	}

}
