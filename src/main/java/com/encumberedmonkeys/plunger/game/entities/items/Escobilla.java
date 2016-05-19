package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

public class Escobilla extends Item {

	public Escobilla(Game game) {
		super(game);
		this.catchable = true;
	}

	@Override
	public String getName() {
		return getMsg("escobilla.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("escobilla.examine"));
	}

	@Override
	public void use() {
		sendMessageToUser(getMsg("escobilla.use"));
	}

	@Override
	public void use(Entity entity) {

		// desaparece escobilla del inventario o escena
		if (enInventario) {
			game.getPlayer().getInventory().remove(this);
		} else {
			game.getLevel().getObjects().remove(this);
		}

		// desaparece cordoneras del inventario o escena
		if (entity instanceof Item && ((Item) entity).enInventario) {
			game.getPlayer().getInventory().remove(entity);
		} else {
			game.getLevel().getObjects().remove(entity);
		}

		// se crea un gancho
		game.getPlayer().getInventory().add(new Gancho(game));

		sendMessageToUser(getMsg("gancho.new"));
	}

}
